package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.rank.Rank;

public class WinningNumber {

    private static final String DUPLICATE_BONUS_BALL = "보너스볼은 중복될 수 없습니다.";

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningNumber(Lotto lotto, LottoNumber bonus) {
        validateWinningNumber(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateWinningNumber(Lotto lotto, LottoNumber bonus) {
        if (isDuplicateLottoNumber(lotto, bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_BALL);
        }
    }

    private boolean isDuplicateLottoNumber(Lotto lotto, LottoNumber bonus) {
        return lotto.getNumbers().stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList())
            .contains(bonus.getNumber());
    }

    public Lotto getWinningLotto() {
        return this.lotto;
    }

    public LottoNumber getBonusNumber() {
        return this.bonus;
    }

    public Rank compareTo(List<Integer> targetLotto) {
        List<Integer> winningNumbers = lotto.getNumbers().stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        int matchCount = (int) targetLotto.stream()
            .filter(lottoNumber -> isContain(winningNumbers, lottoNumber))
            .count();

        return getRank(targetLotto, matchCount);
    }

    private Rank getRank(List<Integer> targetLotto, int matchCount) {
        return Rank.of(matchCount, isContain(targetLotto, bonus.getNumber()));
    }

    private boolean isContain(List<Integer> targetLotto, int lottoNumber) {
        return targetLotto.contains(lottoNumber);
    }
}

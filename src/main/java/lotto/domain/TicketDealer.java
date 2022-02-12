package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.machine.LottoGenerator;

public class TicketDealer {

    private static final int ONE = 1;

    public static Lottos getLottosOf(LottoGenerator lottoGenerator, final int ticketCount) {
        List<Lotto> lottos = IntStream.rangeClosed(ONE, ticketCount)
            .mapToObj(index -> lottoGenerator.get().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()))
            .map(Lotto::new)
            .collect(Collectors.toList());

        return new Lottos(lottos);
    }
}

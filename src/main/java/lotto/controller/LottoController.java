package lotto.controller;

import java.util.List;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lottos;
import lotto.domain.ticket.Money;
import lotto.domain.ticket.PurchaseTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        OutputView outputView = new OutputView();

        Money money = getMoney();
        PurchaseTicket ticket = new PurchaseTicket(money, getManualCount());
        Lottos lottos = ticket.purchase(getManualLottoNumbers(ticket));

        outputView.printPurchaseAmount(ticket);
        outputView.printPurchaseTicket(lottos);

        WinningNumber winningNumber = InputView.makeWinningNumber();
        WinningResult winningResult = new WinningResult(lottos, winningNumber);
        winningResult.calculateYield(ticket.getBuyCash());

        outputView.printWinningResult(winningResult);
    }

    private Money getMoney() {
        try {
            return new Money(InputView.getMoney());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getMoney();
        }
    }

    private int getManualCount() {
        return InputView.getManualTicketCount();
    }

    private List<List<Integer>> getManualLottoNumbers(final PurchaseTicket ticket) {
        return InputView.getManualLottoNumbers(ticket.getBuyManualCount());
    }
}

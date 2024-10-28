package racingcar

import racingcar.model.CarMovement
import racingcar.model.StringNamesParser
import racingcar.model.WinnerCheck
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {
    fun run() {
        val carNames = InputView.carName()
        val tryCount = InputView.tryCount()
        val stringNamesParser = StringNamesParser()
        stringNamesParser.parser(carNames)
        val carMovement = CarMovement(stringNamesParser.currentStatus)
        repeat(tryCount) {
            val racingResult = carMovement.carAction()
            OutputView.currentStatusPrint(racingResult)
        }
        val winners = WinnerCheck.pickWinner(stringNamesParser.currentStatus)
        OutputView.winnerPrint(winners)
    }
}
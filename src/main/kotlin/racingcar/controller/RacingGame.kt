package racingcar

import racingcar.model.CarMovement
import racingcar.model.StringNamesParser
import racingcar.view.InputView

class RacingGame {
    fun run() {
        val carNames = InputView.carName()
        val tryCount = InputView.tryCount()
        val stringNamesParser = StringNamesParser()
        stringNamesParser.parser(carNames)
        val carMovement = CarMovement(stringNamesParser.currentStatus)
        repeat(tryCount) {
            val racingResult = carMovement.carAction()
            //TODO: 라운드 출력 구현
        }
    }
}
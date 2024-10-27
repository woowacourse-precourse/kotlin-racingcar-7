package racingcar

import racingcar.model.StringNamesParser
import racingcar.view.InputView

class RacingGame {
    fun run(){
        val carNames = InputView.carName()
        val tryCount = InputView.tryCount()
        val stringNamesParser = StringNamesParser()
        stringNamesParser.parser(carNames)
        repeat(tryCount){
            //TODO: CarMovement.kt구현 후 호출
        }
    }
}
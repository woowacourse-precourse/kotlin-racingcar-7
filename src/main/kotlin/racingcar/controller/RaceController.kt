package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Error
import racingcar.model.Race
import racingcar.view.ErrorMsg
import racingcar.view.Input
import racingcar.view.Output

class RaceController {
    private val input = Input()
    private val output = Output()

    fun run() {
        val error = Error()
        val errorMsg = ErrorMsg()

        input.carNameMsg()
        val carNames = Console.readLine()
        if (error.carNameError(carNames)) errorMsg.errorMsg()

        input.countMsg()
        val tryCount = Console.readLine()
        if (error.tryCountError(tryCount)) errorMsg.errorMsg()

        gameResult(carNames, tryCount)
    }

    private fun gameResult(carNames: String, tryCount: String) {
        val race = Race(carNames, tryCount.toInt())
        race.start()
        output.resultMsg(race.carList, tryCount.toInt())
        output.winnerMsg(race.getWinners())
    }
}

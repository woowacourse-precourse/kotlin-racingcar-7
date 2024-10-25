package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Race
import racingcar.model.carNameError
import racingcar.model.tryCountError
import racingcar.view.ErrorMsg
import racingcar.view.Input
import racingcar.view.Output

class RaceController {
    private val input = Input()
    private val output = Output()
    private val errorMsg = ErrorMsg()

    fun run() {
        input.carNameMsg()
        val carNames = Console.readLine()
        if (carNameError(carNames)) errorMsg.errorMsg()

        input.countMsg()
        val tryCount = Console.readLine()
        if (tryCountError(tryCount)) errorMsg.errorMsg()

        gameResult(carNames, tryCount)
    }

    private fun gameResult(carNames: String, tryCount: String) {
        val race = Race(carNames, tryCount.toInt())
        race.start()
        output.resultMsg(race.carList, tryCount.toInt())
        output.winnerMsg(race.getWinners())
    }
}

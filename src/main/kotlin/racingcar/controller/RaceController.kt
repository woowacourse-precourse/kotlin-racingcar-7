package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
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

        input.countMsg()
        val tryCount = Console.readLine().toInt()

        val race = Race(carNames, tryCount)
        race.start()
        output.resultMsg(race.carList, tryCount)
        output.winnerMsg(race.getWinners())
    }
}

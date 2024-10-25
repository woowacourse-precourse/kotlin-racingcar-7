package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Make
import racingcar.model.carNameError
import racingcar.model.tryCountError
import racingcar.view.ErrorMsg
import racingcar.view.Input
import racingcar.view.Output

class RaceController {
    private val input = Input()
    private val output = Output()
    private val errorMsg = ErrorMsg()

    private fun result(carNames: String, tryCount: String) {
        val make = Make(carNames, tryCount.toInt())
        val result = make.moveByNameList
        val carNameList = make.carNameList

        output.resultMsg(carNameList, result)
        output.winnerMsg(make.winnerList())
    }

    fun run() {
        input.carNameMsg()
        val carNames = Console.readLine()
        if (carNameError(carNames)) errorMsg.errorMsg()

        input.countMsg()
        val tryCount = Console.readLine()
        if (tryCountError(tryCount)) errorMsg.errorMsg()

        result(carNames, tryCount)
    }
}

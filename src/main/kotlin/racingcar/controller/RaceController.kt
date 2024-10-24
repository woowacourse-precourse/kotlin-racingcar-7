package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Error
import racingcar.model.Make
import racingcar.view.ErrorMsg
import racingcar.view.Input
import racingcar.view.Output

class RaceController {
    private val input = Input()
    private val output = Output()
    private val errorMsg = ErrorMsg()

    private fun result(carNames: String, count: String) {
        if (!Error(carNames, count).totalError()) {
            val make = Make(carNames, count.toInt())
            val result = make.moveByNameList
            val carNameList = make.carNameList

            output.resultMsg(carNameList, result)
            output.winnerMsg(make.winnerList())
            return
        }
        errorMsg.errorMsg()
    }

    fun run() {
        input.carNameMsg()
        val carNames = Console.readLine()
        input.countMsg()
        val count = Console.readLine()

        result(carNames, count)
    }
}

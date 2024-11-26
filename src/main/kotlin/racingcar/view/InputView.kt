package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {
    fun getCars(): String {
        println(MSG_GET_CARS)
        return Console.readLine()
    }

    fun getTryNumber(): String {
        println(MSG_GET_TRY_NUM)
        return Console.readLine()
    }

    companion object {
        const val MSG_GET_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val MSG_GET_TRY_NUM = "시도할 횟수는 몇 회인가요?"
    }
}
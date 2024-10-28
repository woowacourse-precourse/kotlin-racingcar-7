package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCarNames(): String {
        println(CAR_NAMES_LABEL)
        return Console.readLine()
    }

    fun readTimes(): String {
        println(TIMES_LABEL)
        return Console.readLine()
    }

    companion object {
        const val CAR_NAMES_LABEL = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val TIMES_LABEL = "시도할 횟수는 몇 회인가요?"
    }
}
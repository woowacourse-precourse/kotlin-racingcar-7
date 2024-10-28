package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarNames(): List<String> {
        println(GET_CAR_NAMES)
        return Console.readLine().split(",").map { it.trim() }
    }

    fun getRoundCount(): Int {
        println(GET_ROUND_COUNT)
        return Console.readLine().toInt()
    }

    companion object {
        const val GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val GET_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}
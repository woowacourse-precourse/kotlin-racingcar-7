package racingcar

import camp.nextstep.edu.missionutils.Console

const val CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

fun getCarNames(): List<String> {
    println(CAR_NAME_REQUEST_MESSAGE)
    val input = Console.readLine()

    return input.split(",")
}


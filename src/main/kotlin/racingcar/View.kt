package racingcar

import camp.nextstep.edu.missionutils.Console

const val CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val TRY_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
const val RESULT_TITLE_MESSAGE = "실행 결과"
const val CAR_DRIVING_DISTANCE_MESSAGE_FORMAT = "%s : %s"
const val WINNER_CAR_NAME_RESULT_MESSAGE = "최종 우승자 : %s"
const val DASH_SEPARATOR = "-"
const val RESULT_SEPARATOR = ", "

fun getCarNames(): List<String> {
    println(CAR_NAME_REQUEST_MESSAGE)
    val input = Console.readLine()

    return splitComma(input)
}

fun getTryCount(): UInt {
    println(TRY_COUNT_REQUEST_MESSAGE)

    try {
        val input = Console.readLine().toUInt()

        return input
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 숫자가 입력되었습니다. 숫자가 맞는지, 너무 큰 숫자가 아닌지, 음수인지 확인해 주세요.")
    }
}

fun printResultTitle() {
    println(RESULT_TITLE_MESSAGE)
}

fun printCarDrivingDistance(cars: List<Car>) {
    for (car in cars) {
        val message = CAR_DRIVING_DISTANCE_MESSAGE_FORMAT.format(
            car.name,
            DASH_SEPARATOR.repeat(car.drivingDistance)
        )

        println(message)
    }

    println()
}

fun printWinnerName(cars: List<Car>) {
    val message = WINNER_CAR_NAME_RESULT_MESSAGE.format(
        cars.joinToString(RESULT_SEPARATOR) { it.name }
    )

    println(message)
}

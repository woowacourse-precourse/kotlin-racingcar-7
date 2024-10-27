package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println(RacingCarText.INPUT_CAR_NAME)
    val carsText = readLine()
    val cars = carsText.split(RacingCarDelimiters.NAME_DELIMITER)
    println(cars)
}

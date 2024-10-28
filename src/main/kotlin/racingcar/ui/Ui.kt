package racingcar.ui

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.CarName.Companion.asCarName
import racingcar.domain.validator.validateTryNumber
import java.math.BigInteger

class Ui {
    fun requestCarNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        val userInput = Console.readLine()
        return userInput.split(CAR_NAME_DELIMITER).map { it.asCarName() }
    }

    fun requestTryNumber(): BigInteger {
        println("시도할 횟수는 몇 회인가요?")

        try {
            val userInput = Console.readLine()
            return BigInteger(userInput).also { validateTryNumber(it) }
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    fun displayTryResult(cars: List<Car>) {
        val stringBuilder = StringBuilder()

        for (car in cars) {
            stringBuilder.append("${car.carName} : ")
            stringBuilder.repeat(DISTANCE_MARKER, car.distance)
            stringBuilder.append('\n')
        }

        println(stringBuilder.toString())
    }

    private fun StringBuilder.repeat(char: Char, times: Int): Unit = repeat(times) {
        append(char)
    }


    companion object {
        private const val CAR_NAME_DELIMITER = ','
        private const val DISTANCE_MARKER = '-'
    }
}

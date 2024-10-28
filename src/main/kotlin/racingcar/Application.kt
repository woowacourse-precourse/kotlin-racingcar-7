package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현
    val game = RacingGame()
    game.start()
}

class InputProcessor {
    fun inputCarNames(input: String? = null): List<String> {
        val carNamesInput = input ?: Console.readLine()
        println("자동차 이름을 쉼표(,)로 구분하여 입력하시오.")

        val carNames = carNamesInput.split(",").map { it.trim() }
        println("입력된 자동차 이름들: $carNames")

        println("예외 발생: 자동차 이름은 5자 이하가 가능함.") // 예외 발생 시 로그
        require(carNames.none { it.length > 5 }) { "자동차 이름은 5자 이하가 가능함." }

        return carNames
    }

    fun inputAttemptCount(input: String? = null): Int {
        val attemptCountInput = input ?: Console.readLine()
        println("시도할 횟수를 입력하시오.")

        val count = requireNotNull(attemptCountInput.toIntOrNull()) { "시도 횟수는 양의 정수여야 함." }
        require(count > 0) { "시도 횟수는 양의 정수여야 함." }

        return count
    }
}

class Car(val name: String) {
    var position: Int = 0

    fun move() {
        position++
    }
}

class RandomMoveCondition {
    fun shouldMove(): Boolean {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        return randomValue >= MOVING_FORWARD
    }

    companion object {
        const val MOVING_FORWARD = 4
        const val STOP = 3
    }
}

class OutputProcessor {
    fun printRaceProgress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        if (winners.size > 1) {
            println("최종 우승자 : ${winners.joinToString(", ")}")
        } else {
            println("최종 우승자 : ${winners.first()}")
        }
    }
}

class RacingGame {
    private lateinit var cars: List<Car>
    private var attemptCount: Int = 0

    fun start() {
        cars = InputProcessor().inputCarNames().map { Car(it) }
        attemptCount = InputProcessor().inputAttemptCount()
        println("실행 결과")
        race()
        OutputProcessor().printWinners(cars)
    }

    private fun race() {
        repeat(attemptCount) {
            cars.forEach { car ->
                if (RandomMoveCondition().shouldMove()) car.move()
            }
            OutputProcessor().printRaceProgress(cars)
        }
    }
}
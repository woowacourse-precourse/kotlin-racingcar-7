package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    CarRacingGame().startRace()
}

class CarRacingGame {
    private lateinit var cars: List<Car>
    private var attemptCount: Int = 0

    fun startRace() {
        cars = getCarNames()
        attemptCount = getAttemptCount()

        println("실행 결과")
        repeat(attemptCount) {
             raceRound()
             printRaceStatus()
        }
         printWinners()
    }

    private fun getCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine().split(",")
        require(names.all { it.length <= 5 && !it.contains(" ") }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능하며, 공백을 허용하지 않습니다.")
        }
        return names.map { Car(it) }
    }

    private fun getAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("횟수는 숫자여야 합니다.")
        require(count > 0) {
            throw IllegalArgumentException("횟수는 0보다 커야 합니다.")
        }
        return count
    }

    private fun raceRound() {
        cars.forEach { car ->
            car.moveForwardIfPossible()
        }
    }

    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    private fun printWinners() {
        val maxDistance = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == maxDistance }.joinToString(", ") { it.name }
        println("최종 우승자 : $winners")
    }
}

class Car(val name: String) {
    var distance = 0
        private set

    fun moveForwardIfPossible() {
        if (shouldMove()) {
            distance++
        }
    }

    private fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}
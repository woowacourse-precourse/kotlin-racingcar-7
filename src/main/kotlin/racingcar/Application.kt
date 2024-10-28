package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0)

fun main() {
    // TODO: 프로그램 구현

    val carNames = Input.getCarNames()
    val attempts = Input.getNumberOfAttempts()

    val cars = carNames.map { Car(it) }
    val game = CarRacingGame(cars, attempts)

    game.play()

    val winners = game.getWinners()

    Output.printWinners(winners)
}

// # 입력 기능 추가
object Input {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readLine().orEmpty()
        val carNames = input.split(",").map { it.trim() }
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자 이하만 가능합니다." }
        return carNames
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("정수 값만 입력 가능합니다.")
        require(input > 0) { "시도 횟수는 1회 이상이어야 합니다." }
        return input
    }
}

// # 자동차 경주 진행
class CarRacingGame(private val cars: List<Car>, private val attempts: Int) {
    fun play() {
        println("\n실행 결과")
        repeat(attempts) {
            cars.forEach { car ->
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.position++
                }
            }
            printRaceStatus()
        }
    }

    private fun printRaceStatus() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}

// # 출력 기능
object Output {
    fun printWinners(winners: List<String>) {
        if (winners.size == 1) {
            println("최종 우승자 : ${winners[0]}")
        } else {
            println("최종 우승자 : ${winners.joinToString(", ")}")
        }
    }
}

package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val game = Game()
    game.run()
}
class Game {
    fun run() {
        val carNames: List<String> = getCarNamesInput()
        val cars = carNames.map { Car(it) }
        val tryCount = getTryCountInput()

        val race = Race(cars, tryCount)
        race.start()
        race.printWinners()
    }

    private fun getCarNamesInput(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input: String = "pobi,woni,jun" // val input: String = Console.readLine()
        val carNames: List<String> = input.split(",")
        return carNames
    }

    private fun getTryCountInput(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount: Int = 5 // val tryCount: Int = Console.readLine().toInt()
        return tryCount
    }
}

class Race(val cars: List<Car>, val tryCount: Int) {
    fun start() {
        print("\n실행 결과\n")
        repeat(tryCount) {
            cars.forEach { it.stopOrMove() }
            printStatus()
        }
    }

    private fun printStatus() {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position.equals(maxPosition) }.joinToString(", ") { it.name }
        println("최종 우승자 : $winners")
    }
}

class Car(val name: String) {
    var position: Int = 0
        private set

    fun stopOrMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            position++
    }
}
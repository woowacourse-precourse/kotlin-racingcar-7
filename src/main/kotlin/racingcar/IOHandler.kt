package racingcar

import kotlin.math.round

class IOHandler {
    private val validation = Validation()

    fun startMatch(): Registaration {
        return Registaration(cars = registerCars(), decideNumberOfRound())
    }

    fun printRoundResult(roundResult: List<Result>) {
        val result = StringBuilder()

        for (car in roundResult) {
            val numberOfMoves = car.roundResult.last()

            result.append(car.carName, " : ", "-".repeat(numberOfMoves))
            println(result.toString())
            result.clear()
        }
        println()
    }

    fun printWinner(winnerList: List<Result>) {
        val winner = StringBuilder("최종 우승자 : ")

        winnerList.forEachIndexed { index, winnerInfo ->
            if (index != 0) {
                winner.append(", ")
            }
            winner.append(winnerInfo.carName)
        }
        println(winner.toString())
    }

    private fun registerCars(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        val registeredCars = readLine() ?: throw IllegalArgumentException()
        validation.isNotEmpty(registeredCars)
        return registeredCars
    }

    private fun decideNumberOfRound(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val numberOfRound = readLine() ?: throw IllegalArgumentException()
        validation.checkNumberOfRound(numberOfRound)
        return numberOfRound.toInt()
    }
}

data class Registaration(
    val cars: String,
    val round: Int,
)

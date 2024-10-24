package racingcar

class IOHandler {
    fun startMatch(): Registaration {
        return Registaration(cars = registerCars(), decideNumberOfRound())
    }

    private fun registerCars(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine() ?: throw IllegalArgumentException()
    }

    private fun decideNumberOfRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toInt() ?: throw IllegalArgumentException()
    }
}

data class Registaration(
    val cars: String,
    val round: Int,
)

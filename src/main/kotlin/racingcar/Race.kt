package racingcar

import camp.nextstep.edu.missionutils.Console

class Race(

) {
    private var cars: List<Car> = listOf()
    private var times: Int = 0

    fun ready() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        cars = examineName(Console.readLine())
        println("시도할 횟수는 몇 회인가요?")
        times = examineTimes(Console.readLine())
        println()
    }

    fun start() {
        println("실행 결과")
        repeat(times) {
            for (car in cars) {
                car.move()
                car.printResult()
            }
            println()
        }
    }

    fun end() {
        println("최종 우승자 : ${getWinner().joinToString(", ")}")
    }

    private fun examineName(input: String?): List<Car> {
        if (input.isNullOrBlank()) throw IllegalArgumentException()

        return input.split(",").map { name ->
            if (name.length > 5) throw IllegalArgumentException()
            Car(name)
        }
    }

    private fun examineTimes(input: String?): Int {
        val regex = Regex("^[1-9]+$")

        return input?.let {
            if (!regex.matches(it)) throw IllegalArgumentException()
            it.toInt()
        } ?: throw IllegalArgumentException()
    }

    private fun getWinner(): List<String> {
        var max = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == max }.map { it.getName() }
    }

    companion object {}
}
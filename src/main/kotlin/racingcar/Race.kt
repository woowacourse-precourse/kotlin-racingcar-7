package racingcar

import camp.nextstep.edu.missionutils.Console

class Race(private val cars: Cars) {
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Console.readLine()
        println("시도할 횟수는 몇 번인가요?")
        val iters = Console.readLine()
        execute(names, iters)
    }

    private fun execute(names: String, iters: String) {
        val validated = cars.validation(names, iters)
        for (i in 1..validated.second) {
            val result = cars.forward(validated)
        }
    }
}
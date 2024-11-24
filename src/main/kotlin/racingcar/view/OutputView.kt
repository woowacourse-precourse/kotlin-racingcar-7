package racingcar.view

import racingcar.model.Car

class OutputView {
    fun showStatus(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.getPos())}") // pos만큼 -를 반복
        }
        println()
    }

    fun showWinners(cars: List<Car>) {
        val maxPos = cars.maxOf { it.getPos() }
        val winners = cars.filter { it.getPos() == maxPos }
        val result = winners.joinToString(", ")
        print(MSG_WINNER + result)
    }

    companion object {
        const val MSG_WINNER = "최종 우승자 : "
    }
}
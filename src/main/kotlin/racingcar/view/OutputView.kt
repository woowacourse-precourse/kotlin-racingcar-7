package racingcar.view

import racingcar.model.Cars

class OutputView {
    fun announceResultStart() {
        println("실행 결과")
    }

    fun announceRaceStatus(cars: Cars) {
        cars.list.forEach {
            println(it.name + " : " + "-".repeat(it.position))
        }
        println()
    }

    fun announceWinner(cars: Cars) {
        val winnerNames = cars.getWinners().map { it.name }
        println("최종 우승자 : " + winnerNames.joinToString(", "))
    }
}

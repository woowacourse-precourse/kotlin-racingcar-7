package racingcar.view

import racingcar.model.Car

object OutputView {
    fun displayCarStatus(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun displayWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    fun displayDup() {
        println("중복된 차이름을 제거하였습니다.")
    }
}
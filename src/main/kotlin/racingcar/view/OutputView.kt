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
}

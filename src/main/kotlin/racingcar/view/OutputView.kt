package racingcar.view

import racingcar.model.Car

class OutputView {

    fun printProcessLabel() {
        println(PROCESS_LABEL)
    }

    fun printProcess(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.move}")
        }
        println()
    }

    fun printResult(winners: String) {
        print("$RESULT_LABEL : $winners")
    }

    companion object {
        const val PROCESS_LABEL = "\n실행 결과"
        const val RESULT_LABEL = "최종 우승자"
    }
}
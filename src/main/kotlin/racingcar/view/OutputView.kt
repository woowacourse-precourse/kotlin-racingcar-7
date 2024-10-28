package racingcar.view

import racingcar.Model.Car

class OutputView {
    fun enterNameOfCars() {
        println(ENTER_NAME_OF_CARS)
    }

    fun enterTryCounts() {
        println(ENTER_TRY_COUNTS)
    }

    fun printRoundMessage() {
        println(ROUND_MESSAGE)
    }

    fun printCurrentRound(cars: List<Car>) {
        for (car in cars) {
            print("${car.name} : ")
            repeat(car.position) {
                print(ONE_STEP)
            }
            println()
        }
    }

    fun printWinner(winners: List<Car>) {
        val nameOfWinners = winners.joinToString(CAR_NAME_SPLIT_POINT) { it.name }
        println(FINAL_WINNERS + nameOfWinners)
    }

    companion object {
        private const val ENTER_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val ENTER_TRY_COUNTS = "시도할 횟수는 몇 회인가요?"
        private const val ROUND_MESSAGE = "실행 결과"
        private const val ONE_STEP = "-"
        private const val FINAL_WINNERS =  "최종 우승자: "
        private const val CAR_NAME_SPLIT_POINT = ", "
    }
}
package racingcar.view

const val ENTER_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val ENTER_TRY_COUNTS = "시도할 횟수는 몇 회인가요?"

class OutputView {
    fun enterNameOfCars() {
        println(ENTER_NAME_OF_CARS)
    }

    fun enterTryCounts() {
        println(ENTER_TRY_COUNTS)
    }
}
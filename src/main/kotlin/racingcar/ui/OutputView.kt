package racingcar.ui

object OutputView {
    private const val CARS_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

    fun printCarsNameInput() = println(CARS_NAME_INPUT_MESSAGE)
}
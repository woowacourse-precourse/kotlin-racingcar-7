package racingcar

class Output {
    fun messageCarNames() = println(REQUEST_CAR_NAME)
    fun messageMoveCount() = println(REQUEST_MOVE_COUNT)

    companion object {
        const val REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val REQUEST_MOVE_COUNT = "시도할 횟수는 몇 회인가요?"
    }
}
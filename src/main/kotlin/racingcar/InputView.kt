package racingcar

object InputView {
    private const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_ROUND = "시도할 횟수는 몇 회인가요?"

    private const val INPUT_BLANK_ERROR = "입력이 없습니다."
    private const val INPUT_NUMBER_ERROR = "숫자만 입력 가능합니다."
    private const val DELIMITER = ","

    fun inputNames(): List<String> {
        println(INPUT_CAR_NAMES)
        val input = readlnOrNull() ?: throw IllegalArgumentException(INPUT_BLANK_ERROR)

        return input.split(DELIMITER)
    }

    fun inputRound(): Int {
        println(INPUT_ROUND)
        val input = readlnOrNull() ?: throw IllegalArgumentException(INPUT_BLANK_ERROR)

        return input.toIntOrNull() ?: throw IllegalArgumentException(INPUT_NUMBER_ERROR)
    }
}

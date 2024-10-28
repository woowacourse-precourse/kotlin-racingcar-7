package racingcar.constant

object Message {
    const val INFO_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val INFO_GET_ROUND = "시도할 횟수는 몇 회인가요?"
    const val INFO_ROUND_RESULT = "실행 결과"

    const val COMMA = ","

    val RANDOM_VALUE_RANGE = 0..9
    const val CAR_MOVING_MIN_NUMBER = 4

    const val ROUND_RESULT_FORMAT = "%s : "
    const val MOVING_SYMBOL = "-"

    const val RACE_RESULT_FORMAT = "최종 우승자 : %s"
    const val RACE_WINNER_DELIMITER = ", "
}
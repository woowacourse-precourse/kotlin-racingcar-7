package racingcar.resources

object Messages {
    // 입력 안내 메시지
    const val GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val GAME_INPUT_COUNT = "시도할 횟수는 몇 회인가요?"

    // 게임 결과 메시지
    const val GAME_RESULT_HEADER = "실행 결과"
    const val GAME_WINNER = "최종 우승자 : %s"

    // 에러 메시지
    const val ERROR_EMPTY_INPUT = "입력값이 비어있습니다."
    const val ERROR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하만 가능합니다."
    const val ERROR_DUPLICATE_NAME = "자동차 이름은 서로 중복될 수 없습니다"
    const val ERROR_BLANK_BOTH_END = "자동차의 이름의 공백은 문자 사이만 허용됩니다."

    const val ERROR_OVERSIZE_TRY_COUNT = "시도 횟수가 너무 크거나 잘못된 입력입니다."
    const val ERROR_NOT_POSITIVE = "시도 횟수는 양의 정수만 입력 가능합니다."
}

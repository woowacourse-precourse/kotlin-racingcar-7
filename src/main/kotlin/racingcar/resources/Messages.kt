package racingcar.resources

object Messages {
    // 입력 안내 메시지
    const val GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val GAME_INPUT_COUNT = "시도할 횟수는 몇 회인가요?"

    // 게임 결과 메시지
    const val GAME_RESULT = "실행 결과"
    const val GAME_WINNER = "최종 우승자 : %s"

    // 에러 메시지
    const val ERROR_EMPTY_PLAYER = "경기는 최소 1명 이상 참가해야 합니다."
    const val ERROR_INVALID_NAME = "자동차 이름은 5자 이하만 가능합니다."
    const val ERROR_INVALID_COUNT = "시도 횟수는 양의 정수만 가능합니다."
    const val ERROR_EMPTY_INPUT = "입력값이 비어있습니다."
}

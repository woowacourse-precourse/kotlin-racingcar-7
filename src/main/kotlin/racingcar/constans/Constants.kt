package racingcar.constans

object Constants {
    const val MIN_RANDOM_NUMBER = 0
    const val MAX_RANDOM_NUMBER = 9
    const val MIN_MOVE_COUNT = 4
    const val SEPARATOR = ","
    const val MAX_PLAY_COUNT = 10000
    const val REGEX_FOR_INVALID_SEPARATORS = "^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ,]{1,5}$"
    const val MESSAGE_GUIDE_FOR_USER_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val MESSAGE_GUIDE_FOR_INPUT_COUNT = "시도할 횟수는 몇 회인가요?"
    const val MESSAGE_RESULT = "\n실행 결과"
    const val MESSAGE_LAST_WINNER = "최종 우승자 :"
}
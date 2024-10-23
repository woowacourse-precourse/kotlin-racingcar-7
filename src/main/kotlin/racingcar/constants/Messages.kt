package racingcar.constants

object Messages {
    const val INPUT_CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val INPUT_MOVE_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"

    const val OUPUT_RESULT = "실행 결과"

    // 에러 메시지들
    const val INVALID_CAR_NAME =
        "올바르지 않은 자동차 이름입니다. 자동차 이름은 반드시 알파벳 문자로 시작해야 하며, 뒤에 선택적으로 숫자를 포함할 수 있습니다"
    const val INVALID_CAR_NAME_LENGTH = "자동차 이름이 허용 길이를 초과했습니다. 자동차 이름은 5자 이하만 가능합니다."
    const val INVALID_MOVE_COUNT = "올바르지 않은 시도 횟수입니다."
}
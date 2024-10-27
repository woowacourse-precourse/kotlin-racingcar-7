package racingcar

enum class ErrorType(val message: String) {
    INVALID_NAME_OVER_5_LENGTH_INPUT("5자 초과 문자열이 입력되었습니다.\n자동차의 이름 또는 구분자를 확인해주세요. "),
    INVALID_COUNT_NOT_NUMBER_INPUT("이동 횟수가 숫자가 아닌 값이 입력되었습니다.\n이동 횟수는 양의 정수만 가능합니다."),
    INVALID_COUNT_NOT_DIGIT_INPUT("이동 횟수가 정수가 아닌 값이 입력되었습니다.\n이동 횟수는 양의 정수만 가능합니다."),
    INVALID_COUNT_NEGATIVE_INPUT("이동 횟수가 음수 값이 입력되었습니다.\n이동 횟수는 양의 정수만 가능합니다.")
}
package racingcar.util

enum class ErrorType(val errorMessage: String) {
    CAR_NAME_LENGTH_OVER_FIVE_ERROR("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_BLANK_OR_INCLUDE_BLANK_ERROR("자동차 이름은 공백이거나 공백을 포함할 수 없습니다."),
    TRY_NUMBER_NOT_INT_TYPE_ERROR("시도 횟수는 숫자 형식으로 입력해야 합니다."),
    TRY_NUMBER_UNDER_ZERO_ERROR("시도 횟수는 1회 이상이어야 합니다.")
}
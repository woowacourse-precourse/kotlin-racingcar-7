package racingcar.util

object ErrorMessages {

    // carName 에러 메시지
    const val INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상, 5자 이하만 가능합니다: "
    const val INVALID_CAR_NAME_DUPLICATE_ERROR = "자동차 이름은 중복될 수 없습니다."

    // raceCount 에러 메시지
    const val INVALID_RACE_COUNT_DECIMAL_ERROR = "소수 입력은 허용되지 않습니다: "
    const val INVALID_RACE_COUNT_POSITIVE_INTEGER_ERROR = "경주 횟수는 1 이상의 정수여야 합니다: "
    const val INVALID_RACE_COUNT_FORMAT_ERROR = "유효한 경주 횟수 형식이 아닙니다."
    const val INPUT_EXCEEDS_RACE_COUNT_LIMIT_ERROR = "100,000 이하의 숫자를 입력해 주세요."

}
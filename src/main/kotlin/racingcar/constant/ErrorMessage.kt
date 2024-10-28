package racingcar.constant

object ErrorMessage {
    const val HAS_DUPLICATE_NAMES = "자동차 이름은 중복될 수 없습니다."
    const val IS_NAME_EMPTY = "자동차의 이름이 입력되지 않았습니다."
    const val IS_OVER_MAX_LENGTH = "입력하신 이름의 길이가 5글자를 초과하였습니다."
    const val FAIL_CREATE_RACINGCAR = "레이싱카 생성이 실패했습니다."

    const val IS_NON_NUMBER = "입력하신 횟수는 숫자가 아닙니다."
    const val IS_NON_POSITIVE_NUMBER = "입력하신 숫자는 양수가 아닙니다."
    const val FAIL_CONVERT_TO_ATTEMPT_COUNT = "입력하신 시도 횟수 변환에 실패하였습니다."
}
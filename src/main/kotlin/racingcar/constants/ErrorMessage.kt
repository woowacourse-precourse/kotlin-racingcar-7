package racingcar.constants

enum class ErrorMessage(val message: String) {
    NAME_VALIDATION("자동차 이름은 5자 이하만 가능하며, 공백을 허용하지 않습니다."),
    ATTEMPT_NOT_NUMBER("횟수는 숫자여야 합니다."),
    ATTEMPT_VALIDATION("횟수는 0보다 커야 합니다.");
}
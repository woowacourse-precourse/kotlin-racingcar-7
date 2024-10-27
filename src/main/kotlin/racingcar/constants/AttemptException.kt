package racingcar.constants

enum class AttemptException(val message: String) {
    NOT_NUMBER("시도할 횟수는 숫자여야 합니다."),
    MINIMUM("시도할 횟수는 0보다 커야 합니다."),
    TOO_LARGE("시도할 횟수가 너무 큽니다.");
}
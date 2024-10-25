package racingcar.exception

enum class ExceptionMessage(val message: String) {
    DUPLICATED_CAR_NAME("중복된 자동차 이름이 존재합니다."),
    INVALID_CAR_NAME_SIZE("자동차 이름은 1 ~ 5자로 설정할 수 있습니다."),
    INVALID_NUMERIC_INPUT("숫자만 입력할 수 있습니다."),
    INVALID_NUMBER_OF_ROUND("자동차 게임 횟수는 1 ~ 10_000회까지 선택 가능합니다.")
}
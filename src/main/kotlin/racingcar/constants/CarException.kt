package racingcar.constants

enum class CarException(val message: String) {
    LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    NO_SPACES("자동차 이름은 공백을 허용하지 않습니다."),
    LOWERCASE_ONLY("자동차 이름은 소문자의 영어로만 입력해주세요."),
    DUPLICATE("중복되지 않는 자동차 이름을 입력해 주세요.");
}
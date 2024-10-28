package racingcar.constant

object Error {
    val CAR_NAME_RANGE = 1..5
    val NOT_VALID_CAR_NAME_LENGTH =
        "자동차 이름은 ${CAR_NAME_RANGE.first} 이상 ${CAR_NAME_RANGE.last} 이하로 입력해주세요. %s의 이름은 %d자 입니다."
    const val NOT_VALID_ROUND_TYPE = "경주 횟수는 숫자만 입력 가능합니다. %s은 숫자가 아닙니다."
}
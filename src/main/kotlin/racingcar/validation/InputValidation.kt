package racingcar.validation

class InputValidation {
    fun carName(name: String) =
        require(name.length in 1..5) { "자동차 이름은 1 ~ 5자로 입력해주세요. ${name}의 이름은 ${name.length}자 입니다." }

    fun raceRound(round: String) =
        round.toIntOrNull() ?: throw IllegalArgumentException("경주 횟수는 숫자만 입력 가능합니다. ${round}은 숫자가 아닙니다.")
}
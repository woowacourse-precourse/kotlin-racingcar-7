package racingcar

class InputValidator {
    fun validateCarNames(input: List<String>) {
        require(input.isNotEmpty()) { "자동차 이름은 하나 이상 입력해야 합니다." }
        input.forEach { name ->
            require(name.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
            require(name.length <= 5) { "자동차 이름은 5자 이하이어야 합니다." }
        }
    }

    fun validateTryCount(input: Int) {
        require(input > 0) { "시도 횟수는 1 이상이어야 합니다." }
    }
}
package racingcar.utils

object Validator {
    fun validateInputNames(input: String) {
        require(input.isNotEmpty()) { IllegalArgumentException("이름들을 입력해주십시오") }
        require(input.contains(",")) { IllegalArgumentException("구분자를 쉼표(,)로 사용해 주십시오") }
        val inputSplitTrim = input.split(",").map { it.trim() }
        require(inputSplitTrim.size == inputSplitTrim.toSet().size) { IllegalArgumentException("이름이 중복 될수는 없습니다") }
        require(
            inputSplitTrim
                .all { it.length <= 5 }) { IllegalArgumentException("이름은 5이하의 문자만이 가능합니다") }
    }
}
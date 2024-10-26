package racingcar.validator

object Validator {
    private val carNamePattern = Regex("^([^,]{1,5})(,[^,]{1,5})*$")

    fun validateCarNames(carNames: String) {
        if (!carNamePattern.matches(carNames)) {
            throw IllegalArgumentException()
        }
    }
}

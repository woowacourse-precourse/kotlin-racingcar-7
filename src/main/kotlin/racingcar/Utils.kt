package racingcar

const val COMMA_SEPARATOR = ","

fun splitComma(input: String): List<String> {
    return input.split(COMMA_SEPARATOR)
}

fun validateNegative(number: Int) {
    if (number < 0) {
        throw IllegalArgumentException()
    }
}
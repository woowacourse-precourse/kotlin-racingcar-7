package racingcar

const val COMMA_SEPARATOR = ","

fun splitComma(input: String): List<String> {
    return input.split(COMMA_SEPARATOR)
}
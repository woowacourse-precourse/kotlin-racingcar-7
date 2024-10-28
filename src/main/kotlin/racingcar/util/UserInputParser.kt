package racingcar.util

private const val DELIMITER = ","

fun parseCarNames(input: String): List<String> {
    return input.split(DELIMITER)
}
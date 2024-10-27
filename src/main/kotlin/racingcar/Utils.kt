package racingcar

const val COMMA_SEPARATOR = ","

fun splitComma(input: String): List<String> {
    return input.split(COMMA_SEPARATOR)
}

fun String.repeatUInt(count: UInt): String {
    val result = StringBuilder()
    for (i in 1U..count) {
        result.append(this)
    }

    return result.toString()
}

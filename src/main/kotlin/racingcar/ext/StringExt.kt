package racingcar.ext

fun String.isNotNumeric(): Boolean {
    return this.toDoubleOrNull() == null
}

fun String.isFloat(): Boolean {
    return this.contains(".")
}

fun String.isNegativeNumber(): Boolean {
    return this.toIntOrNull()?.let { it < 0 } ?: false
}
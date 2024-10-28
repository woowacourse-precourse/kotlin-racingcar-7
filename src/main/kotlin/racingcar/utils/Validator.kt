package racingcar.utils

internal fun String.isNamesInvalid(): Boolean {
    val names = this.split(",")
    return !matches("^[A-Za-z,]+$".toRegex()) || names.hasDuplicate() || names.hasBlankName() || names.hasLongName()
}

private fun List<String>.hasDuplicate(): Boolean {
    return this.size != this.distinct().size
}

private fun List<String>.hasBlankName(): Boolean {
    return this.any { it.isBlank() }
}

private fun List<String>.hasLongName(): Boolean {
    return this.any { it.length > 5 }
}

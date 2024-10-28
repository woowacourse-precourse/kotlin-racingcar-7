package racingcar

class MyParser {
    fun parseNames(input: String): List<String> {
        return input
            .split(NAME_DELIMITER)
            .map(String::trim)
            .takeIf { isValidNames(it) }
            ?: throw IllegalArgumentException("이름은 5글자 이하여야 합니다")
    }

    private fun isValidNames(names: List<String>): Boolean {
        return names.all { it.length <= NAME_LENGTH_LIMIT }
    }

    fun parseTurns(input: String): Int {
        return input
            .toIntOrNull()
            ?: throw IllegalArgumentException("숫자가 아닙니다")
    }

    companion object {
        private const val NAME_DELIMITER = ','
        private const val NAME_LENGTH_LIMIT = 5
    }
}
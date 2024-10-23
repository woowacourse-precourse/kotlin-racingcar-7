package racingcar.model

class RacingCarException {
    fun checkInvalidCharacter(input: String): Boolean {
        val pattern = Regex("[^a-zA-Z,]")
        val invalidCharacter = pattern.find(input)
        return invalidCharacter != null
    }

    fun checkHeadAndTail(input: String): Boolean {
        val pattern = Regex("^[a-zA-Z].*[a-zA-Z]$")
        val validPattern = pattern.matchEntire(input)
        return validPattern == null
    }

    fun checkLength(input: String): Boolean {
        return input.length in 2..4
    }
}
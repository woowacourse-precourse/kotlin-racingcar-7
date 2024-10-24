package racingcar.model

class RacingGame {
    private var cars: MutableMap<String, Car> = mutableMapOf()
    var names: List<String> = listOf()

    fun setInput(input: String) {
        splitToList(input)
    }

    fun splitToList(input: String) {
        names = input.split(",").toMutableList()
    }

    fun isValidName(): Boolean {
        names.forEach {
            if (it.length > 5) {
                return false
            }
        }
        return true
    }

    fun isValidNaturalNumber(round: String): Boolean {
        if (round.matches("\\D".toRegex())) return false
        if (round.toInt() == 0) return false
        return true
    }

    fun createCars() {
        names.forEach { name -> cars[name] = Car() }
    }
}
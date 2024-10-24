package racingcar.model

class RacingGame {
    var cars: Map<String, Car> = mapOf()

    fun isValidName(names: String): Boolean {
        names.split(",").forEach() {
            if (it.length > 5) {
                return false
            }
        }
        return true
    }
}
package racingcar

class Car(val name: String) {
    var location = INIT_LOCATION
        private set

    fun forward() {
        location += FORWARD
    }

    companion object {
        private const val INIT_LOCATION = 0
        private const val FORWARD = 1

        fun from(name: String): Car {
            return Car(name)
        }
    }
}
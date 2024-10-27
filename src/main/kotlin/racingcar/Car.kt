package racingcar

data class Car(val name: String, val location: Int) {

    companion object {
        private const val INIT_LOCATION = 0

        fun of(name: String): Car {
            return Car(name, INIT_LOCATION)
        }
    }
}
package racingcar

data class Car(val name: String, val forward: Int) {

    companion object {
        private const val INIT_FORWARD = 0

        fun of(name: String): Car {
            return Car(name, INIT_FORWARD)
        }
    }
}
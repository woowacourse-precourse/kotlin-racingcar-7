package racingcar

data class Car(val name: String, val forward: Int) {

    companion object {

        fun of(name: String): Car {
            return Car(name, 0)
        }
    }
}
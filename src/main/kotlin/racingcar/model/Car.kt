package racingcar.model

class Car(private val name: String) {

    private var distance = 0

    val currentDistance: String
        get() = "-".repeat(distance)

    init {
        require(name.isNotEmpty() && name.length <= 5)
    }

    fun getName() = name

    fun moveForward() {
        distance++
    }
}
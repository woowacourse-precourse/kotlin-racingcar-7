package racingcar.model

class Car(private val name: String) {
    private val distance = mutableListOf<String>()

    fun moveForward() {
        distance.add("-")
    }

    fun stop() {
        distance.add("")
    }

    fun getName() = name

    fun getDistance() = distance.joinToString("")
}
package racingcar

class Car(name: String, position: Int = 0) {
    val name: String
    val position: Int

    init {
        this.name = name
        this.position = position
    }
}
package racingcar

class Car(name: String, position: Int = 0) {
    val name: String
    var position: Int

    init {
        this.name = name
        this.position = position
    }

    fun move(point: Int) {
        if (point >= 4) {
            this.position += 1
        }
    }
}
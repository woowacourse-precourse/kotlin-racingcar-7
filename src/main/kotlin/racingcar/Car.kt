package racingcar

class Car(
    val name: String
) {
    private var _movedCount: Int = 0
    val movedCount: Int
        get() = _movedCount

    fun move() {
        _movedCount ++
    }
}

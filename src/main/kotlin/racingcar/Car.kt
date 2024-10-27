package racingcar

class Car(
    val name: String
) {
    private var _movedCount: Int = 0
    val movedCount: Int
        get() = _movedCount
    val roundResult: String
        get() {
            var result = "$name : "

            repeat(movedCount) {
                result += '-'
            }

            return result
        }

    fun move() {
        _movedCount++
    }
}

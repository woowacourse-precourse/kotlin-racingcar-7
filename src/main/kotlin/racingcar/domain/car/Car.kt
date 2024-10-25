package racingcar.domain.car

private const val MOVE_SIGN = "-"

class Car(private val name: String) {
    var position: Int = 0
        private set

    fun move() {
        this.position++
    }

    private fun showPosition(): String {
        return buildString {
            repeat(position) {
                append(MOVE_SIGN)
            }
        }
    }

    override fun toString(): String {
        return "$name : ${showPosition()}"
    }
}
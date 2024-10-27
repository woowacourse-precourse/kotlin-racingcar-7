package Model

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= 5) {
            throw IllegalArgumentException()
        }
    }

    fun move(canMove: Boolean) {
        if (canMove) position++
    }

    override fun toString(): String = "$name : ${"-".repeat(position)}"
}

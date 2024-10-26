package Model

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.length <= 5) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    fun move(canMove: Boolean) {
        if (canMove) position++
    }

    override fun toString(): String = "$name : ${"-".repeat(position)}"
}

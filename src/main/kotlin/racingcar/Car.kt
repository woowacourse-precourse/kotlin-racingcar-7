package racingcar

class Car(nameInput: String) {
    val name = nameInput
    private var position: Int = 0

    fun carMove() {

    }

    fun getPosition(): Int {
        return position
    }
}
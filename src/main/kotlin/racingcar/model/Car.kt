package racingcar.model

data class Car(val name: String, var position: Int = 0) {
    fun move(go: Boolean) {
        if (go) {
            position++
        }
    }
}

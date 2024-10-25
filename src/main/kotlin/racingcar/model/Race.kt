package racingcar.model

class Race {
}

data class Car(val name: String) {
    var moves = 0
        private set

    fun move() = moves++
}
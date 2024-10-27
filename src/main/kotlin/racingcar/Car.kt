package racingcar

class Car(val name: String){
    var distance = 0L
        private set

    fun moveForward(distance: Long) {
        this.distance += distance
    }
}
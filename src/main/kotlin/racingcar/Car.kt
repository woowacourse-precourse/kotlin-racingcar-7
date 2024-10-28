package racingcar

import Random

data class Car(val name: String) {
    var distance: Int = 0
    fun checkMove() {
        if (Random().generatorRandomNum() >= 4) {
            distance++
        }
    }
}
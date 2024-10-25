package racingcar.model

import racingcar.utils.Values

class Car(val name: String) {
    var movedDistance: Int = 0
        private set

    fun move(randromInt: Int) {
       if(randromInt >= Values.MIN_MOVABLE_NUMBER) movedDistance++
    }
}
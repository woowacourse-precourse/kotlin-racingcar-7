package racingcar.model

class CarMove(private val randomGenerator: RandomGenerator) {
    fun canMove(): Boolean {
        return RandomGenerator().generate() >= 4
    }
}
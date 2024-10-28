package racingcar.stub

import racingcar.NumberGenerator

class RandomNumberGeneratorStub(private val manipulatedNumbers: ArrayList<Int>) : NumberGenerator {
    override fun generate(): Int {
        return manipulatedNumbers.removeFirstOrNull() ?: 0
    }
}
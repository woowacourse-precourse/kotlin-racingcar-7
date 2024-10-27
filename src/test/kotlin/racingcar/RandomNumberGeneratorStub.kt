package racingcar

class RandomNumberGeneratorStub(private val manipulatedNumbers: ArrayList<Int>) : NumberGenerator {
    override fun generate(): Int {
        return manipulatedNumbers.removeFirstOrNull() ?: 0
    }
}
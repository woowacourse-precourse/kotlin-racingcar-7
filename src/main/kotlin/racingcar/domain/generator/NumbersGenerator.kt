package racingcar.domain.generator

import java.util.LinkedList

class NumbersGenerator(numbers: List<Int>) : NumberGenerator {
    private val remainingNumbers = LinkedList(numbers)
    override fun generate(): Int {
        require(remainingNumbers.isNotEmpty()) { println(EXCEEDED_NUMBER_CALL_EXCEPTION_MESSAGE) }
        return remainingNumbers.poll()
    }

    companion object {
        private const val EXCEEDED_NUMBER_CALL_EXCEPTION_MESSAGE = "숫자들의 개수보다 많이 호출되었습니다."
    }
}
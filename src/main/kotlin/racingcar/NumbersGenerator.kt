package racingcar

import java.util.LinkedList

class NumbersGenerator(numbers: List<Int>) : NumberGenerator {
    private val remainingNumbers = LinkedList(numbers)
    override fun generate(): Int {
        require(remainingNumbers.isNotEmpty()) { println("숫자들의 개수보다 많이 호출되었습니다.")}
        return remainingNumbers.poll()
    }
}
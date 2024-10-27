package racingcar.domain.random

fun interface RandomNumberGenerator {
    fun pickNumberInRange(startInclusive: Int, endInclusive: Int): Int
}

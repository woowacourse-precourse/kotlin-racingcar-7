package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.constants.Constants

class MoveTest {
    private val move = Move()

    @Test
    fun moveOrStop() {
        val numberList = listOf(2, 3, 4, 5, 6)
        val result = move.moveOrStop(numberList)
        assertEquals(listOf("", "", "-", "-", "-"), result)
    }
}

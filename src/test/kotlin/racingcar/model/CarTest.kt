package racingcar.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import racingcar.constants.Constants.MOVE

class CarTest {
    private val car = Car("a")

    @Test
    fun `isMove가 true일 때 테스트`() {
        car.move(true)
        val expected = listOf("-")

        assertEquals(expected,car.moves)
    }

    @Test
    fun `isMove가 false일 때 테스트`() {
        car.move(false)
        val expected = listOf("")

        assertEquals(expected,car.moves)
    }

    @Test
    fun `움직인 횟수 계산 테스트`() {
        car.moves.add("-")
        car.moves.add("")
        val result = car.moves.count{it == MOVE}
        val expected = 1

        assertEquals(expected,result)
    }
}
package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Move

class MoveTest {
    private val move = Move()
    private val map = mutableMapOf("pobi" to 0, "jun" to 2)

    @Test
    fun `무작위 값 범위 확인`() {
        val randomNumber = move.getRandomNumber()
        assertThat(randomNumber).isGreaterThan(0).isLessThan(10)
    }

    @Test
    fun `전진 확인`() {
        move.moveCar(map, "pobi", 0, 4)
        move.moveCar(map, "jun", 2, 6)
        assertThat(map["pobi"]).isEqualTo(1)
        assertThat(map["jun"]).isEqualTo(3)
    }

    @Test
    fun `정지 확인`() {
        move.moveCar(map, "pobi", 0, 1)
        move.moveCar(map, "jun", 2, 2)
        assertThat(map["pobi"]).isEqualTo(0)
        assertThat(map["jun"]).isEqualTo(2)
    }
}

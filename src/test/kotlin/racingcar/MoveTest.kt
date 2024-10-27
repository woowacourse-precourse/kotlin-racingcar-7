package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Move

class MoveTest {
    private val move = Move()
    private val status = mutableMapOf("pobi" to 0, "jun" to 2)

    @Test
    fun `전진 확인`() {
        move.moveCar(status, "pobi", 0, 4)
        move.moveCar(status, "jun", 2, 6)
        assertThat(status["pobi"]).isEqualTo(1)
        assertThat(status["jun"]).isEqualTo(3)
    }

    @Test
    fun `정지 확인`() {
        move.moveCar(status, "pobi", 0, 1)
        move.moveCar(status, "jun", 2, 2)
        assertThat(status["pobi"]).isEqualTo(0)
        assertThat(status["jun"]).isEqualTo(2)
    }
}

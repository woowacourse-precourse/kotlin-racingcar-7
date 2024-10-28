package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {
    lateinit var testCar: Car

    @BeforeEach
    fun setTest() {
        testCar = Car("test")
    }

    @Test
    fun `자동차 움직이기 테스트`() {
        //given
        val beforeMoves = testCar.moves

        //when
        testCar.moveForward()

        //then
        val currentMoves = testCar.moves
        assertThat(currentMoves)
            .isEqualTo(beforeMoves + 1)
    }
}

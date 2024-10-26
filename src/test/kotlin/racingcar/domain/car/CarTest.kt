package racingcar.domain.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.car.CarsTest.TestNumberGenerator

internal class CarTest {

    // TestNumberGenerator : 홀수번째 유저는 이동, 짝수번째 유저는 정지
    private lateinit var numberGenerator: TestNumberGenerator

    @BeforeEach
    fun setUp() {
        numberGenerator = TestNumberGenerator()
    }

    @Test
    fun `자동차는 이동 할 수 있다`() {
        // given
        val car = Car("aloe")
        val expected = 1

        // when
        car.move(numberGenerator)

        // then
        Assertions.assertEquals(expected, car.position)
    }

    @Test
    fun `자동차의 이름과 위치를 출력할 수 있다`() {
        // given
        val car = Car("tesla")
        car.move(numberGenerator)
        val expected = "tesla : -"

        // when && then
        Assertions.assertEquals(expected, car.toString())
    }
}
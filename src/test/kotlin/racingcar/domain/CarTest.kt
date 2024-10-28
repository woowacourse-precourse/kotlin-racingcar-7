package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarName.Companion.asCarName
import racingcar.domain.random.RandomNumberGenerator

class CarTest {
    private lateinit var sut: Car

    @Test
    fun `4보다 작은 수가 생성됐을 경우 이동하지 않음`() {
        // arrange
        sut = createCar(randomNumberGenerator = { _, _ -> STOP })
        val previousDistance = sut.distance

        // act
        sut.tryMove()

        // assert
        val currentDistance = sut.distance
        assertThat(currentDistance).isEqualTo(previousDistance)
    }

    @Test
    fun `4이상의 수가 생성됐을 경우 이동`() {
        // arrange
        sut = createCar(randomNumberGenerator = { _, _ -> MOVE })
        val previousDistance = sut.distance

        // act
        sut.tryMove()

        // assert
        val currentDistance = sut.distance
        assertThat(currentDistance).isEqualTo(previousDistance + 1)
    }

    private fun createCar(
        carName: CarName = "name".asCarName(),
        randomNumberGenerator: RandomNumberGenerator,
    ) = Car(carName, randomNumberGenerator)

    companion object {
        private const val MOVE = 4
        private const val STOP = 3
    }
}

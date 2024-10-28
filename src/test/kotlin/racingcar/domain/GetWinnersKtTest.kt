package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarName.Companion.asCarName


class GetWinnersKtTest {
    @Test
    fun `단독 우승자일 경우 하나의 우승자만 반환`() {
        // arrange
        val cars = (1..3).map { createCar(it.toString().asCarName(), shouldBeWinner = it == 3) }
        cars.tryMove()

        // act
        val winners = cars.winners

        // assert
        val maxDistance = cars.maxOf { car -> car.distance }

        assertThat(winners.size).isEqualTo(1)
        assertThat(winners.first().distance).isEqualTo(maxDistance)
    }

    @Test
    fun `여러명의 우승자가 있을 경우 여러 우승자 반환`() {
        // arrange
        // 짝수번째 자동차가 우승자
        val cars = (1..5).map { createCar(it.toString().asCarName(), shouldBeWinner = it % 2 == 0) }
        cars.tryMove()

        // act
        val winners = cars.winners

        // assert
        val maxDistance = cars.maxOf { car -> car.distance }

        assertThat(winners.size).isEqualTo(2)
        winners.forEach { car -> assertThat(car.distance).isEqualTo(maxDistance) }
    }

    @Test
    fun `자동차 리스트가 비어있을 경우 빈 리스트 반환`() {
        // arrange
        val cars = emptyList<Car>()
        cars.tryMove()

        // act
        val winners = cars.winners

        // assert
        assertThat(winners).isEmpty()
    }

    private fun createCar(carName: CarName, shouldBeWinner: Boolean): Car = Car(
        carName = carName,
        randomNumberGenerator = if (shouldBeWinner) { _, _ -> 4 } else { _, _ -> 3 }
    )
}

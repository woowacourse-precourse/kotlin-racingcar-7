package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {

    private val randomNumber = FakeRandomNumberImpl()

    @Test
    fun `단일 우승자 테스트`() {
        // Given
        val car1 = createCarWithDistance("car1", SINGLE_MOVE)
        val car2 = createCarWithDistance("car2", DOUBLE_MOVE)
        val carList = listOf(car1, car2)

        // When
        val winner = Winner(carList).getWinner()

        // Then
        assertThat(winner).isEqualTo("car2")
    }

    @Test
    fun `다중 우승자 테스트`() {
        // Given
        val car1 = createCarWithDistance("car1", DOUBLE_MOVE)
        val car2 = createCarWithDistance("car2", DOUBLE_MOVE)
        val car3 = createCarWithDistance("car3", SINGLE_MOVE)
        val carList = listOf(car1, car2, car3)

        // When
        val winner = Winner(carList).getWinner()

        // Then
        assertThat(winner).isEqualTo("car1${WINNER_DELIMITER}car2")
    }

    private fun createCarWithDistance(name: String, distance: String): Car =
        Car(name, randomNumber).apply {
            this.distance = distance
        }

    companion object {
        private const val SINGLE_MOVE = "-"
        private const val DOUBLE_MOVE = "--"
        private const val WINNER_DELIMITER = ", "
    }

}

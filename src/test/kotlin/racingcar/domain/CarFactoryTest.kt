package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarFactoryTest {

    private val randomNumber = FakeRandomNumberImpl()

    @Test
    fun `주어진 차이름이 한대면 예외를 발생시킨다`() {
        // Given
        val carNames = listOf("소나타")

        // When & Then
        assertThrows<IllegalArgumentException> {
            CarFactory.createCars(carNames, randomNumber)
        }.apply {
            assertThat(message).isEqualTo(CAR_NAMES_COUNT_ERROR_MESSAGE)
        }
    }

    @Test
    fun `중복된 차이름이 있으면 예외를 발생시킨다`() {
        // Given
        val carNames = listOf("소나타", "소나타", "아반떼")

        // When & Then
        assertThrows<IllegalArgumentException> {
            CarFactory.createCars(carNames, randomNumber)
        }.apply {
            assertThat(message).isEqualTo(CAR_NAME_DUPLICATION_ERROR_MESSAGE)
        }
    }

    @Test
    fun `올바르게 차 이름들이 주어지면 예외를 발생시키지 않는다`() {
        // Given
        val carNames = listOf("소나타", "티코", "아반떼")

        // When & Then
        assertDoesNotThrow {
            CarFactory.createCars(carNames, randomNumber)
        }
    }

    @Test
    fun `주어진 차 이름들을 가진 차리스트를 반환한다`() {
        // Given
        val carNames = listOf("소나타", "티코")

        // When
        val cars = CarFactory.createCars(carNames, randomNumber)

        // Then
        assertThat(cars.map { it.carName }).isEqualTo(carNames)
    }

    companion object {
        private const val CAR_NAMES_COUNT_ERROR_MESSAGE = "차가 2대 이상있어야 레이싱을 시작할 수 있습니다."
        private const val CAR_NAME_DUPLICATION_ERROR_MESSAGE = "차 이름은 중복입력할 수 없습니다."
    }

}

package racingcar

import Model.CarsFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsFactoryTest {
    @Test
    fun `정상적인 자동차 이름 리스트로 자동차 생성`() {
        val carNames = listOf("pobi", "woni")
        val cars = CarsFactory.createCars(carNames)

        assertThat(cars).hasSize(2)
        assertThat(cars.map { it.name }).containsExactlyInAnyOrderElementsOf(carNames)
    }

    @Test
    fun `자동차 이름 중 5자를 초과하는 경우 예외 발생`() {
        val carNames = listOf("pobi", "toolongname")

        assertThrows<IllegalArgumentException> {
            CarsFactory.createCars(carNames)
        }
    }
}

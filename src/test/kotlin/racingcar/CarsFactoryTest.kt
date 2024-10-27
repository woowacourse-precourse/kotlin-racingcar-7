package racingcar

import Model.CarsFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsFactoryTest {
    @Test
    fun `자동차 이름 리스트가 올바를 때 정상적으로 자동차 생성`() {
        val carNames = listOf("pobi", "woni")
        val cars = CarsFactory.createCars(carNames)

        assertThat(cars).hasSize(2)
        assertThat(cars.map { it.name }).containsExactlyInAnyOrderElementsOf(carNames)
    }

    @Test
    fun `자동차 이름 중 5자를 초과하는 경우 예외 발생`() {
        assertThrowsForInvalidNames(listOf("pobi", "toolongname"))
    }

    @Test
    fun `같은 이름의 자동차가 입력된 경우 예외 발생`() {
        assertThrowsForInvalidNames(listOf("pobi", "pobi"))
    }

    @Test
    fun `자동차가 한 대만 입력된 경우 예외 발생`() {
        assertThrowsForInvalidNames(listOf("pobi"))
    }

    @Test
    fun `자동차 이름이 빈 문자열인 경우 예외 발생`() {
        assertThrowsForInvalidNames(listOf(""))
    }

    private fun assertThrowsForInvalidNames(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            CarsFactory.createCars(names)
        }
    }
}
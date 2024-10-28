package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.entity.Car
import racingcar.domain.usecase.GetWinnersUseCase

class GetWinnersUseCaseTest {
    @Test
    fun `우승자가 혼자일 경우 테스트`() {
        val cars = listOf(Car("red", _position = 5), Car("blue", _position = 3))
        val result = GetWinnersUseCase().execute(cars)
        val expect = listOf("red")
        assertEquals(expect, result)
    }

    @Test
    fun `우승자가 다수일 경우 테스트`() {
        val cars = listOf(Car("red", _position = 4), Car("blue", 5), Car("white", _position = 5))
        val result = GetWinnersUseCase().execute(cars)
        val expect = listOf("blue", "white")
        assertEquals(expect, result)
    }
}
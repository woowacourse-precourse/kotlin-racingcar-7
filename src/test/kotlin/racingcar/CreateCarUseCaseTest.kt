package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.entity.Car
import racingcar.domain.factory.CarFactory
import racingcar.domain.usecase.CreateCarUseCase

class CreateCarUseCaseTest {

    private val createCarUseCase = CreateCarUseCase()

    @Test
    fun `자동차 생성 테스트`() {
        val cars = createCarUseCase.execute("red,blue")
        val expect = listOf(Car("red"), Car("blue"))
        assertEquals(expect, cars)
    }

    @Test
    fun `자동차 익명 생성 테스트`() {
        val cars = createCarUseCase.execute("red,  ,   ,")
        val expect = listOf(Car("red"), Car("익명1"), Car("익명2"), Car("익명3"))
        assertEquals(expect, cars)
    }

    @Test
    fun `자동차를 생성할때 이름이 5자 이상일 경우 예외 처리 테스트`() {
        val input = "red,blue,white,yellow"
        assertThrows<IllegalArgumentException> {
            createCarUseCase.execute(input)
        }
    }
}
package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.entity.Car
import racingcar.domain.usecase.CreateCarsUseCase

class CreateCarsUseCaseTest {

    private val createCarsUseCase = CreateCarsUseCase()

    @Test
    fun `자동차 생성 테스트`() {
        val cars = createCarsUseCase.execute("red,blue")
        val expect = listOf(Car("red"), Car("blue"))
        assertEquals(expect, cars)
    }

    @Test
    fun `자동차 익명 생성 테스트`() {
        val cars = createCarsUseCase.execute("red,  ,   ,")
        val expect = listOf(Car("red"), Car("익명1"), Car("익명2"), Car("익명3"))
        assertEquals(expect, cars)
    }

    @Test
    fun `익명 자동차가 1000개일 경우 (익명1000) 5자 이상이라 예외 처리 테스트`() {
        assertThrows<IllegalArgumentException> {
            createCarsUseCase.execute(",".repeat(999))
        }
    }

    @Test
    fun `자동차들의 이름에 중복이 있을 경우 예외 처리 테스트`() {
        val input = "red,blue,white,blue"
        assertThrows<IllegalArgumentException> {
            createCarsUseCase.execute(input)
        }
    }
}
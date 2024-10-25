package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.entity.Car
import racingcar.domain.generator.NumbersGenerator
import racingcar.domain.usecase.PlayRaceUseCase

class PlayRaceUseCaseTest {
    @Test
    fun `레이스를 실행하고 각 자동차의 상태 테스트`() {
        val cars = listOf(Car("red"), Car("blue"))
        PlayRaceUseCase(NumbersGenerator(listOf(3, 4))).execute(cars)
        val expect = listOf(Car("red", 0), Car("blue", 1))
        assertEquals(expect, cars)
    }
}
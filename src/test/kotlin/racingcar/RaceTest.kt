package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `레이스를 실행하고 각 자동차의 상태 테스트`() {
        val cars = listOf(Car("red"), Car("blue"))
        val race = Race(cars, NumbersGenerator(listOf(3, 4)))
        race.play()
        val result = race.cars
        val expect = listOf(Car("red", 0), Car("blue", 1))
        assertEquals(expect, result)
    }
}
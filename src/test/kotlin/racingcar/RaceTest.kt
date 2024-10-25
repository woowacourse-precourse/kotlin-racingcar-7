package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.entity.Car
import racingcar.domain.entity.Race
import racingcar.domain.generator.NumbersGenerator

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

    @Test
    fun `우승자가 혼자일 경우 테스트`() {
        val cars = listOf(Car("red"), Car("blue"))
        val race = Race(cars, NumbersGenerator(listOf(3, 4, 5, 3, 7, 2)))
        repeat(3){
            race.play()
        }
        val result = race.getWinnersName()
        val expect = listOf("red")
        assertEquals(expect, result)
    }

    @Test
    fun `우승자가 다수일 경우 테스트`() {
        val cars = listOf(Car("red"), Car("blue"))
        val race = Race(cars, NumbersGenerator(listOf(3, 4, 5, 3, 7, 6)))
        repeat(3){
            race.play()
        }
        val result = race.getWinnersName()
        val expect = listOf("red","blue")
        assertEquals(expect, result)
    }
}
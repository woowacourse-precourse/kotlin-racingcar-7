package racingcar.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.data.Car

class WinnerTest {
    @DisplayName("우승자가 1명일 경우")
    @Test
    fun calculateSingleWinner() {
        val cars = listOf(Car("hoho", 5), Car("kiki", 3))
        val expectedResult = listOf("hoho")
        Assertions.assertEquals(Winner.calculate(cars), expectedResult)
    }

    @DisplayName("우승자가 2명 이상일 경우")
    @Test
    fun calculateMultipleWinners() {
        val cars = listOf(Car("hoho", 5), Car("kiki", 5), Car("ohoh", 5))
        val expectedResult = listOf("hoho", "kiki", "ohoh")
        Assertions.assertEquals(Winner.calculate(cars), expectedResult)
    }
}
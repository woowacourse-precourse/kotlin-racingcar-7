package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {
    val race = RaceGame()
    val check = CheckException()

    @Test
    fun splitCarsTest() {
        val cars = "  abc, def,  g hi "
        val carMap = race.splitCars(cars)

        assertThat(carMap).containsExactlyEntriesOf(
            mapOf("abc" to 0, "def" to 0, "g hi" to 0)
        )
    }

    @Test
    fun goForwardTest() {
        val carMap = mutableMapOf<String, Int>("a" to 0, "b" to 0)
        var a = 10
        assertRandomNumberInRangeTest(
            {
                val increaseScore = race.goForward(carMap)
                assertThat(increaseScore["a"]).isEqualTo(1)
                assertThat(increaseScore["b"]).isEqualTo(0)
            }, 4, 3
        )
    }

    @Test
    fun firstInputExceptionTest() {
        assertThrows<IllegalArgumentException> { check.firstInput("abcd, abcde, abcdef") }
        assertThrows<IllegalArgumentException> { check.firstInput("") }
        assertThrows<IllegalArgumentException> { check.firstInput(" ") }
        assertThrows<IllegalArgumentException> { check.firstInput("a,") }
        assertThrows<IllegalArgumentException> { check.firstInput(",") }
        assertThrows<IllegalArgumentException> { check.firstInput("a") }
        assertThrows<IllegalArgumentException> { check.firstInput(",a,b") }
    }

    @Test
    fun secondInputExceptionTest() {
        assertThrows<IllegalArgumentException> { check.secondInput("") }
        assertThrows<IllegalArgumentException> { check.secondInput(" ") }
        assertThrows<IllegalArgumentException> { check.secondInput("0") }
        assertThrows<IllegalArgumentException> { check.secondInput("3.3") }
        assertThrows<IllegalArgumentException> { check.secondInput("-3") }
        assertThrows<IllegalArgumentException> { check.secondInput("a") }
    }

    @Test
    fun resultException() {
        assertThrows<IllegalArgumentException> { check.result(mutableMapOf("a" to 0, "b" to 0, "c" to 0)) }
    }

}
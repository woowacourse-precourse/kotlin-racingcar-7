package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ValidationTest : NsTest() {
    @Test
    fun `EXCEEDED_CHARACTER_COUNT`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kimlee,park", "1") }
        }
    }

    @Test
    fun `CONTINUOUS_DELIMITER`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,,lee", "1") }
        }
    }

    @Test
    fun `CANT_RACE_ALONE`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim l", "1") }
        }
    }

    @Test
    fun `START_AND_END_DELIMITER_INPUT`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,lee,", "1") }
        }
    }

    @Test
    fun `ONLY_GAP`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim, ,lee", "1") }
        }
    }

    @Test
    fun `ZERO_INPUT`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,lee", "00") }
        }
    }

    @Test
    fun `INCLUDED_STRING`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,lee", "1.1") }
        }
    }

    override fun runMain() {
        main()
    }
}

package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest : NsTest() {
    @Test
    fun `아무것도 넣이 않은경우 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `공백을 넣었을 경우 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
        }
    }

    @Test
    fun `구분자를 잘못 기재 시 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("povi.kim", "1") }
        }
    }

    @Test
    fun `중복된 이름 기재 시 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("povi,povi", "1") }
        }
    }

    @Test
    fun `Round 기재 시 숫자가 아닐경우 예외처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("povi,kim", "숫자") }
        }
    }

    override fun runMain() {
        main()
    }
}
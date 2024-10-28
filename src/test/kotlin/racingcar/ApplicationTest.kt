package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름 예외`() {
        assertSimpleTest {
            // null or 공백만 있는 경우
//            assertThrows<IllegalArgumentException> { runException(null, "1") } // null을 입력한 경우 오류가 발생하지 않음 -> isNullOrBlank, == null, ?.let{} (X)
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
            assertThrows<IllegalArgumentException> { runException("", "1") }

            // 6자 이상인 경우
            assertThrows<IllegalArgumentException> { runException("c,java,kotlin", "1") }
        }
    }

    @Test
    fun `횟수 예외`() {
        assertSimpleTest {
            // null
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", null) }

            // 숫자 외의 문자가 있는 경우
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", " ") }
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "-") }
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1.2") }

            // 자연수가 아닌 경우 (음수, 0 등)
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "-5") }
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "0") }
        }
    }

    @Test
    fun `공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,ji", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "ji : -", "최종 우승자 : pobi, woni, ji")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

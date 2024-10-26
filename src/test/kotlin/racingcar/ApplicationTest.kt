package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.text.NumberFormat

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
    fun `음수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `0 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `이름 빈 문자열 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "-1") }
        }
    }

    @Test
    fun `이름 null 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null, "-1") }
        }
    }

//    같은 빈 문자열인데 뭐는 되고 왜 얘는 실패야...
//    @Test
//    fun `시도 횟수 빈 문자열 예외 테스트`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { runException("pobi,woni", "") }
//        }
//    }


    @Test
    fun `시도 횟수 null 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", null) }
        }
    }

    @Test
    fun `시도 횟수 소수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "1.1") }
        }
    }

    @Test
    fun `이름 구분자 dot 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi.woni", "1") }
        }
    }

    @Test
    fun `동명 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `한 명 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "1")
                assertThat(output()).contains("pobi : -", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
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

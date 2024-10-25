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
    fun `공백 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `자동차 이름 중복 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,lee,park,lee", "1") }
        }
    }

    @Test
    fun `자동차 이름 5자 초과 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcdef,abc,ab", "1") }
        }
    }

    @Test
    fun `이동횟수 0 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,b,c", "0") }
        }
    }

    @Test
    fun `이동횟수 음수 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,b,c", "-1") }
        }
    }

    @Test
    fun `이동횟수 다른 타입 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,b,c", "abc") }
        }
    }

    @Test
    fun `자동차 하나 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a", "1") }
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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
    fun 차량이름_5자_초과_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun 이름없는_차량_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",,", "1") }
            assertThrows<IllegalArgumentException> { runException(" , , ", "1") }
            assertThrows<IllegalArgumentException> { runException("    ,   , ", "1") }
            assertThrows<IllegalArgumentException> { runException("a,,", "1") }
            assertThrows<IllegalArgumentException> { runException(" ,ab, ", "1") }
            assertThrows<IllegalArgumentException> { runException(" ,ab, c ", "1") }
            assertThrows<IllegalArgumentException> { runException("    ,   , ", "1") }
        }
    }

    @Test
    fun 부적절한_이동_횟수_테스트() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "1.0") }
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "10.28") }
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "-2") }
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "열번") }
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "fiveTimes") }
            assertThrows<IllegalArgumentException> { runException("abc,abc,abcde", "三回") }
            assertThrows<IllegalArgumentException> {
                runException(
                    "abc,abc,abcde",
                    "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
                )
            }
        }
    }

    @Test
    fun 적절한_이동_횟수_테스트() {
        assertSimpleTest {
            assertDoesNotThrow { runException("abc,abc,abcde", "1") }
            assertDoesNotThrow { runException("abc,abc,abcde", "10") }
            assertDoesNotThrow { runException("abc,abc,abcde", "$MAX_UINT") }
            assertDoesNotThrow { runException("abc,abc,abcde", "$MIN_UINT") }
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
        private const val MAX_UINT: UInt = UInt.MAX_VALUE //4,294,967,295
        private const val MIN_UINT: UInt = UInt.MIN_VALUE //0

    }
}

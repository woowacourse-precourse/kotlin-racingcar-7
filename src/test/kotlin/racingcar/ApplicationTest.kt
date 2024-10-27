package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Nested
    inner class `기능 테스트` {

        @Test
        fun `입력 출력이 정상인 경우`() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
                }, MOVING_FORWARD, STOP
            )
        }

        @Test
        fun `자동차 이름이 한글 5글자인 경우`() {
            assertRandomNumberInRangeTest(
                {
                    run("안녕하세요,반갑습니다", "3")
                    assertThat(output()).contains("안녕하세요 : -", "반갑습니다 : ", "최종 우승자 : 안녕하세요")
                }, MOVING_FORWARD, STOP
            )
        }

        @Test
        fun `자동차 이름이 초성 알파벳인 경우`() {
            assertRandomNumberInRangeTest(
                {
                    run("k.u.h,y.y.y", "3")
                    assertThat(output()).contains("k.u.h : -", "y.y.y : ", "최종 우승자 : k.u.h")
                }, MOVING_FORWARD, STOP
            )
        }
    }

    @Nested
    inner class `예외 테스트` {
        @Test
        fun `자동차 이름이 6자 이상일 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            }
        }

        @Test
        fun `구분자가 ','가 아닐 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi.woni", "1") }
            }
        }

        @Test
        fun `전진 횟수가 숫자가 아닐 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,abc", "a") }
            }
        }

        @Test
        fun `전진 횟수가 int형 범위를 벗어날 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,abc", "2200000000") }
            }
        }

        @Test
        fun `전진 횟수가 음수일 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,abc", "-5") }
            }
        }

        @Test
        fun `전진 횟수가 일정 범위을 벗어날 경우`() {
            val moveCount = 2147483646

            assertThat(moveCount)
                .isGreaterThan(0)
                .isLessThan(Int.MAX_VALUE)
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

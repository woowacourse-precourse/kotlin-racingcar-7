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
        fun `기본 예시 케이스`() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
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
    }

    @Nested
    inner class `이름 예외 테스트` {
        @Test
        fun `글자수 제한 초과 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            }
        }

        @Test
        fun `빈 문자열 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("", "-1") }
            }
        }

        @Test
        fun `null 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException(null, "-1") }
            }
        }

        @Test
        fun `구분자 허용되지 않은 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi.woni", "1") }
            }
        }

        @Test
        fun `같은 이름 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,pobi,woni", "1") }
            }
        }
    }

    @Nested
    inner class `시도 횟수 예외 테스트` {
        @Test
        fun `음수 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
            }
        }

        @Test
        fun `0 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            }
        }

        @Test
        fun `null 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", null) }
            }
        }

        @Test
        fun `소수점 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "1.1") }
            }
        }

        @Test
        fun `특수문자 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "@") }
            }
        }

        @Test
        fun `문자 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "r") }
            }
        }

        @Test
        fun `공백 입력 케이스`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", " ") }
            }
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

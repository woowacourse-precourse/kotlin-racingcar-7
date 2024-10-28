package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

class ApplicationTest : NsTest() {

    @DisplayName("정상 동작 테스트")
    @Nested
    inner class NoExceptionTest {
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

        @DisplayName("우승자가 여러 명인 경우")
        @Test
        fun multipleWinnersTest() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,woni,jun", "1")
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
            )
        }

        @DisplayName("자동차 이름에 공백이 있는 경우")
        @Test
        fun whiteSpaceInCarNamesTest() {
            assertSimpleTest {
                assertDoesNotThrow { run("yewon , pobi  , woni, jun", "1") }
            }
        }

        @DisplayName("아무도 이동하지 않은 경우")
        @Test
        fun noMovementTest() {
            assertRandomNumberInRangeTest(
                {
                    run("car1, car2, car3", "1")
                    assertThat(output()).contains("car1 : ", "car2 : ", "car3 : ", "최종 우승자 : car1, car2, car3")
                },
                STOP, STOP, STOP
            )
        }

        @DisplayName("2 이상의 횟수가 입력된 경우")
        @Test
        fun multipleTimesTest() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi, woni, jun", "3")
                    assertThat(output()).contains(
                        "pobi : -", "woni : -", "jun : ",
                        "pobi : --", "woni : -", "jun : -",
                        "pobi : ---", "woni : --", "jun : --",
                        "최종 우승자 : pobi"
                    )
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            )
        }
    }

    @DisplayName("예외 테스트")
    @Nested
    inner class ExceptionTest {

        @DisplayName("자동차 이름 예외 테스트")
        @Nested
        inner class CarNameExceptionTest {
            @Test
            fun `예외 테스트`() {
                assertSimpleTest {
                    assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
                }
            }

            @DisplayName("자동차 이름이 빈칸인 경우")
            @Test
            fun emptyCarNamesTest() {
                assertSimpleTest {
                    assertThrows<IllegalArgumentException> { runException(",", "1") }
                }
            }

            @DisplayName("자동차 이름이 중복되는 경우")
            @Test
            fun duplicateCarNamesTest() {
                assertSimpleTest {
                    assertThrows<IllegalArgumentException> { runException("pobi, pobi, woni", "1") }
                }
            }
        }

        @DisplayName("실행 횟수 예외 테스트")
        @Nested
        inner class TimesExceptionTest {
            @DisplayName("입력받은 횟수를 숫자로 변환할 수 없는 경우")
            @Test
            fun failToParseNumberTest() {
                assertSimpleTest {
                    assertThrows<IllegalArgumentException> { runException("pobi,java", "3a") }
                }
            }

            @DisplayName("0, 음수 횟수 입력")
            @Nested
            inner class NonPositiveTimesTest {
                @Test
                fun zeroTimesTest() {
                    assertSimpleTest {
                        assertThrows<IllegalArgumentException> { runException("pobi, woni, jun", "0") }
                    }
                }

                @Test
                fun negativeTimesTest() {
                    assertSimpleTest {
                        assertThrows<IllegalArgumentException> { runException("pobi, woni, jun", "-1") }
                    }
                }
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

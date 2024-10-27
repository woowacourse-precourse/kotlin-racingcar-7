package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @DisplayName("기능 테스트")
    @Nested
    inner class FunctionalTest {

        @DisplayName("기본 입력 테스트")
        @Test
        fun successCase1Test() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
                },
                MOVING_FORWARD, STOP
            )
        }

        @DisplayName("자동차 이름 ', '로 구분 테스트")
        @Test
        fun successCase2Test() {
            assertRandomNumberInRangeTest(
                {
                    run("Car1, Car2", "1")
                    assertThat(output()).contains("Car1 : -", "Car2 : ", "최종 우승자 : Car1")
                },
                MOVING_FORWARD, STOP
            )
        }

        @DisplayName("자동차 이름 중간에 공백 포함 테스트")
        @Test
        fun successCase3Test() {
            assertRandomNumberInRangeTest(
                {
                    run("Car 1,Car 2", "1")
                    assertThat(output()).contains("Car 1 : -", "Car 2 : ", "최종 우승자 : Car 1")
                },
                MOVING_FORWARD, STOP
            )
        }

        @DisplayName("자동차 이름 양쪽에 공백 포함 테스트")
        @Test
        fun successCase4Test() {
            assertRandomNumberInRangeTest(
                {
                    run(" Car1 , Car2 ", "1")
                    assertThat(output()).contains("Car1 : -", "Car2 : ", "최종 우승자 : Car1")
                },
                MOVING_FORWARD, STOP
            )
        }
    }

    @DisplayName("예외 테스트")
    @Nested
    inner class ExceptionTest {

        @DisplayName("사용자 입력이 빈 문자열인 경우 예외 테스트")
        @Test
        fun exceptionCase1Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("", "1") }
            }
        }

        @DisplayName("5자 초과한 자동차 이름이 있는 경우 예외 테스트")
        @Test
        fun exceptionCase2Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            }
        }

        @DisplayName("자동차 이름이 빈 문자열인 자동차가 존재하는 경우 예외 테스트")
        @Test
        fun exceptionCase3Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("pobi,", "1") }
            }
        }

        @DisplayName("중복된 자동차 이름이 있는 경우 예외 테스트")
        @Test
        fun exceptionCase4Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2,Car2", "1") }
            }
        }

        @DisplayName("사용자가 입력한 시도 횟수가 숫자가 아닌 경우 예외 테스트")
        @Test
        fun exceptionCase5Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2", "%") }
            }
        }

        @DisplayName("사용자가 입력한 시도 횟수가 빈 문자열인 경우 예외 테스트")
        @Test
        fun exceptionCase6Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2", "\n") }
            }
        }

        @DisplayName("사용자가 입력한 시도 횟수가 공백 문자열인 경우 예외 테스트")
        @Test
        fun exceptionCase7Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2", " ") }
            }
        }

        @DisplayName("사용자가 입력한 시도 횟수가 음수인 경우 예외 테스트")
        @Test
        fun exceptionCase8Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2", "-1") }
            }
        }

        @DisplayName("사용자가 입력한 시도 횟수가 0인 경우 예외 테스트")
        @Test
        fun exceptionCase9Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1,Car2", "0") }
            }
        }

        @DisplayName("사용자가 입력한 자동차가 하나인 경우 예외 테스트")
        @Test
        fun exceptionCase10Test() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("Car1", "1") }
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

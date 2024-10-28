package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `게임 실행 중 자동차가 이동하고 우승자를 결정한다`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",
                    "최종 우승자 : pobi, jun"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외를 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,javaji", "1")
            }
        }
    }

    @Test
    fun `시도 횟수가 1 미만일 경우 예외를 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
    }

    @Test
    fun `자동차 이름에 공백이 포함되면 예외를 발생시킨다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi, ,woni", "1")
            }
        }
    }

    @Test
    fun `우승자가 여러 명일 경우 쉼표로 구분하여 출력한다`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains(
                    "pobi : --",
                    "woni : --",
                    "최종 우승자 : pobi, woni"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}

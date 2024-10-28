package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.utils.ErrorMessages

class ApplicationTest : NsTest() {

    @Test
    fun `두 개의 자동차가 단일 라운드에서 우승자를 가리는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `세 개의 자동차가 3 라운드에서 최종 우승자를 가리는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains("pobi : ---", "woni : ", "jun : ---", "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `두 자동차가 모든 라운드에서 동일한 거리를 이동해 공동 우승자가 나오는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `여러 라운드에서 이동이 없는 경우 최종 우승자 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "3")
                assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun")
            },
            STOP, STOP, STOP,
            STOP, STOP, STOP,
            STOP, STOP, STOP
            )
    }

    @Test
    fun `여러 자동차와 많은 라운드에서 최종 우승자 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun,kiki", "5")
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : -",
                    "jun : -",
                    "kiki : -",
                    "최종 우승자 : pobi, woni, jun, kiki"
                )
            },
            MOVING_FORWARD, STOP, STOP, STOP,
            STOP, MOVING_FORWARD, STOP, STOP,
            STOP, STOP, MOVING_FORWARD, STOP,
            STOP, STOP, STOP, MOVING_FORWARD,
            STOP, STOP, STOP, STOP
        )
    }


    //예외 케이스
    @Test
    fun `자동차 이름이 5자를 초과할 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname,woni", "1")
            }
            assertThat(exception.message).isEqualTo(ErrorMessages.NAME_LENGTH_ERROR)
        }
    }

    @Test
    fun `빈 자동차 이름`() {
        assertSimpleTest {
            val exception1 = assertThrows<IllegalArgumentException> { runException("pobi,,woni", "1") }
            assertThat(exception1.message).isEqualTo(ErrorMessages.NAME_EMPTY_ERROR)

            val exception2 = assertThrows<IllegalArgumentException> { runException("pobi,woni,", "1") }
            assertThat(exception2.message).isEqualTo(ErrorMessages.NAME_EMPTY_ERROR)
        }
    }

    @Test
    fun `자동차 이름이 서로 같은 경우`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,pobi,woni", "1") }
            assertThat(exception.message).isEqualTo(ErrorMessages.NAME_DUPLICATE_ERROR)
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
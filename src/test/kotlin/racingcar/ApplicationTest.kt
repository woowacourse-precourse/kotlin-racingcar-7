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
    fun `이동 횟수에 숫자 외의 값 입력 시 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "one") }
        }
    }

    @Test
    fun `여러 자동차가 동일한 거리일 경우 우승자 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun,jin", "1")
                assertThat(output()).contains("pobi : -", "jun : -", "jin : ", "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `모든 자동차가 멈췄을 때 우승자 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun,jin", "1")
                assertThat(output()).contains("pobi : ", "jun : ", "jin : ", "최종 우승자 : pobi, jun, jin")
            },
            STOP, STOP, STOP
        )
    }

    @Test
    fun `모든 자동차가 전진했을 때 우승자 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun,jin", "1")
                assertThat(output()).contains("pobi : -", "jun : -", "jin : -", "최종 우승자 : pobi, jun, jin")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `8명의 자동차가 참가하고 여러 번 이동한 경우 우승자 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,jun,jin,su,kia,hd,bmw,ray", "3")
                assertThat(output()).contains(
                    "pobi : ---",  // 자동차의 예상된 거리
                    "jun : ---",   // 자동차의 예상된 거리
                    "jin : --",    // 자동차의 예상된 거리
                    "su : ---",    // 자동차의 예상된 거리
                    "kia : --",    // 자동차의 예상된 거리
                    "hd : --",     // 자동차의 예상된 거리
                    "bmw : ---",   // 자동차의 예상된 거리
                    "ray : ---",   // 자동차의 예상된 거리
                    "최종 우승자 : pobi, jun, su, bmw" // 우승자를 포함한 정확한 결과
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP, STOP,
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

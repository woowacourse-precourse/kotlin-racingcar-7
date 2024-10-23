package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
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

    @DisplayName("게임 0번 진행")
    @Test
    fun zeroGame() {
        run("우테코,화이팅", "0")
        assertThat(output()).contains("최종 우승자 : 우테코, 화이팅")
    }

    @DisplayName("너무 긴 이름 입력으로 예외 발생")
    @Test
    fun failLongName() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("우테코화이팅") }
        }
    }

    @DisplayName("너무 큰 숫자 입력으로 예외 발생")
    @Test
    fun failOverTryCount() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("우테코,화이팅", (Int.MAX_VALUE.toLong() + 1L).toString())
            }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        const val MOVING_FORWARD: Int = 4
        const val STOP: Int = 3
    }
}

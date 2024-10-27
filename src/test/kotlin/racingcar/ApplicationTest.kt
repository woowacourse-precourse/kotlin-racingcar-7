package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    fun `빈 문자열 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "2") }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["**po,!java", "$5ab,^bana", "#zxc,(ab)"])
    fun `잘못된 자동차 이름 형식 입력 시 예외 테스트`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(input, "4") }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -10])
    fun `0 이하의 시도 횟수 입력 시 예외 테스트`(tryCount: Int) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", tryCount.toString()) }
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

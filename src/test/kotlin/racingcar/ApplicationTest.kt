package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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
    fun `자동차 이름 예외 테스트`() {
        assertAll(
            // 중복된 이름 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("car1,car2,car3,car1", "5") }
            },
            // 쉼표가 아닌 다른 구분자를 사용하는 경우 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("car1|car2|car3", "5") }
            },
            // 이름이 공백인 경우 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("car1,,car3", "5") }
            },
            // 자동차 이름이 숫자인 경우 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("12345,car2", "5") }
            }
        )
    }

    @Test
    fun `숫자 입력 예외 테스트`() {
        assertAll(
            // 공백이거나 0 이하의 값 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", " ") }
            },
            {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            },
            {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
            },
            // 숫자가 아닌 값(문자)이 포함된 경우 예외처리
            {
                assertThrows<IllegalArgumentException> { runException("pobi,woni", "five") }
            }
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

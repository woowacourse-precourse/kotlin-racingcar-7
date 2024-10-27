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
    fun `자동차 이름이 비어있을 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("", "1") }
            assertThat(exception.message).isEqualTo("자동차 이름이 비어있습니다.")
        }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni,wkdan1", "1") }
            assertThat(exception.message).isEqualTo("자동차 이름은 5자 이하이어야 합니다.")
        }
    }

    @Test
    fun `자동차가 두 대 미만일 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi", "1") }
            assertThat(exception.message).isEqualTo("자동차는 최소 두 대 이상이어야 합니다.")
        }
    }

    @Test
    fun `자동차 이름이 중복될 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni,pobi", "1") }
            assertThat(exception.message).isEqualTo("자동차 이름은 중복될 수 없습니다.")
        }
    }

    @Test
    fun `자동차 이름에 유효하지 않은 문자가 포함될 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni,@wkdan", "1") }
            assertThat(exception.message).isEqualTo("자동차 이름에는 알파벳과 숫자만 사용할 수 있습니다.")
        }
    }

    @Test
    fun `시도 횟수가 정수가 아닐 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "wkdan") }
            assertThat(exception.message).isEqualTo("시도 횟수는 정수여야 합니다.")
        }
    }

    @Test
    fun `시도 횟수가 1 미만일 때 예외 발생`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            assertThat(exception.message).isEqualTo("시도 횟수는 1 이상이어야 합니다.")
        }
    }

    @Test
    fun `우승자 중복 시 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains("최종 우승자 : pobi, jun")
            },
            5, 3, 5,  // 1회차
            4, 4, 4,  // 2회차
            6, 2, 5,  // 3회차
            4, 3, 4,  // 4회차
            5, 2, 5   // 5회차
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

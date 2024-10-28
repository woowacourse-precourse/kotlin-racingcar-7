package racingcar.controller

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class RacingCarControllerTest : NsTest() {

    @Test
    fun `우승자가 여러명일 시에 ,로 나누어 여러명 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,poro", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "poro : -", "최종 우승자 : pobi, woni, poro")
            },
            MOVING_GO, MOVING_GO, MOVING_GO
        )
    }

    @Test
    fun `차이름이 중복될 시에 중복 제외 후 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,pobi", "1")
                assertThat(output()).contains("중복된 차이름을 제거하였습니다.")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_GO, MOVING_STOP
        )
    }

    @Test
    fun `자동차 이름이 5자를 초과하는 경우 예외`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("pobi,abcdefgh", "3")
            }
            assertEquals("자동차 이름은 5자 이하만 가능합니다.", exception.message)
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열로 받을 경우 예외`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("pobi,", "3")
            }
            assertEquals("이름이 전부 입력되지 않았습니다.", exception.message)
        }
    }

    @Test
    fun `시도 횟수가 입력이 안될 시에 예외`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("pobi,woni", " ")
            }
            assertEquals("숫자를 입력해주세요.", exception.message)
        }
    }

    @Test
    fun `시도 횟수가 유효하지 않은 경우 예외`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
            assertEquals("시도 횟수는 1회 이상이어야 합니다.", exception.message)
        }
    }

    override fun runMain() {
        RacingCarController().start()
    }

    companion object {
        private const val MOVING_GO: Int = 4
        private const val MOVING_STOP: Int = 3
    }
}

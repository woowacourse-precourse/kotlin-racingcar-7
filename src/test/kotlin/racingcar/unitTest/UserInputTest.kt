package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInputTest : NsTest() {
    // ### 기능 테스트 ###
    @Test
    fun `정상적인 입력`() {
        var carInput = "pobi,woni,jun"
        var totalAttemptsInput = "5"
        assertSimpleTest {
            run(carInput, totalAttemptsInput)
            assertThat(output()).contains("[pobi, woni, jun]", "5")
        }
    }

    @Test
    fun `중복된 자동차 이름 입력`() {
        var carInput = "pobi,pobi,pobi"
        var totalAttemptsInput = "5"
        assertSimpleTest {
            run(carInput, totalAttemptsInput)
            assertThat(output()).contains("[pobi, pobi0, pobi1]", "5")
        }
    }

    @Test
    fun `공백이 포함된 자동차 이름 입력`() {
        var carInput = "ju  n, woni,po bi"
        var totalAttemptsInput = "5"
        assertSimpleTest {
            run(carInput, totalAttemptsInput)
            assertThat(output()).contains("[ju  n,  woni, po bi]", "5")
        }
    }


    // ### 예외 테스트 ###
    @Test
    fun `5글자 이상인 자동차 이름 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름으로 빈 문자열을 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,", "1") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",pobi", "1") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `시도 횟수로 0을 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `시도 횟수로 음수를 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `시도 횟수로 빈 문자열을 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "\n") }
        }
    }

    @Test
    fun `시도 횟수로 숫자가 아닌 문자를 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    override fun runMain() {

        val output = UserInput.request()
        println(output.carNameList)
        println(output.rounds)
    }

}

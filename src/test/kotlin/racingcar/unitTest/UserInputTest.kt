package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserInputTest : NsTest() {
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
        var carInput = "ju  n , woni,po bi"
        var totalAttemptsInput = "5"
        assertSimpleTest {
            run(carInput, totalAttemptsInput)
            assertThat(output()).contains("[ju  n ,  woni, po bi]", "5")
        }
    }


    override fun runMain() {

        val output = UserInput.request()
        println(output.carNameList)
        println(output.rounds)
    }

}

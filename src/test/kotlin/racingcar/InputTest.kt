package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest : NsTest() {
    @Test
    fun `이름 다섯자 이하 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobidd,java") }
        }
    }

    @Test
    fun `이름 중복 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi,pob") }
        }
    }

    @Test
    fun `시도 횟수 잘못된 문자 입력 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java", "a") }
        }
    }

    @Test
    fun `자동차 1대 이하 입력 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi") }
        }
    }

    @Test
    fun `자동차 이름에 공백 입력 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,") }
        }
    }


    override fun runMain() {
        main()
    }
}

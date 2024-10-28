package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest : NsTest() {
    @Test
    fun `자동차 이름 입력 필요 테스트`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `자동차 이름이 공백일 수 없음 테스트`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,javaji", "1") }
        }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 수 없음 테스트`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javajiiii", "1") }
        }
    }

    @Test
    fun `자동차 이름 최소 2대 이상 필요 테스트`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }

    @Test
    fun `시도할 횟수는 1 이상의 정수여야 함 테스트`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, java", "0") }
        }
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, java", "-1") }
        }
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, java", "abc") }
        }
    }



    override fun runMain() {
        main()
    }
}

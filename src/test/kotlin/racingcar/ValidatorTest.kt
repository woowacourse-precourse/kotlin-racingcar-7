package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validator.Validator

class ValidatorTest {
    @Test
    fun `자동차 이름 입력 시 마지막 문자는 쉼표가 아니어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateCarNames("apple,peach,")
            }
        }
    }

    @Test
    fun `자동차 이름은 빈 문자열이 아니어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateCarNames("")
            }
        }
    }

    @Test
    fun `자동차 이름 입력 시 이름은 쉼표로 구분되어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateCarNames("apple peach")
            }
        }
    }

    @Test
    fun `자동차 이름 입력 시 이름은 1자 이상 5자 이하이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateCarNames("apple,pineapple")
            }
        }
    }
}

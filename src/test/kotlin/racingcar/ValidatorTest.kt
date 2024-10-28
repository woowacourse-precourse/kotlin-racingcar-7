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

    @Test
    fun `시도 횟수는 숫자이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateTryCount("apple")
            }
        }
    }

    @Test
    fun `시도 횟수는 0 이거나 양의 정수이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateTryCount("-1")
            }
        }
    }

    @Test
    fun `시도 횟수는 0 이거나 양의 정수이어야 한다 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateTryCount("1.1")
            }
        }
    }

    @Test
    fun `시도 횟수는 빈 문자열이 아니어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateTryCount("")
            }
        }
    }

    @Test
    fun `시도 횟수는 MAX_VALUE 이하여야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateTryCount("${Int.MAX_VALUE + 1}")
            }
        }
    }
}

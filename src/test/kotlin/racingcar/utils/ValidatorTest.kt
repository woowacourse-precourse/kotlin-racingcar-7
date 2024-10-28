package racingcar.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `이름이 한글 자음 모음이면 에러륿 발생시키는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            val testName1 = "ㅁㅁㅁ"
            val testName2 = "ㅣㅡ"
            Validator.validateName(testName1)
            Validator.validateAttemptCount(testName2)
        }
    }

    @Test
    fun `이름에 공백이 포함되면 에러를 발생시키는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            val testName1 = "a bc"
            val testName2 = "민 수"
            Validator.validateName(testName1)
            Validator.validateName(testName2)
        }
    }

    @Test
    fun `중복된 이름이 있으면 에러를 발생시키는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            val testName1 = "aaa,aaa"
            val testName2 = "민수,민수"
            Validator.validateName(testName1)
            Validator.validateName(testName2)
        }
    }

    @Test
    fun `이름을 입력하지 않으면 에러를 발생시키는지 확인하는 테스트`() {
        assertThrows<IllegalArgumentException> {
            val testName1 = ""
            val testName2 = ","
            Validator.validateName(testName1)
            Validator.validateName(testName2)
        }
    }
}
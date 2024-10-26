package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.constans.NamingError.errorMessageForDuplicatedName
import racingcar.constans.NamingError.errorMessageForEmptyInput
import racingcar.constans.NamingError.errorMessageForEmptyName
import racingcar.constans.NamingError.errorMessageForInvalidNameFormat
import racingcar.constans.NamingError.errorMessageForInvalidPlayerCount
import racingcar.constans.NamingError.errorMessageForInvalidSeparator
import racingcar.delegate.name.NameErrorDelegator
import racingcar.delegate.name.NameErrorDelegatorImpl

class NameErrorDelegatorImplTest {
    private lateinit var nameErrorDelegator: NameErrorDelegator

    @BeforeEach
    fun setUp() {
        nameErrorDelegator = NameErrorDelegatorImpl()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "     "])
    fun `이름 입력이 비었을 때 예외 테스트`(input: String) {
        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkInputIsEmpty(input)
        }

        // then
        assertEquals(errorMessageForEmptyInput, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi;wony;chany"])
    fun `모든 구분자가 잘못 입력 되었을 때 예외 테스트`(input: String) {
        // given
        val names = input.split(",")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForInvalidSeparator(names)
        }

        // then
        assertEquals(errorMessageForInvalidSeparator, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,wony;chany", "pobi;wony;ch,chu"])
    fun `몇 개의 구분자만 잘못 입력 되었을 때 예외 테스트`(input: String) {
        // given
        val names = input.split(",")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForInvalidNameFormat(names)
        }

        // then
        assertEquals(errorMessageForInvalidNameFormat, exception.message)
    }


    @ParameterizedTest
    @ValueSource(strings = ["pobi,,wony", ",", ",," , " , ,"])
    fun `이름에 빈 이름이 포함되었을 때 예외 테스트`(input: String) {
        // given
        val names = input.split(",")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForEmptyName(names)
        }

        // then
        assertEquals(errorMessageForEmptyName, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,won,won", "poby,poby,poby"])
    fun `중복된 이름이 있을 때 예외 테스트`(input: String) {
        // given
        val names = input.split(",").groupingBy { it }.eachCount()

        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForDuplicateName(names)
        }

        // then
        assertEquals(errorMessageForDuplicatedName, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pob@i,1@234,@#@", "sd%^,1234,abc", "123,1234,abc&"])
    fun `이름 형식이 올바르지 않을 때 예외 테스트`(input: String) {
        // given
        val names = input.split(",")

        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForInvalidNameFormat(names)
        }

        // then
        assertEquals(errorMessageForInvalidNameFormat, exception.message)
    }

    @ParameterizedTest
    @CsvSource(
        "pobi,chan,kim",
        "john,doe,smith",
        "가,나,다",
        "abc,def,ghi",
        "a,b,c",
        "ㄱ,ㄴ,ㄷ",
        "ㅏ,ㅐ,ㅣ",
        "john,kim,lee"
    )
    fun `이름 형식이 올바를 때 테스트`(input: String) {
        // given
        val names = input.split(",")

        // when & then
        assertDoesNotThrow {
            nameErrorDelegator.checkForInvalidNameFormat(names)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "w", "chan"])
    fun `플레이어 수가 부족할 때 예외 테스트`(input: String) {
        // when
        val exception = assertThrows<IllegalArgumentException> {
            nameErrorDelegator.checkForInvalidPlayerCount(listOf(input))
        }

        // then
        assertEquals(errorMessageForInvalidPlayerCount, exception.message)
    }
}

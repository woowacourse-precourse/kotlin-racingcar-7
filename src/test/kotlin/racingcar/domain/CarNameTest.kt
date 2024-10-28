package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.domain.CarName.Companion.asCarName

class CarNameTest {
    @Test
    fun `5글자 이하시 정상적으로 CarName 생성`() {
        // act, assert
        assertDoesNotThrow { "pobi".asCarName() }
    }

    @Test
    fun `5글자 초과시 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { "long car name".asCarName() }
    }

    @Test
    fun `이름을 지정하지 않을 경우 예외 발생`() {
        // act, assert
        assertThrows<IllegalArgumentException> { "".asCarName() }
    }

    @Test
    fun `toString시 정상적으로 지정한 이름의 문자열이 반환`() {
        // arrange
        val name = "pobi"
        val carName = name.asCarName()

        // act
        val result = carName.toString()

        // assert
        assertThat(result).isEqualTo(name)
    }
}

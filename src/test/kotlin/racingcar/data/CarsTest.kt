package racingcar.data

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("자동차들 테스트 케이스")
class CarsTest {

    @DisplayName("자동차 이름들 중 동일한 이름이 있을 경우")
    @ParameterizedTest
    @ValueSource(strings = ["hoho,hoho"])
    fun containsDuplicateNames(input: String) {
        assertThrows<IllegalArgumentException> { Cars(input) }
    }

    @DisplayName("레이스에 참가하는 자동차가 2대 보다 적을 경우")
    @ParameterizedTest
    @ValueSource(strings = ["hoho"])
    fun failWithOneCar(input: String) {
        assertThrows<IllegalArgumentException> { Cars(input) }
    }

    @DisplayName("레이스에 참가하는 자동차 정보를 입력하지 않았을 경우")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun emptyInput(input: String) {
        assertThrows<IllegalArgumentException> { Cars(input) }
    }
}
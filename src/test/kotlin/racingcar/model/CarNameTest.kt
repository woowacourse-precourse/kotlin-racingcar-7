package racingcar.model

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class CarNameTest {
    private lateinit var carName: CarName

    @BeforeEach
    fun setUp() {
        carName = CarName()
    }

    @Test
    @DisplayName("입력 이름 쉼표로 구분")
    fun `이름 구분 테스트`() {
        val input = "pobi,woni,jun"
        val expected = listOf("pobi", "woni", "jun")
        val result = carName.splitNameByComma(input)

        assertEquals(expected, result)
    }

    @DisplayName("이름에 문제가 없는 경우")
    @Nested
    inner class CheckDuplicateName {
        @Test
        @DisplayName("중복이름 변환")
        fun `중복 이름 변환 테스트`() {
            val input = listOf("pobi", "pobi", "woni", "jun", "woni", "pobi")
            val expected = listOf("pobi_0", "pobi_1", "pobi_2", "woni_0", "woni_1", "jun")
            val result = carName.changeDuplicateName(input)

            assertEquals(expected, result)
        }
    }

    @DisplayName("이름이 예외 처리가 되는 경우")
    @Nested
    inner class CarNameException {
        @Test
        @DisplayName("차량 수가 최소 범위를 벗어나는 경우")
        fun `차량 수가 2보다 작을 경우`() {
            val input = 1
            assertThrows<IllegalArgumentException> { InputException.numberOfCarsException(input) }
        }

        @Test
        @DisplayName("차량 수가 최대 범위를 벗어나는 경우")
        fun `차량 수가 16보다 클 경우`() {
            val input = 17
            assertThrows<IllegalArgumentException> { InputException.numberOfCarsException(input) }
        }

        @Test
        @DisplayName("이름 길이가 최소 범위를 벗어나는 경우")
        fun `이름 길이가 1보다 작을 경우`() {
            // 입력값은 .trim() 함수로 인해 공백이 사라짐, 즉 " "와 같은 값은 들어오지 않음
            val input = listOf("pobi", "", " woni")
            assertThrows<IllegalArgumentException> { InputException.carNameLengthLimitException(input) }
        }

        @Test
        @DisplayName("이름 길이가 최대 범위를 벗어나는 경우")
        fun `이름 길이가 5보다 클 경우`() {
            val input = listOf("pobi", "woni", "jun", "javaji")
            assertThrows<IllegalArgumentException> { InputException.carNameLengthLimitException(input) }
        }
    }
}
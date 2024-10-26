package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UtilsTest {

    @DisplayName("문자열을 콤마를 기준으로 분리에 성공")
    @Test
    fun successSplitComma() {
        val names = listOf("우테코", "화이팅")
        val result = splitComma(names.joinToString(","))

        assertTrue(result[0] == names[0])
        assertTrue(result[1] == names[1])
    }
}
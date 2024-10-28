package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ParserTest {
    lateinit var testParser: MyParser

    @BeforeEach
    fun setTest() {
        testParser = MyParser()
    }

    @Test
    fun `이름 파싱 테스트`() {
        //given
        val input = "a, b, c"

        //when
        val names = testParser.parseNames(input)

        //then
        assertThat(names.size).isEqualTo(3)
        assertThat(names).containsExactly("a","b","c")
    }

    @Test
    fun `이름이 5글자 이상인 경우 오류 테스트`() {
        //given
        val input = "abcdefg, hijk"

        //when
        val parseNames = { testParser.parseNames(input) }

        //then
        assertThatThrownBy { parseNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 5글자 이하여야 합니다")
    }

    @Test
    fun `숫자 파싱 테스트`() {
        //given
        val input = "5"

        //when
        val turns = testParser.parseTurns(input)

        //then
        assertThat(turns).isEqualTo(5)
    }

    @Test
    fun `숫자가 아닌 경우 오류 테스트`() {
        //given
        val input = "abcd"

        //when
        val parseTurns = { testParser.parseTurns(input) }

        //then
        assertThatThrownBy { parseTurns() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 아닙니다")
    }
}

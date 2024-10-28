package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class RaceTest {
    private lateinit var race: Race

    @BeforeEach
    fun setUp() {
        race = Race()
    }

    @DisplayName("시도할 횟수")
    @Nested
    inner class TryCount {

        @DisplayName("시도할 횟수가 정수일 경우")
        @Nested
        inner class CheckRange {

            @Test
            @DisplayName("시도할 횟수가 최소 범위를 벗어나는 경우")
            // 최소 범위는 1
            fun `시도할 횟수가 1미만일 경우`() {
                val input = -1
                assertThrows<IllegalArgumentException> { InputException.outOfTryCountRange(input) }
            }

            @Test
            @DisplayName("시도할 횟수가 최대 범위를 벗어나는 경우")
            // 최대 범위는 15
            fun `시도할 횟수가 15초과일 경우`() {
                val input = 16
                assertThrows<IllegalArgumentException> { InputException.outOfTryCountRange(input) }
            }
        }

        @DisplayName("시도할 횟수가 정수가 아닐 경우")
        @Nested
        inner class CheckInteger {

            @DisplayName("숫자와 문자가 섞인 경우")
            @Nested
            inner class MixedStrings {

                @Test
                @DisplayName("문자가 섞인 경우")
                fun `숫자 + 문자 테스트`() {
                    val input = "5번"
                    assertThrows<IllegalArgumentException> { InputException.nonIntegerException(input) }
                }

                @Test
                @DisplayName("특수문자가 섞인 경우")
                fun `숫자 + 특수문자 테스트`() {
                    val input = "5.1"
                    assertThrows<IllegalArgumentException> { InputException.nonIntegerException(input) }
                }
            }

            @Test
            @DisplayName("빈 값인 경우")
            // 입력시 .trim()을 사용하므로 공백인 값은 빈값으로 들어오게 된다.
            fun `빈 값 테스트`() {
                val input = ""
                assertThrows<IllegalArgumentException> { InputException.nonIntegerException(input) }
            }
        }
    }

    @DisplayName("레이스 테스트")
    @Nested
    inner class RaceRound {

        @DisplayName("전진 테스트")
        @Test
        fun `전진 테스트`() {
            val input = listOf("pobi" to 0, "woni" to 0)
            val expected = listOf("pobi" to 0, "woni" to 1)

            assertRandomNumberInRangeTest(
                {
                    val result = race.updateCarLocation(input)
                    assertThat(result).isEqualTo(expected)
                },
                STOP, MOVING_FORWARD // round 1
            )
        }

        @DisplayName("우승자 산출 테스트")
        @Nested
        inner class GetWinner {
            @DisplayName("우승자가 한명일 경우")
            @Test
            fun `단일 우승자 테스트`() {
                val input = listOf("pobi" to 5, "woni" to 4, "jun" to 2)
                val expected = "pobi"
                val result = race.getWinners(input)

                assertEquals(expected, result)
            }

            @DisplayName("우승자가 여러명일 경우")
            @Test
            fun `동시 우승자 테스트`() {
                val input = listOf("pobi" to 5, "woni" to 4, "jun" to 5, "hong" to 5, "jane" to 5)
                val expected = "pobi, jun, hong, jane"
                val result = race.getWinners(input)

                assertEquals(expected, result)
            }
        }
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
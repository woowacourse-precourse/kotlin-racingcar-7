package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class RacingGameUnitTest : NsTest() {
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame()
    }

    @ParameterizedTest
    @DisplayName("다양한 개수의 자동차 이름을 입력받아 LinkedHashMap으로 초기화")
    @MethodSource("carNameTestCases")
    fun splitCarNamesWithDifferentSizes(input: String, expectedSize: Int) {
        assertSimpleTest {
            // given
            run(input)

            // when
            val carNames = racingGame.inputCarNames()

            // then
            assertThat(carNames).hasSize(expectedSize)
            assertThat(carNames.keys.toList()).containsExactly(*input.split(",").toTypedArray())
            assertThat(carNames.values).allMatch { it == 0 }
        }
    }

    @ParameterizedTest
    @DisplayName("다양한 경기 시도 횟수를 입력받아 정수형으로 저장")
    @ValueSource(strings = ["1", "5", "10", "100"])
    fun setTryCount(input: String) {
        assertSimpleTest {
            // given
            run(input)

            // when
            val tryCount = racingGame.inputTryCount()

            // then
            assertThat(tryCount).isEqualTo(input.toInt())
        }
    }

    @Test
    @DisplayName("자동차 경주 1회 실행 검증")
    fun raceResultTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun", "1")

                // when
                racingGame.gameStart()
                racingGame.singleRace()

                // then
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -"
                )
            },
            MOVING_FORWARD,  // 4: 전진
            STOP,           // 3: 정지
            MOVING_FORWARD  // 4: 전진
        )
    }


    override fun runMain() {}

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3

        @JvmStatic
        fun carNameTestCases(): Stream<Arguments> = Stream.of(
            Arguments.of("pobi,woni,jun", 3),
            Arguments.of("pobi,woni,jun,meda", 4),
            Arguments.of("pobi", 1),
            Arguments.of("pobi,woni,jun,meda,ndro", 5)
        )
    }
}
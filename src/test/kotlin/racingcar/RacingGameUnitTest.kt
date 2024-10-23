package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameUnitTest : NsTest() {
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame()
    }

//    @ParameterizedTest
//    @DisplayName("다양한 개수의 자동차 이름을 입력받아 LinkedHashMap으로 초기화")
//    @CsvSource(
//        value = [
//            "pobi,woni,jun:3",
//            "pobi,woni,jun,meda:4",
//            "pobi:1",
//            "pobi,woni,jun,meda,ndro:5"
//        ],
//        delimiter = ':'
//    )
//    fun splitCarNamesWithDifferentSizes(input: String, expectedSize: Int) {
//        assertSimpleTest {
//            // given
//            run(input)
//
//            // when
//            val carNames = racingGame.inputCarNames()
//
//            // then
//            assertThat(carNames).hasSize(expectedSize)
//            assertThat(carNames.keys.toList()).containsExactly(*input.split(",").toTypedArray())
//            assertThat(carNames.values).allMatch { it == 0 }
//        }
//    }

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
    @DisplayName("자동차 경주 1회 실행하는 메소드 검사")
    fun raceResultTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun", "1")

                // when
                racingGame.gameStart()

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

    @Test
    @DisplayName("자동차 경주를 n회 실행하는 메소드 검사")
    fun multipleRaceResultTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun", "3")

                // when
                racingGame.gameStart()

                // then
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",
                    "pobi : -",
                    "woni : ",
                    "jun : --",
                    "pobi : --",
                    "woni : -",
                    "jun : ---"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,  // 첫 번째 경기
            STOP, STOP, MOVING_FORWARD,           // 두 번째 경기
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD  // 세 번째 경기
        )
    }

    @Test
    @DisplayName("최종 우승자를 한명을 출력하는 메소드 검사")
    fun finalWinnerTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun", "2")

                // when
                racingGame.gameStart()

                // then
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",
                    "pobi : -",
                    "woni : ",
                    "jun : --"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,  // 첫 번째 경기
            STOP, STOP, MOVING_FORWARD             // 두 번째 경기
        )
    }

    @Test
    @DisplayName("동점자가 존재시 최종 우승자를 출력하는 메소드 검사")
    fun finalTieWinnerTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun,meda", "2")

                // when
                racingGame.gameStart()

                // then
                assertThat(output()).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",
                    "meda : -",
                    "pobi : -",
                    "woni : ",
                    "jun : -",
                    "meda : -",
                    "최종 우승자 : pobi, jun, meda"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, // 첫 번째 경기
            STOP, STOP, STOP, STOP                                // 두 번째 경기
        )
    }

    override fun runMain() {}

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
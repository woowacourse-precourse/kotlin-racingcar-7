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
import racingcar.controller.RacingGameController
import racingcar.view.RacingGameView

class RacingGameUnitTest : NsTest() {
    private lateinit var racingGameController: RacingGameController

    @BeforeEach
    fun setUp() {
        val racingGameView = RacingGameView()
        racingGameController = RacingGameController(racingGameView)
    }

    @ParameterizedTest
    @DisplayName("다양한 경기 시도 횟수를 입력받아 정수형으로 저장")
    @ValueSource(strings = ["1", "5", "10", "100"])
    fun setTryCount(input: String) {
        assertSimpleTest {
            // given
            run(input)

            // when
            val tryCount = racingGameController.inputTryCount()

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
                racingGameController.gameStart()

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
                racingGameController.gameStart()

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
                racingGameController.gameStart()

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
                racingGameController.gameStart()

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
package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

class RacingGameUnitTest : NsTest() {
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame()
    }

    @Test
    @DisplayName("자동차 이름을 입력받아 쉼표로 분리하여 LinkedHashMap을 초기화")
    fun splitCarNames() {
        assertSimpleTest {
            // given
            run(CAR_NAMES)

            // when
            val carNames = racingGame.inputCarNames()

            // then
            assertThat(carNames).hasSize(3)
            assertThat(carNames.keys.toList()).containsExactly("pobi", "woni", "jun")
            assertThat(carNames.values).allMatch { it == 0 }
        }
    }

    @Test
    @DisplayName("경기 시도 횟수를 입력받아 정수형으로 저장")
    fun setTryCount() {
        assertSimpleTest {
            // given
            run(TRY_COUNT)

            // when
            val tryCount = racingGame.inputTryCount()

            // then
            assertThat(tryCount).isEqualTo(5)
        }
    }

    override fun runMain() {}

    companion object {
        private const val CAR_NAMES = "pobi,woni,jun"
        private const val TRY_COUNT = "5"
    }
}
package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `중복 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    private val preProcessing: PreProcessing = PreProcessing(Registaration("pobi,woni", 1))

    @Test
    fun `문자열 분리 테스트`() {
        assertSimpleTest {
            val testCase = preProcessing.preprocess()
            val resultList = listOf(Result("pobi"), Result("woni"))

            assertThat(testCase).isEqualTo(resultList)
        }
    }

    @Test
    fun `전진 횟수 테스트 - 4`() {
        assertRandomNumberInRangeTest(
            {
                val testCase = Racing().decideRacingCarMoving()

                assertThat(testCase).isEqualTo(1)
            },
            MOVING_FORWARD

        )
    }

    @Test
    fun `전진 횟수 테스트 - 2`() {
        assertRandomNumberInRangeTest(
            {
                val testCase = Racing().decideRacingCarMoving()

                assertThat(testCase).isEqualTo(0)
            },
            2

        )
    }

    @Test
    fun `각 턴의 결과 출력 테스트`() {
        assertSimpleTest {
            val testCase = listOf(
                Result("pobi", mutableListOf(MOVING_FORWARD)), Result("woni", mutableListOf(STOP))
            )

            OutputHandler().printRoundResult(testCase)
            assertThat(output()).isEqualTo("pobi : ----\nwoni : ---")
        }
    }

    @Test
    fun `총점 테스트`() {
        assertSimpleTest {
            val testCase = Racing().calculateTotalScore(listOf(1, 2, 3, 4, 5))

            assertThat(testCase).isEqualTo(15)
        }
    }

    val rewarding: Rewarding = Rewarding(
        listOf(
            Result("pobi", mutableListOf(MOVING_FORWARD), 4),
            Result("woni", mutableListOf(STOP), 3)
        )
    )

    @Test
    fun `우승자 찾기 테스트`() {
        assertSimpleTest {
            val testCase = rewarding.findWinner()

            assertThat(testCase[0].carName).isEqualTo("pobi")
        }
    }

    @Test
    fun `단일 우승자 출력하기`() {
        assertSimpleTest {
            rewarding.awardWinner()

            assertThat(output()).isEqualTo("최종 우승자 : pobi")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.contentOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertThrows
import racingcar.ApplicationTest.Companion
import racingcar.controller.RacingController
import racingcar.model.Repository
import racingcar.view.InOutView

class Test : NsTest() {
    @Test
    fun `입력 - 이름 길이 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("toolong,namelength", "1") }
            assertThrows<IllegalArgumentException> { runException("hwannow", "2") }
        }
    }

    @Test
    fun `입력 - 공백 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("toolong,namelength", "1") }
        }
    }

    @Test
    fun `경기 - 주어진 횟수 동안 자동차 전진 테스트`() {
        val repo = Repository()
        val view = InOutView(repo)
        val controller = RacingController(repo, view)

        repo.userInput = "qwer,asdf"
        repo.execCnt = 3

        assertRandomNumberInRangeTest(
            { controller.startRacing() },
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP
        )

        repo.racingCars.forEach {
            assertThat(it.moveCnt).isEqualTo(2)
        }
    }

    @Test
    fun `결과 - 우승자 한 명인 경우 테스트`() {
        val repo = Repository()
        val view = InOutView(repo)
        val controller = RacingController(repo, view)

        repo.userInput = "qwer,asdf"
        repo.execCnt = 3

        assertRandomNumberInRangeTest(
            { controller.startRacing() },
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP
        )

        assertEquals(repo.winner, mutableListOf("qwer"))
    }

    @Test
    fun `결과 - 우승자 여러 명인 경우 테스트`() {
        val repo = Repository()
        val view = InOutView(repo)
        val controller = RacingController(repo, view)

        repo.userInput = "qwer,asdf"
        repo.execCnt = 3

        assertRandomNumberInRangeTest(
            { controller.startRacing() },
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD
        )

        assertEquals(repo.winner, mutableListOf("qwer", "asdf"))
    }

    @Test
    fun `출력 - 우승자가 한 명인 경우 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("abcd,efgh,ijkl", "1")
                assertThat(output()).contains("abcd : -", "efgh : ", "ijkl : ", "최종 우승자 : abcd")
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `출력 - 우승자가 여러 명인 경우 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("abcd,efgh,ijkl", "1")
                assertThat(output()).contains("abcd : -", "efgh : -", "ijkl : -", "최종 우승자 : abcd, efgh, ijkl")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
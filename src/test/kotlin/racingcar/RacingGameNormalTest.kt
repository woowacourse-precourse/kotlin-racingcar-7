package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameNormalTest : NsTest() {
    @Test
    @DisplayName("입출력 요구사항의 실행 예제 검사")
    fun gameExampleTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("pobi,woni,jun", "5")

                // then
                val expected = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 횟수는 몇 회인가요?
                
                실행 결과
                pobi : -
                woni : 
                jun : -
                
                pobi : --
                woni : -
                jun : --
                
                pobi : ---
                woni : --
                jun : ---
                
                pobi : ----
                woni : ---
                jun : ----
                
                pobi : -----
                woni : ----
                jun : -----

                최종 우승자 : pobi, jun
            """.trimIndent()

                assertThat(output().normalize()).contains(expected.normalize())
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    @DisplayName("참가자가 한명일때 검사")
    fun gameOneUserTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("a", "1")

                // then
                val expected = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 횟수는 몇 회인가요?
                
                실행 결과
                a : -
                
                최종 우승자 : a
            """.trimIndent()

                assertThat(output().normalize()).contains(expected.normalize())
            },
            MOVING_FORWARD
        )
    }

    @Test
    @DisplayName("중간에 공백이 포함된 이름 검사")
    fun betweenSpaceTest() {
        assertRandomNumberInRangeTest(
            {
                // given
                run("a a,b bb,ccccc", "1")

                // then
                val expected = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 횟수는 몇 회인가요?
                
                실행 결과
                a a : -
                b bb : 
                ccccc : 
                
                최종 우승자 : a
            """.trimIndent()

                assertThat(output().normalize()).contains(expected.normalize())
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    override fun runMain() {
        main()
    }

    private fun String.normalize(): String {
        return this.replace("\r\n", "\n")
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
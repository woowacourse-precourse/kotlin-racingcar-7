package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest() {
    @Test
    fun `자동차 및 시도횟수 입력_레이스 시작_무작위 값에 따른 결과 출력`() {
        val numberGenerator = RandomNumberGeneratorStub(arrayListOf(5, 5, 5, 5, 1, 5, 5, 5, 5))
        val outputView = OutputView()
        val race = Race(numberGenerator, outputView)
        race.initializeRace(
            listOf(
                Car(name = "pobi", position = 0),
                Car(name = "woni", position = 0),
                Car(name = "jun", position = 0)
            ),
            tryCount = 3
        )
        race.startRace()
        assertSimpleTest {
            assertThat(output()).contains(
                "pobi : -\n" +
                        "woni : -\n" +
                        "jun : -\n" +
                        "\n" +
                        "pobi : --\n" +
                        "woni : -\n" +
                        "jun : --\n" +
                        "\n" +
                        "pobi : ---\n" +
                        "woni : --\n" +
                        "jun : ---"
            )
        }
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }
}
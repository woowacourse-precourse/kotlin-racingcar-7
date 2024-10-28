package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.stub.OutputViewStub
import racingcar.stub.RandomNumberGeneratorStub

class RaceWinnerTest : NsTest() {
    val outputStub = OutputViewStub()
    val inputView = InputView()
    val inputValidator = InputValidator()

    @Test
    fun `자동차 및 시도횟수 입력_경주 완료_단독 우승자 정상출력`() {
        val numberGenerator = RandomNumberGeneratorStub(arrayListOf(5, 1, 1, 5, 1, 1, 5, 1, 1))
        val race = Race(numberGenerator, outputStub)
        val raceManager =
            RaceManager(race = race, inputView = inputView, outputView = outputStub, inputValidator = inputValidator)
        race.initializeRace(
            listOf(
                Car(name = "pobi", position = 0),
                Car(name = "woni", position = 0),
                Car(name = "jun", position = 0)
            ),
            tryCount = 3
        )
        race.startRace()
        raceManager.printFinalResult()

        assertSimpleTest {
            assertThat(output()).contains("최종 우승자 : pobi")
        }
    }

    @Test
    fun `자동차 및 시도횟수 입력_경주 완료_공동 우승자 정상출력`() {
        val numberGenerator = RandomNumberGeneratorStub(arrayListOf(5, 1, 5, 5, 1, 5, 5, 1, 5))
        val race = Race(numberGenerator, outputStub)
        val raceManager =
            RaceManager(race = race, inputView = inputView, outputView = outputStub, inputValidator = inputValidator)
        race.initializeRace(
            listOf(
                Car(name = "pobi", position = 0),
                Car(name = "woni", position = 0),
                Car(name = "jun", position = 0)
            ),
            tryCount = 3
        )
        race.startRace()
        raceManager.printFinalResult()

        assertSimpleTest {
            assertThat(output()).contains("최종 우승자 : pobi, jun")
        }
    }

    @Test
    fun `자동차 및 시도횟수 입력_모두 출발선에서 안 움직이고 경주 완료_전원 우승자 정상출력`() {
        val numberGenerator = RandomNumberGeneratorStub(arrayListOf(1, 1, 1, 1, 1, 1, 1, 1, 1))
        val race = Race(numberGenerator, outputStub)
        val raceManager =
            RaceManager(race = race, inputView = inputView, outputView = outputStub, inputValidator = inputValidator)
        race.initializeRace(
            listOf(
                Car(name = "pobi", position = 0),
                Car(name = "woni", position = 0),
                Car(name = "jun", position = 0)
            ),
            tryCount = 3
        )
        race.startRace()
        raceManager.printFinalResult()

        assertSimpleTest {
            assertThat(output()).contains("최종 우승자 : pobi, woni, jun")
        }
    }

    override fun runMain() {
        TODO("Not yet implemented")
    }
}
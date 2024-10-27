package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingCarGameTest {

    @Test
    @DisplayName("자동차의 이름과 전진하는 자동차를 출력한다.")
    fun `자동차의 이름과 전진하는 자동차를 출력한다`() {
        val racingCarGame = RacingCarGame("hyeon", "1")
        racingCarGame.addRacingCar()
        racingCarGame.forwardCar(racingCarGame.racingCars[0],4)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        racingCarGame.printResultByStep()

        System.setOut(System.out)

        assertEquals("hyeon : -\n\n", outputStream.toString())
    }

    @Test
    @DisplayName("랜덤 번호가 4 이상일 때만 전진한다.")
    fun `랜덤 번호가 4 이상일 때만 전진한다`() {
        val racingCarGame = RacingCarGame("hyeon", "1")
        val racingCar = RacingCar(name = "hyeon", forwardCount = 0)
        racingCarGame.forwardCar(racingCar, randomNumber = 4)
        assertEquals(1, racingCar.forwardCount)
    }

    @Test
    @DisplayName("우승자가 여러 명일 때 쉼표로 구분하여 출력한다.")
    fun `우승자가 여러 명일 때 쉼표로 구분하여 출력한다`() {
        val racingCarGame = RacingCarGame("hyeon,sumin", "1")
        racingCarGame.start()
        if (racingCarGame.findRaceWinners().count() == 2) {
            assertEquals("최종 우승자 : hyeon,sumin", OutputHandler().printRacingWinner(racingCarGame.findRaceWinners()))
        }
    }
}
package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@DisplayName("자동차 경주 테스트")
class RacingCarTest {
    private val racingCarController = RacingCarController()

    @Test
    @DisplayName("자동차명 리스트를 입력할 경우 위치가 0인 자동차 객체 생성")
    fun `자동차명 리스트를 입력할 경우 위치가 0인 자동차 객체 생성`() {
        val inputCarList: List<String> = listOf("aaa", "bb")
        val carList: List<RacingCar> = racingCarController.createRacingCarList(inputCarList)

        assertEquals(listOf(RacingCar("aaa", 0), RacingCar("bb", 0)), carList)
    }

    @Test
    @DisplayName("랜덤값이 4이상일 경우만 자동차 위치 이동")
    fun `랜덤값이 4이상일 경우만 자동차 위치 이동`() {
        val randomNumber = 4

        assertTrue(racingCarController.isValidMoveCondition(randomNumber))
    }

    @Test
    @DisplayName("우승자가 여러명일 경우 쉼표로 구분하여 출력")
    fun `우승자가 여러명일 경우 쉼표로 구분하여 출력`() {
        val carList: List<RacingCar> = listOf(RacingCar("aaa", 3), RacingCar("bb", 2), RacingCar("cccc", 3))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        racingCarController.checkFinalWinner(carList)

        val output = outputStream.toString().trim()
        assertEquals("최종 우승자 : aaa, cccc", output)

        System.setOut(System.out)
    }
}
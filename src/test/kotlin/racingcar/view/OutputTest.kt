import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.utils.Constants
import racingcar.view.Output
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    private lateinit var output: Output
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        output = Output()
        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun `결과 메시지를 출력한다`() {
        output.printResultMessage()

        assertEquals("${Constants().RESULT}\n", outputStream.toString())
    }

    @Test
    fun `각 자동차의 경주 결과를 출력한다`() {
        val car = Car("Car1")

        output.printEachRacingResult(car)

        val expectedOutput = "Car1 : \n"
        assertEquals(expectedOutput, outputStream.toString())
    }

    @Test
    fun `우승자를 출력한다`() {
        val winners = mapOf("Car1" to 3, "Car2" to 3)

        output.printWinner(winners)

        val expectedOutput = "${Constants().WINNER}Car1, Car2\n"
        assertEquals(expectedOutput, outputStream.toString())
    }
}

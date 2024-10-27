package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import racingcar.controller.RacingController
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {
    private val output = ByteArrayOutputStream()
    private val outputView = OutputView()
    private val controller = RacingController()

    @BeforeEach
    fun setOutput() {
        System.setOut(PrintStream(output))
    }

    @AfterEach
    fun resetOutput() {
        System.setOut(System.out)
        output.reset()
    }

    @Test
    fun `경주_차수별_자동차_전진_상태를_출력한다`() {
        val carState = mutableMapOf("car1" to 2, "car2" to 0, "car3" to 1)

        controller.printCarStates(carState)

        assertThat(output.toString().trim()).isEqualTo("car1 : --\ncar2 : \ncar3 : -")
    }

    @Test
    fun `가장_멀리_간_자동차가_우승자로_선정된다`() {
        val carState = mutableMapOf("car1" to 3, "car2" to 5, "car3" to 2)

        val winner = controller.getWinner(carState)
        outputView.printOutputWinner(winner)

        val expectedOutput = "최종 우승자 : car2\n"
        assertThat(output.toString()).isEqualTo(expectedOutput)
    }

    @Test
    fun `여러_자동차가_동시에_우승할_수_있다`() {
        val carState = mutableMapOf("car1" to 5, "car2" to 5, "car3" to 2)

        val winner = controller.getWinner(carState)
        outputView.printOutputWinner(winner)

        val expectedOutput = "최종 우승자 : car1, car2\n"
        assertThat(output.toString()).isEqualTo(expectedOutput)
    }
}

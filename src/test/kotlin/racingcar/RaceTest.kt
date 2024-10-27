package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat
import racingcar.controller.Race
import racingcar.view.OutputView

class RaceTest {
    private val race = Race()
    private val outputView = OutputView()
    private val output = ByteArrayOutputStream()

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
    fun `진행 결과 출력 확인`() {
        val info = mutableMapOf("pobi" to 2, "woni" to 5, "jun" to 1)
        outputView.printStatusOfMove(info)
        assertThat(output.toString().trim()).isEqualTo("pobi : --\nwoni : -----\njun : -")
    }

    @Test
    fun `우승자가 1명일 경우 출력 확인`() {
        val info = mutableMapOf("pobi" to 5, "woni" to 2, "jun" to 6)
        race.winner(info)
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : jun")
    }

    @Test
    fun `우승자가 2명일 경우 출력 확인`() {
        val info = mutableMapOf("pobi" to 4, "woni" to 3, "jun" to 4)
        race.winner(info)
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, jun")
    }

    @Test
    fun `우승자가 3명일 경우 출력 확인`() {
        val info = mutableMapOf("pobi" to 3, "woni" to 3, "jun" to 3)
        race.winner(info)
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, woni, jun")
    }
}
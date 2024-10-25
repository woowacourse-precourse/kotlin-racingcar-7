package racingcar

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    private val outputView: OutputView = OutputView()
    private lateinit var outputStream: ByteArrayOutputStream
    private lateinit var originalOut: PrintStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        originalOut = System.out
        System.setOut(printStream)
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    private fun captureOutput(block: () -> Unit): String {
        block()
        return outputStream.toString()
    }

    @DisplayName("진행 사항 출력 테스트")
    @Test
    fun racingProgressPrintTest() {
        val input = listOf(
            Pair("일", 1), Pair("이", 2), Pair("삼", 3)
        )

        val expected = "일 : -\n이 : --\n삼 : ---\n"
        val output = captureOutput {
            outputView.printRacingProgress(input)
        }

        assertEquals(expected, output)
    }
}

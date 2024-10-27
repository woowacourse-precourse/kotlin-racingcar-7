package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest : NsTest() {

    @Test
    fun `실행결과 출력 테스트`() {
        assertRandomNumberInRangeTest({
            val outputStream = ByteArrayOutputStream()
            System.setOut(PrintStream(outputStream))

            runMain()

            val expectedOutput = """
                a : -
                b : 
                """.trimIndent()

            assertTrue(outputStream.toString().contains(expectedOutput))
        }, MOVING_FORWARD, STOP)
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }

    @Test
    fun `승자 출력 테스트`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val output = Output()
        output.winnerMsg(listOf("a", "b"))

        val expected = """
            최종 우승자 : a, b
        """.trimIndent()

        assertEquals(expected, outputStream.toString().trim())

        System.setOut(System.out)
    }

    override fun runMain() {
        val output = Output()
        val carA = Car("a")
        val carB = Car("b")

        carA.moves.add("-")
        carB.moves.add("")

        output.resultMsg(listOf(carA, carB), 1)
    }
}

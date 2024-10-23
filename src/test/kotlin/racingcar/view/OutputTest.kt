package racingcar.view

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {
    private lateinit var output: Output
    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        output = Output()
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun resultMsg() {
        val carNameList = listOf("Car1", "Car2")
        val moveCountList = listOf(listOf("-", ""), listOf("-", "-"))
        output.resultMsg(carNameList, moveCountList)
        val expectedOutput = """
            실행 결과
            Car1 : -
            Car2 : -
            
            Car1 : -
            Car2 : --
            
        """.trimIndent()

        assertEquals(expectedOutput.trim(), outContent.toString().trim())
    }

    @Test
    fun winnerMsg() {
        val winnerList = listOf("Car1", "Car2")
        output.winnerMsg(winnerList)
        val expectedOutput = """
            최종 우승자 : Car1, Car2
            """.trimIndent()

        assertEquals(expectedOutput.trim(), outContent.toString().trim())
    }
}

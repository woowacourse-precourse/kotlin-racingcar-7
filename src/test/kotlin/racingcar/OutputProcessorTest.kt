package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputProcessorTest {

    private val outputProcessor = OutputProcessor()
    private val outputStreamCaptor = ByteArrayOutputStream()

    init {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @Test
    fun `차수별 진행 결과 출력 테스트`() {
        val cars = listOf(
            Car("pobi").apply { position = 1 },
            Car("woni").apply { position = 2 },
            Car("jun").apply { position = 3 }
        )

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        OutputProcessor().printRaceProgress(cars)

        val expectedOutput = "pobi : -\nwoni : --\njun : ---\n\n"
        assertThat(outputStream.toString()).isEqualTo(expectedOutput)

        System.setOut(System.out) // 시스템 출력을 원래대로 돌려놓음
    }

    @Test
    fun `단독 우승자 출력 테스트`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        cars[0].move()
        cars[0].move()
        cars[1].move()

        outputProcessor.printWinners(cars)
        val expectedOutput = "최종 우승자 : pobi"

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput)
        outputStreamCaptor.reset()
    }

    @Test
    fun `공동 우승자 출력 테스트`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        cars[0].move()
        cars[1].move()
        cars[2].move()

        outputProcessor.printWinners(cars)
        val expectedOutput = "최종 우승자 : pobi, woni, jun"

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput)
        outputStreamCaptor.reset()
    }
}

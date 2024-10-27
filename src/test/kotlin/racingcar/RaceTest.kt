package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceTest {
    private lateinit var cars: List<Car>
    private lateinit var race: Race

    @BeforeEach
    fun setup() {
        cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        race = Race(cars, 5)
    }

    @Test
    fun `자동차의 맨 처음 위치는 0이어야 한다`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차는 한칸 이동하거나 움직이지 않아야 한다`() {
        val car = Car("pobi")
        car.stopOrMove()
        assertThat(car.position).isGreaterThanOrEqualTo(0).isLessThan(2)
    }

    @Test
    fun `게임의 우승자는 가장 먼 거리를 간 자동차이다`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        cars[0].position = 5
        cars[1].position = 3
        cars[2].position = 2
        race.printWinners()

        assertEquals("최종 우승자 : pobi", outputStream.toString().trim())
        System.setOut(System.out)
    }

    @Test
    fun `게임의 결과는 공동 수상을 허용해 우승자를 출력해야 한다`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        cars[0].position = 5
        cars[1].position = 5
        cars[2].position = 5
        race.printWinners()

        assertEquals("최종 우승자 : pobi, woni, jun", outputStream.toString().trim())
        System.setOut(System.out)
    }
}

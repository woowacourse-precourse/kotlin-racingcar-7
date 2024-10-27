package racingcar.domain.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.numbergenerator.NumberGenerator

class CarsTest {

    private lateinit var numberGenerator: TestNumberGenerator

    @BeforeEach
    fun setUp() {
        numberGenerator = TestNumberGenerator()
    }

    @Test
    fun `자동차들이 한 바퀴를 돈다`() {
        // given
        val cars = Cars(listOf(Car("tesla"), Car("kia"), Car("gm")))
        val expected = """
            tesla : -
            kia : 
            gm : -
            
        """.trimIndent()

        // when
        cars.lap(numberGenerator)

        // then
        Assertions.assertEquals(expected, cars.toString())
    }

    @Test
    fun `자동차들이 여러 바퀴를 돈다`() {
        // given
        val cars = Cars(listOf(Car("tesla"), Car("kia"), Car("gm")))
        val round = 3
        val expected = """
            tesla : ---
            kia : 
            gm : ---
            
        """.trimIndent()

        // when
        repeat(round) {
            cars.lap(numberGenerator)
            numberGenerator.init() // TestNumberGenerator 원하는 동작을 만족시키기 위해 초기화
        }

        // then
        Assertions.assertEquals(expected, cars.toString())
    }

    @Test
    fun `레이싱 경주의 우승자를 확인할 수 있다`() {
        // given
        val carRacers = Cars(listOf(Car("lecle"), Car("hamil"), Car("pobi")))
        val round = 3
        val expected = "lecle, pobi"
        // when
        repeat(round) {
            carRacers.lap(numberGenerator)
            numberGenerator.init()
        }

        //then
        Assertions.assertEquals(expected, carRacers.findWinners())
    }


    // 홀수번째 자동차는 1칸 이동하고, 짝수번째 자동차는 이동하지 않는다.
    internal class TestNumberGenerator : NumberGenerator {
        private var counter = 0
        override fun generateNumber(): Int {
            counter += 5
            return counter % 10
        }

        fun init() {
            counter = 0
        }
    }
}
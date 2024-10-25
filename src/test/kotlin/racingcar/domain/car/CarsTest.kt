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
        val cars = Cars("tesla,kia,gm")
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
        val cars = Cars("tesla,kia,gm")
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


    // 홀수번째 자동차는 1칸 이동하고, 짝수번째 자동차는 이동하지 않는다.
    private class TestNumberGenerator : NumberGenerator {
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
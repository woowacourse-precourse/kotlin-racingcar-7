package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Collections.max

class RacingCarTest {
    @BeforeEach
    fun setUp() {
        input = listOf("Car1", "Car2", "Car3")
        num = 5
        runSizeList = mutableListOf(3, 5, 5)
    }

    @Test
    fun `우승자 반환 테스트`() {
        val expectedWinners = listOf("Car2", "Car3")

        // Call function to find winners
        val maxRun = max(runSizeList)
        val winnerList =
            runSizeList
                .mapIndexedNotNull { index, it ->
                    if (it == maxRun) index else null
                }.map { input!![it] }

        assertThat(winnerList).isEqualTo(expectedWinners)
    }

    @Test
    fun `자동차 이름 5자 제한 테스트`() {
        input = listOf("Mandy", "Jon")

        val exception =
            org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
                input!!.forEach {
                    if (it.length > 5) throw IllegalArgumentException("이름은 5자보다 짧게 입력해주세요")
                }
            }
        assertThat(exception).hasMessageContaining("이름은 5자보다 짧게 입력해주세요")
    }
}

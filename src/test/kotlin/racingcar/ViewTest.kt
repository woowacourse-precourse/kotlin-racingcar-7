package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class ViewTest : NsTest() {
    private val view = View()

    @Test
    fun `경주 상황 출력`() {
        val testCars = listOf(Car("pobi", 5))
        view.showStatus(testCars)
        assertThat(output()).isEqualTo("pobi : -----")
    }

    @Test
    fun `maxPos인 우승자 출력`() {
        val testCars = listOf(Car("aaa", 1), Car("bbb", 2), Car("ccc", 3))
        view.showWinners(testCars)
        assertThat(output())
            .contains("ccc")
            .doesNotContain("aaa", "bbb")
    }

    @Test
    fun `maxPos인 중복 우승자 출력`() {
        val testCars = listOf(Car("aaa", 2), Car("bbb", 2), Car("ccc", 2))
        view.showWinners(testCars)
        assertThat(output())
            .contains("aaa", "bbb", "ccc")
    }

    override fun runMain() {
        main()
    }
}
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest

class RacingCarTest {

    @Test
    fun `자동차 이름이 조건에 맞는 경우 정상 처리`() {
        val racingCar = RacingCar()
        racingCar.inputCarName("pobi,jun") // 5자 이하의 이름들
        assertThat(racingCar.carList.map { it.name }).containsExactly("pobi", "jun")
    }

    @Test
    fun `자동차 이름에 공백이 포함된 경우도 정상 처리`() {
        val racingCar = RacingCar()
        racingCar.inputCarName("pobi,  jun  ")
        assertThat(racingCar.carList.map { it.name }).containsExactly("pobi", "jun")
    }

    @Test
    fun `자동차 이름이 5자를 초과할 때 예외 발생`() {
        val racingCar = RacingCar()
        assertThrows(IllegalArgumentException::class.java) {
            racingCar.inputCarName("pobi,longname") // longname은 5자 초과
        }
    }

    @Test
    fun `자동차 이름이 빈 문자열일 때 예외 발생`() {
        val racingCar = RacingCar()
        assertThrows(IllegalArgumentException::class.java) {
            racingCar.inputCarName("")
        }
    }

    @Test
    fun `시도 횟수가 정수인 경우 정상 처리`() {
        val racingCar = RacingCar()
        racingCar.inputTestCount("3") // 3회
    }

    @Test
    fun `시도 횟수가 정수가 아닌 경우 예외 발생`() {
        val racingCar = RacingCar()
        assertThrows(IllegalArgumentException::class.java) {
            racingCar.inputTestCount("three")
        }
    }

    @Test
    fun `시도 횟수가 음수인 경우 예외 발생`() {
        val racingCar = RacingCar()
        assertThrows(IllegalArgumentException::class.java) {
            racingCar.confirmInteger(-3)
        }
    }

    @Test
    fun `자동차가 전진 조건을 만족하는 경우 이동`() {
        val racingCar = RacingCar()
        racingCar.inputCarName("pobi,jun")
        racingCar.inputTestCount("1")

        assertRandomNumberInRangeTest(
            {
                racingCar.run(1)
                assertThat(racingCar.carList[0].count).isGreaterThan(0) // 무작위 값이 4 이상일 때 이동
            },
            4, 5, 6
        )
    }

    @Test
    fun `자동차가 전진 조건을 만족하지 않는 경우 이동하지 않음`() {
        val racingCar = RacingCar()
        racingCar.inputCarName("pobi,jun")
        racingCar.inputTestCount("1")

        assertRandomNumberInRangeTest(
            {
                racingCar.run(1)
                assertThat(racingCar.carList[0].count).isEqualTo(0) // 무작위 값이 4 미만일 때 이동하지 않음
            },
            0, 1, 2
        )
    }

    @Test
    fun `우승자가 여러 명일 때 모두 출력`() {
        val racingCar = RacingCar()
        racingCar.inputCarName("pobi,jun,woni")

        // 모든 자동차가 같은 횟수만큼 전진하도록 무작위 값 고정
        assertRandomNumberInRangeTest(
            {
                racingCar.run(3)
                racingCar.resultWinner()
                assertThat(racingCar.winnerList).containsExactlyInAnyOrder("pobi", "jun", "woni")
            },
            5, 5, 5
        )
    }

}

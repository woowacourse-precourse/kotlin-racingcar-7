package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    private val game= Game()
    @Test
    fun `자동차 이름 정상 입력시 Car 객체 리스트 생성 기능 테스트`() {
        val cars = game.inputCarNames("pobi,woni,min")

        assertThat(cars).hasSize(3)
        assertThat(cars[0].name).isEqualTo("pobi")
        assertThat(cars[1].name).isEqualTo("woni")
        assertThat(cars[2].name).isEqualTo("min")
    }
    @Test
    fun `시도할 횟수 입력 테스트`() {
        val roundCount = game.inputRoundCount("3")
        assertThat(roundCount).isEqualTo(3)
    }
    @Test
    fun `가장 멀리 이동한 거리 찾는 테스트`() {
        val cars = listOf(
            Car(name = "pobi", move = "---"),
            Car(name = "minji", move = "-"),
            Car(name = "jinu", move = "----")
        )
        val race = Race(cars, roundCount = 5)

        val longestDistance = race.findLongest()
        assertThat(longestDistance).isEqualTo(4)
    }

    @Test
    fun `가장 멀리 간 우승자 리스트 찾는 테스트`() {
        val cars = listOf(
            Car(name = "pobi", move = "---"),
            Car(name = "minji", move = "-"),
            Car(name = "jinu", move = "----")
        )
        val race = Race(cars, roundCount = 5)
        val winners = race.findWinners(4)
        assertThat(winners).containsExactly("jinu")
    }
    @Test
    fun `우승자 발표 기능 테스트`() {
        val cars = listOf(
            Car(name = "pobi", move = "---"),
            Car(name = "minji", move = "-"),
            Car(name = "jinu", move = "----")
        )
        val race = Race(cars, roundCount = 5)
        assertSimpleTest {
            run {
                race.announceWinner()
                assertThat(output()).contains("최종 우승자 : jinu")
            }
        }
    }
    @Test
    fun `자동차가 이동할 때 move 문자열 증가하는지 테스트`() {
        val car = Car(name = "test")

        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.move).isEqualTo("-")
            },4
        )
        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.move).isEqualTo("-")
            },3
        )
        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.move).isEqualTo("--")
            },5
        )
    }
    @Test
    fun `자동차 이동 거리 반환 기능 테스트`() {
        val car = Car(name = "test", move = "---")
        assertThat(car.getMoveDistance()).isEqualTo(3)

        assertRandomNumberInRangeTest({
            car.move()
            assertThat(car.getMoveDistance()).isEqualTo(4)
        },4
        )
    }
    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }
    @Test
    fun `이름이 공백일 경우 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("minji, ,jinu","3") }
        }
    }

    @Test
    fun `이름이 중복될 경우 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("minji,minji,jinu","4") }
        }
    }

    @Test
    fun `시도할 횟수가 양의 정수가 아닐 경우 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("kim,min,ji","-3") }
            assertThrows<IllegalArgumentException> { runException("minji,jinu","0") }
            assertThrows<IllegalArgumentException> { runException("minji,jinu","a") }
        }
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

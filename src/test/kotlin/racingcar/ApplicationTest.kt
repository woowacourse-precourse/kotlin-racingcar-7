package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
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
            MOVING_FORWARD, STOP, STOP, STOP
        )
    }

    @Test
    @DisplayName("Car 객체 기능 테스트")
    fun `자동차 기능 테스트`() {
        assertSimpleTest {
            val test = Car("a")

            test.move()
            assert(test.movedCount == 1)
            test.move()
            assert(test.movedCount == 2)

            repeat(10000000) {
                test.move()
            }
            assert(test.movedCount == 10000002)
        }
    }

    @Test
    @DisplayName("Dice 객체 기능 테스트")
    fun `주사위 기능 테스트` () {
        assertSimpleTest {
            val dice = Dice()
            repeat(100000000) {
                assert(dice.roll() in 0 .. 9)
            }
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("d", "\n") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,d", "1") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,d", "z") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,d", "-1") }
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

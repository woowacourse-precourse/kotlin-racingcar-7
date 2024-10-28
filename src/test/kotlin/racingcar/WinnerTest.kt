package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.utils.SettingValue.Companion.MINIMUM_NUMBER_TO_ONE_STEP_FORWARD

class WinnerTest : NsTest() {
    @Test
    fun `공동 우승자 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("kim,lee", "1")
                assertThat(output()).contains("kim : -", "lee : -", "최종 우승자 : kim, lee")
            },
            MINIMUM_NUMBER_TO_ONE_STEP_FORWARD,
            MINIMUM_NUMBER_TO_ONE_STEP_FORWARD
        )
    }

    override fun runMain() {
        main()
    }
}

package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.utils.Messages
import racingcar.utils.Validator

class ApplicationTest : NsTest() {

    @ParameterizedTest
    @ValueSource(strings = ["carcar", "carcarcarcar"])
    fun `자동차 이름 길이 수는 5 이하여야 한다`(carName: String) {
        assertThatThrownBy {
            run("$carName, $carName")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.INVALID_CAR_NAME_LENGTH)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "5", "-", "k-5", "5k", "5가"])
    fun `자동차 이름은 문자열 또는 문자열 + 숫자 또는 문자열 + 숫자 + 문자열의 형태만 가능하다`(carName: String) {
        assertThatThrownBy {
            run("$carName, $carName")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.INVALID_CAR_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "a", "가"])
    fun `시도할 횟수는 정수이어야 한다`(moveCount: String) {
        assertThatThrownBy {
            run("car,car2,car3", moveCount)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.INVALID_MOVE_COUNT)
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

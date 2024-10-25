package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.controller.RacingGameController
import racingcar.domain.InputValidator
import racingcar.domain.RacingGameService
import racingcar.view.RacingGameView

class RacingGameExceptionTest : NsTest() {
    private lateinit var racingGameController: RacingGameController
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        val racingGameView = RacingGameView()
        inputValidator = InputValidator()
        val racingGameService = RacingGameService()
        racingGameController = RacingGameController(racingGameView, inputValidator, racingGameService)
    }

    @Test
    @DisplayName("참가자가 없는 경우 예외 발생")
    fun emptyInput() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    fun validateCarNameLength() {
        // given
        val invalidNames = "pobi,javaji"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.carNamesValidate(invalidNames)
        }
    }

    @Test
    @DisplayName("자동차 이름이이 공백으로 시작하면 예외 발생")
    fun validateCarNameStartBlank() {
        // given
        val invalidNames = "aaa, po,pobi"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.carNamesValidate(invalidNames)
        }
    }

    @Test
    @DisplayName("자동차 이름이이 공백으로 끝나면 예외 발생")
    fun validateCarNameEndBlank() {
        // given
        val invalidNames = "bbb,po ,pobi"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.carNamesValidate(invalidNames)
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외 발생")
    fun validateDuplicateCarName() {
        // given
        val invalidNames = "pobi,pobi"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.carNamesValidate(invalidNames)
        }
    }

    @Test
    @DisplayName("시도 횟수를 입력하지 않으면 예외가 발생")
    fun validateTryCountEmpty() {
        // given
        val invalidCount = ""

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    @Test
    @DisplayName("시도 횟수가 0이면 예외가 발생")
    fun validateTryCountZero() {
        // given
        val invalidCount = "0"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    @Test
    @DisplayName("시도 횟수가 음수이면 예외 발생")
    fun validateTryCountMinus() {
        // given
        val invalidCount = "-1"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    @Test
    @DisplayName("시도 횟수에 소숫점이 존재하면 예외 발생")
    fun validateTryCountDecimalPoint() {
        // given
        val invalidCount = "1.0"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    fun validateTryCountNotNumber() {
        // given
        val invalidCount = "aaa"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    @Test
    @DisplayName("시도 횟수가 8자리를 초과하면 예외 발생")
    fun validateTryCountOver8digit() {
        // given
        val invalidCount = "123456789"

        // when & then
        assertThrows<IllegalArgumentException> {
            inputValidator.tryCountValidate(invalidCount)
        }
    }

    override fun runMain() {
        main()
    }
}
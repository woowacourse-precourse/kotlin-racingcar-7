package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
class RacingCarTest {

    private lateinit var game: Game

    @BeforeEach
    fun setup() {
        game = Game()
    }

    @Test
    fun `쉼표가 없는 입력이 들어오면 예외가 발생한다`() {
        val validation = Validation()
        assertThatIllegalArgumentException().isThrownBy {
            validation.validateInputHasComma("pobi jason")
        }.withMessageContaining("입력에는 쉼표(,)가 포함되어야 합니다.")
    }
    
}
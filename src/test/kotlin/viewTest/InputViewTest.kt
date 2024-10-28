package viewTest

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.view.InputView

class InputViewTest : NsTest() {

    @CsvSource(value = ["EMPTY", ",", " , ", "hyun,"], emptyValue = "EMPTY")
    @ParameterizedTest
    fun `자동차는 두 대 이상 입력해야 한다`(nameOfCars: String?) {
        //given
        val input = InputView()

        //when
        val nameOfCarsValidation = input.isNameOfCarsValid(nameOfCars)

        //then
        assertThat(nameOfCarsValidation).isFalse()
    }

    override fun runMain() {
    }

}
package viewTest

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.view.InputView

class InputViewTest : NsTest() {

    @CsvSource(value = ["EMPTY", ",", " , ", "hyun,"], emptyValue = "EMPTY")
    @ParameterizedTest
    fun `두 대 이상의 자동차가 입력되었는 지 확인`(nameOfCars: String?) {
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
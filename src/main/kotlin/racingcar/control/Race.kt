package racingcar.control

import racingcar.userInput.CarNameInput
import racingcar.userInput.CountInput
import racingcar.view.Message

class Race {
    fun race() {
        println(Message().carName)
        val carNameInput = CarNameInput().carNameInput()
        val carName = CarNameValidator().carNameValidator(carNameInput)

        println(Message().count)
        val countInput = CountInput().countInput()
        val count = CountValidator().countValidator(countInput)




    }
}
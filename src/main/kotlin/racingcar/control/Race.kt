package racingcar.control

import Cars
import racingcar.userInput.CarNameInput
import racingcar.userInput.CountInput
import racingcar.view.Message
import racingcar.view.Winner


class Race {
    fun race() {
        println(Message().CAR_NAME)
        val carName = CarNameValidator().carNameValidator(CarNameInput().carNameInput())
        val carList = Cars().cars(CarNameSeperator().carNameSeperator(carName))

        println(Message().COUNT)
        val count = CountValidator().countValidator(CountInput().countInput())

        println(Message().RESULT)
        val raceOver = Racing(carList, count).repeatRacing()
        val winner = WinnerSelection().winnerSelection(raceOver)
        Winner().winner(winner)
    }
}
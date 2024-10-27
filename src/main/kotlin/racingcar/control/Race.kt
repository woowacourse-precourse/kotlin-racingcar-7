package racingcar.control

import Cars
import racingcar.userInput.CarNameInput
import racingcar.userInput.CountInput
import racingcar.view.Message
import racingcar.view.Winner


class Race {
    fun start() {
        winnerAnnouncement()
    }

    fun carList(): List<CarData> {
        println(Message().CAR_NAME)
        val carName = CarNameValidator().carNameValidator(CarNameInput().carNameInput())
        val carList = Cars().cars(CarNameSeperator().carNameSeperator(carName))
        return carList
    }

    fun count(): Int {
        println(Message().COUNT)
        val count = CountValidator().countValidator(CountInput().countInput())
        return count
    }

    fun raceStart(): List<CarData> {
        val raceOver = Racing(carList(), count()).repeatRacing()
        return raceOver
    }

    fun winnerAnnouncement() {
        val winner = WinnerSelection().winnerSelection(raceStart())
        Winner().winner(winner)
    }
}
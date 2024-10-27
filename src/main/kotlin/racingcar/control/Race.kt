package racingcar.control

import racingcar.view.InputCarName
import racingcar.view.InputCount
import racingcar.view.OutputWinner
import racingcar.message.Other

class Race {
    fun start() {
        winnerAnnouncement()
    }

    private fun carList(): List<CarData> {
        println(Other().CAR_NAME)
        val carName = CarNameValidator().carNameValidator(InputCarName().carNameInput())
        return Cars().cars(CarNameSeperator().carNameSeperator(carName))
    }

    private fun count(): Int {
        println(Other().COUNT)
        val count = CountValidator().countValidator(InputCount().countInput())
        return count
    }

    private fun raceStart(): List<CarData> {
        val raceOver = Racing(carList(), count()).repeatRacing()
        return raceOver
    }

    private fun winnerAnnouncement() {
        val winner = WinnerSelection().winnerSelection(raceStart())
        OutputWinner().winner(winner)
    }
}
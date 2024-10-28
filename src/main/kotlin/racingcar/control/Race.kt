package racingcar.control

import racingcar.view.InputCarName
import racingcar.view.InputCount
import racingcar.view.OutputWinner
import racingcar.message.Other

class Race {
    fun start() {
        val cars = carList()
        val raceCount = count()
        val raceFinish = startRace(cars, raceCount)
        announceWinner(raceFinish)
    }

    private fun carList(): List<CarData> {
        println(Other.CAR_NAME)
        val carName = CarNameValidation().validateCarName(InputCarName().carNameInput())
        return CarWithPoints().combineCarWithPoints(CarNameSplitter().splitNames(carName))
    }

    private fun count(): Int {
        println(Other.COUNT)
        return CountValidation().validateCount(InputCount().countInput())
    }

    private fun startRace(cars: List<CarData>, raceCount: Int): List<CarData> {
        return RaceStart(cars, raceCount).repeatRace()
    }

    private fun announceWinner(startRace: List<CarData>) {
        val winner = WinnerSelector().selectWinner(startRace)
        OutputWinner().announceWinner(winner)
    }
}
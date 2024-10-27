package racingcar.stub

import racingcar.Car
import racingcar.OutputView
import racingcar.OutputViewInterface

//RaceWinnerTest에 쓰이는 OutputView 스텁
class OutputViewStub : OutputViewInterface {
    override fun printRaceResult(cars: List<Car>) {
        //테스트 편의를 위해 구현 x
    }

    override fun printRaceWinners(winners: List<Car>) {
        val outputView = OutputView()
        return outputView.printRaceWinners(winners)
    }
}
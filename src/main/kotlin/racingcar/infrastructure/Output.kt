package racingcar.infrastructure

import racingcar.domain.Car

interface Output {
  fun showMessage()
  fun showRoundResult(cars: List<Car>)
  fun showWinners(winners: List<String>)
}
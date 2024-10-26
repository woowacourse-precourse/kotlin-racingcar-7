package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.view.InputView

class RaceController {
    private val cars = mutableListOf<Car>()

    fun startRace() {
        val carNames = InputView.getCarNames()
    }

}

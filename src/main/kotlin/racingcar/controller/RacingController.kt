package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Repository
import racingcar.view.InOutView

class RacingController(private val repo: Repository, private val view: InOutView) {
    fun startRacing() {
        repo.separateCarName()

        view.printExecResultText()
        for (round in 0 until repo.execCnt) {
            moveAllCars()
            view.printAllCarsMoveCnt()
        }

        repo.selectWinner()
    }

    private fun moveAllCars() {
        for (carIdx in repo.racingCars.indices) {
            moveForward(carIdx)
        }
    }

    private fun moveForward(index: Int) {
        val random = Randoms.pickNumberInRange(0, 9)

        if (random >= 4) {
            repo.increaseMoveCnt(index)
        }
    }
}
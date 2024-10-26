package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Repository

class RacingController(private val repo: Repository) {
    fun startRacing() {
        println("\n실행 결과")

        for (round in 0 until repo.execCnt) {
            moveAllCars()
            printAllCars()
            println("")
        }
    }

    private fun moveAllCars() {
        for (carIdx in repo.racingCars.indices) {
            moveForward(carIdx)
        }
    }

    private fun moveForward(index: Int) {
        val random = Randoms.pickNumberInRange(0, 9)

        if (random >= 4) {
            repo.increaseMove(index)
        }
    }

    private fun printAllCars() {
        for (carIdx in repo.racingCars.indices) {
            printCar(carIdx)
        }
    }

    private fun printCar(index: Int) {
        val carName = repo.racingCars[index].carName
        val position = "-".repeat(repo.racingCars[index].moveCnt)
        println("$carName : $position")
    }
}
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
        for (carIdx in repo.racingCar.indices) {
            moveForward(carIdx)
        }
    }

    private fun moveForward(index: Int) {
        val random = Randoms.pickNumberInRange(0, 9)

        if (random >= 4) {
            repo.moveCnt[index] += 1
        }
    }

    private fun printAllCars() {
        for (carIdx in repo.racingCar.indices) {
            printCar(carIdx)
        }
    }

    private fun printCar(index: Int) {
        val carName = repo.racingCar[index]
        val position = "-".repeat(repo.moveCnt[index])
        println("$carName : $position")
    }
}
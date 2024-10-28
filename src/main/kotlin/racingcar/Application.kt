package racingcar

import racingcar.view.carnameinputview
import racingcar.view.racenuminputview
import racingcar.view.raceoutput
import racingcar.view.winnerprint

fun main() {
    val carname = carnameinputview()
    val racenum = racenuminputview()

    val carscore = Array<Int>(carname.size, { 0 })

    raceoutput(carname, racenum, carscore)
    winnerprint(carscore, carname)
}

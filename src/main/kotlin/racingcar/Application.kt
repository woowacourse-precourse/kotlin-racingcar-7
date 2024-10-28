package racingcar

import racingcar.view.carnameinputview
import racingcar.view.racenuminputview

fun main() {
    val carname = carnameinputview()
    val racenum = racenuminputview()

    val carscore = Array<Int>(carname.size,{0})

}

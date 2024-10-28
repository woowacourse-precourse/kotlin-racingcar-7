package racingcar.carrandomvalue

import camp.nextstep.edu.missionutils.Randoms

fun carrandomgo(carname: List<String>, carscore: Array<Int>) {
    for (randomgo: Int in carname.indices) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carscore[randomgo] += 1
        }
    }
}
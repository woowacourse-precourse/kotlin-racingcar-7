package racingcar.view

import racingcar.carrandomvalue.carrandomgo

fun raceoutput(carname: List<String>, racenum: Int, carscore: Array<Int>) {
    println("\n실행 결과")
    for(race: Int in 0..<racenum){
        carrandomgo(carname,carscore)
    }
}
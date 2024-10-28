package racingcar.view

import racingcar.carrandomvalue.carrandomgo
import racingcar.winner.maxpointfind

fun raceoutput(carname: List<String>, racenum: Int, carscore: Array<Int>) {
    println("\n실행 결과")
    for(race: Int in 0..<racenum){
        carrandomgo(carname,carscore)
        raceprint(carname,carscore)
    }
}

fun raceprint(carname: List<String>, carscore: Array<Int>) {
    for(scoreindex: Int in carname.indices) {
        val car = carname[scoreindex]
        print("$car : ")
        println("-".repeat(carscore[scoreindex]))
    }
    println()
}

fun winnerprint(carscore: Array<Int>, carname: List<String>){
    var scoremax = 0
    var winnersep = 0

    print("최종 우승자 : ")
    scoremax = maxpointfind(carscore)
    for(win:Int in carname.indices){
        if(scoremax==carscore[win]){
            winnerseperate(winnersep)
            print(carname[win])
            winnersep++
        }
    }
}

fun winnerseperate(winnersep: Int) {
    if(winnersep>0){
        print(", ")
    }
}
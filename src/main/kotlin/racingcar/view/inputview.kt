package racingcar.view

import camp.nextstep.edu.missionutils.Console

fun carnameinputview(): List<String> {
    val carname_print = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    println(carname_print)

    val carname= readLine()?.split(",") ?: throw IllegalArgumentException()

    for(car in carname){
        if(car.length>5||car==""){
            throw IllegalArgumentException()
        }
    }
    return carname
}
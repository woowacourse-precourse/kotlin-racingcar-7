package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

    val input = Console.readLine()
    val inputList = splitCar(input)
    val CarList = makeCar(inputList)
    val number = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
    val race = Race(CarList,number)
    race.runRace()
}

fun splitCar(input:String):List<String>{
    val carList = input.split(",")
    for (car in carList){
        if (car.length>5){
            throw IllegalArgumentException("5자 이상의 이름은 입력할 수 없습니다.")
        }
        else if(car.isEmpty()){
            throw IllegalArgumentException("이름을 빈칸으로 사용할 수 없습니다.")
        }
    }
    return carList
}


fun makeCar(carList:List<String>):MutableList<Car>{
    val returnList = mutableListOf<Car>()
    for(car in carList){
        returnList.add(Car(car))
    }
    return returnList
}
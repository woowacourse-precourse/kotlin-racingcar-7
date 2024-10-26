package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

    var input = Console.readLine()
    var inputList = splitCar(input)
    var CarList = makeCar(inputList)
    for(Car in CarList){
        Car.CarName()
    }
    // TODO: 프로그램 구현
}

fun splitCar(input:String):List<String>{
    var carList = input.split(",")
    for (car in carList){
        if (car.length>5){
            throw IllegalArgumentException("5자 이상의 이름은 입력할 수 없습니다.")
        }
    }
    return carList
}


fun makeCar(carList:List<String>):MutableList<Car>{
    var returnList = mutableListOf<Car>()
    for(car in carList){
        returnList.add(Car(car))
    }
    return returnList
}
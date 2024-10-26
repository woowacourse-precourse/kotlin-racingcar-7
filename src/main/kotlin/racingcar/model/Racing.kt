package racingcar.model

import racingcar.utils.Validation
import racingcar.view.Output

class Racing {
    fun readyToRace(carNames:List<String>):List<Car>{
        Validation().carNameLength(carNames)
        val cars = mutableListOf<Car>()
        for (name in carNames){
            cars.add(Car(name))
        }
        return cars
    }

    fun eachRacing(cars:List<Car>):List<Car>{
        for (car in cars){
            if (Random().randomGenerator())
                car.go()
            Output().printEachRacingResult(car)
        }
        return cars
    }
    fun racing(count:Int,cars:List<Car>){
        var racingCars = cars
        Output().printResultMessage()
        repeat(count){
            racingCars = eachRacing(cars)
        }
    }
}
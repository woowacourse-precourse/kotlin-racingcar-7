package racingcar.model

import racingcar.utils.Validation

class Racing {
    fun readyToRace(carNames:List<String>):List<Car>{
        Validation().carNameLength(carNames)
        val cars = mutableListOf<Car>()
        for (name in carNames){
            cars.add(Car(name))
        }
        return cars
    }

    fun racing(count:Int,cars:List<Car>){
        repeat(count){
            for (car in cars){
                if (Random().randomGenerator())
                    car.go()
            }
        }
    }
}
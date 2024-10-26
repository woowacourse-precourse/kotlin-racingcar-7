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

    fun racing(count:Int){

    }
}
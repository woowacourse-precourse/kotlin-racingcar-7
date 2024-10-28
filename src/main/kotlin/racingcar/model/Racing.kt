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

    private fun eachRace(cars:List<Car>):List<Car>{
        for (car in cars){
            car.go()
            Output().printEachRacingResult(car)
        }
        println()
        return cars
    }
    fun race(count:Int,cars:List<Car>){
        var racingCars = cars
        Output().printResultMessage()
        repeat(count){
            racingCars = eachRace(cars)
        }
        judgeWinner(racingCars)
    }

    private fun judgeWinner(cars:List<Car>){
        var winner = mutableMapOf<String,Int>()
        for (car in cars){
            if (winner.isEmpty()){
                winner.put(car.name,car.getStatus())
            } else if (winner.values.max()<car.getStatus()){
                winner = mutableMapOf()
                winner.put(car.name,car.getStatus())
            } else if (winner.values.max() == car.getStatus()){
                winner.put(car.name,car.getStatus())
            }
        }
        Output().printWinner(winner)
    }
}
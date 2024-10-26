package racingcar.model

class Racing {
    fun readyToRace(carNames:List<String>):List<Car>{
        val cars = mutableListOf<Car>()
        for (name in carNames){
            cars.add(Car())
        }
        return cars
    }
}
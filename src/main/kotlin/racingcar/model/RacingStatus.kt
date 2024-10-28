package racingcar.model

import racingcar.dto.CarDto

class RacingStatus {
    fun getCurrentRacingStatus(cars: List<Car>): List<CarDto> {
        return cars.map { car -> CarDto(car.name, car.position) }
    }
}

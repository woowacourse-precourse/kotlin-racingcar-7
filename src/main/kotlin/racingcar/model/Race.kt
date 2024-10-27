package racingcar.model
//Random으로 정수 뽑는 함수, 각 시도마다 자동차를 이동시킴
import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val attempts: Int) {
    fun startRace(): List<List<Car>> {
        val raceResults = mutableListOf<List<Car>>()
        repeat(attempts) {
            cars.forEach { car ->
                val randomNumber = Randoms.pickNumberInRange(0, 9)
                car.move(randomNumber)
            }
            raceResults.add(cars.map { it.copy() }) // 현재 상태 저장
        }
        return raceResults
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}

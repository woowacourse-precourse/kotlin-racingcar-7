package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {

    fun startGame() {
        val carList = getCarList()
        val tryGame = getTryCount()
        val maxDistance = startRace(carList, tryGame)
        displayWinners(carList, maxDistance)
    }

    private fun createCars(): List<Car> {
        val carList = Driver().getValidDriver()
        return carList.map { Car(it) }
    }

    private fun displayInputCar() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    private fun getCarList(): List<Car> {
        displayInputCar()
        return createCars()
    }

    private fun displayTryCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    private fun validCarCount(): Int {
        return inputNum().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요")
    }

    private fun inputNum(): String {
        return Console.readLine()
    }

    private fun getTryCount(): Int {
        displayTryCount()
        return validCarCount()
    }

    private fun startRace(carList: List<Car>, tryCount: Int): Int {
        return CarFactory().displayCarRace(carList, tryCount)
    }

    private fun displayWinners(carList: List<Car>, maxDistance: Int) {
        val winners = findWinner(carList, maxDistance)
        println("최종 우승자 : $winners")
    }


    private fun findWinner(cars: List<Car>, maxDistance: Int): String {
        return cars.filter { it.distance == maxDistance }.joinToString(", ") { it.name }
    }
}
package racingcar.view

class OutputView {

    fun printCarMove(carName : String, movedDistance : Int) {
        println("$carName : ${"-".repeat(movedDistance)}")
    }
}
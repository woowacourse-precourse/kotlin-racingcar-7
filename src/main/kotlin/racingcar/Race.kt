package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Race(var carList: List<Car>,var stageNumber : Int) {

    fun runRace(){
        println("실행 결과")
        for(i in 0..<stageNumber){
            stage()
            printNow()
        }
        printFinal()
    }


    fun stage(){
        for(car in carList){
            runCar(car)
        }
    }

    fun runCar(car:Car){
        if(Randoms.pickNumberInRange(0,9)>=4){
            car.now++
        }
    }
    fun printNow(){
        for(car in carList){
            print(car.name+" : "+"-".repeat(car.now))
            println()
        }
        println()
    }
    fun printFinal(){

    }
}
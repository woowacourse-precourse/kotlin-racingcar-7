package racingcar
import camp.nextstep.edu.missionutils.*

fun main() {
    val check = CheckException()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = Console.readLine()
    check.firstInput(cars)

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine()
    check.secondInput(tryCount)

    val raceGame = RaceGame()
    val carMap = raceGame.splitCars(cars)
    raceGame.play(carMap, tryCount.toInt())

}

class RaceGame(){

    fun splitCars(cars : String) : MutableMap<String, Int>{
        val carMap : MutableMap<String,Int> = mutableMapOf()
        val carList = cars.split(",").map{it.trim()}
        carList.forEach{
            carMap[it]=0
        }
        return carMap
    }

    fun play(carMap : MutableMap<String, Int>, tryCount : Int){
        var gameScore = carMap

        println("실행 결과")
        for(i in 0 until tryCount){
            gameScore = goForward(gameScore)
            result(gameScore)
        }
        winner(gameScore)
    }
    fun goForward(carMap : MutableMap<String, Int>) : MutableMap<String,Int>{
        carMap.forEach{(name, score)->
            if(Randoms.pickNumberInRange(0,9)>=4){
                carMap[name]=score+1
            }
        }
        return carMap
    }

    fun result(gameScore : MutableMap<String, Int>){
        gameScore.forEach{
            println("${it.key} : ${"-".repeat(it.value)}")
        }
        println()
    }
    fun winner(gameScore: MutableMap<String, Int>){
        val check = CheckException()
        check.result(gameScore)

        val maxScore = gameScore.values.max()
        val winnerList : MutableList<String> = mutableListOf()
        gameScore.forEach{(name,score)->
            if(score == maxScore){
                winnerList.add(name)
            }
        }
        println("최종 우승자 : ${winnerList.joinToString(", ")}")
    }
}

class CheckException(){

    fun firstInput(car : String){
        if(car=="") {
            throw IllegalArgumentException()
        }
        val carList = car.split(",").map{it.trim()}
        if(carList.size != carList.distinct().size){
            throw IllegalArgumentException()
        }
        carList.forEach{
            if(it.isBlank() || it.length>5){
                throw IllegalArgumentException()
            }
        }
    }

    fun secondInput(count : String){
        val num = count.toIntOrNull()
        if(num==null || num <= 0 ) throw IllegalArgumentException()
    }

    fun result(scores : MutableMap<String,Int>){
        var check = 0
        for (score in scores){
            if(score.value!=0)
                check+=1
        }
        if(check==0) throw IllegalArgumentException()
    }
}
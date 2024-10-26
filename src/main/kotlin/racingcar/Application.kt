package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.StringTokenizer

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input:String =  Console.readLine()

    val carNameList: List<String> = makeCarNames(input)
    var carScore: MutableList<Int> = mutableListOf()
    var carString: MutableList<String> = mutableListOf()

    initListData(carNameList, carScore, carString)

    println("시도할 횟수는 몇 회인가요?")
    val totalCount:Int = makeInteger(Console.readLine())

    for(i in 1..totalCount){
        executeGame(carScore, carString)
        printScore(carNameList, carString)
    }

}




fun makeCarNames(input: String): List<String>{
    val arr: MutableList<String> = mutableListOf()
    val st = StringTokenizer(input, ",")

    while(st.hasMoreTokens()){
        val carName = st.nextToken()
        if (validateName(carName)){
            arr.add(carName)
        }
    }
    return arr
}

fun validateName(carName: String): Boolean{
    if (carName.length > 5){
        throw IllegalArgumentException()
    }
    return true
}

fun initListData(carNameList: List<String>, carScore: MutableList<Int>, carString: MutableList<String>){
    for(name in carNameList){
        carScore.add(0)
        carString.add("")
    }
}

fun makeInteger(totalCount: String): Int{
    try{
        return totalCount.toInt()
    }
    catch (e: NumberFormatException){
        throw IllegalArgumentException()
    }
}

fun executeGame(carScore: MutableList<Int>, carString: MutableList<String>){
    for(i in 0..<carScore.size){
        val rand = Randoms.pickNumberInRange(0, 9)
        if (rand >= 4){
            carScore[i] += 1
            carString[i] += "-"
        }
    }
}

fun printScore(carNameList: List<String>, carString: MutableList<String>) {
    for(i in 0..<carNameList.size){
        println(carNameList[i] + " : " + carString[i]);
    }
    println()
}



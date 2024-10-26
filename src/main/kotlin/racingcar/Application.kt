package racingcar

import camp.nextstep.edu.missionutils.Console
import java.util.StringTokenizer

fun main() {
    // TODO: 프로그램 구현
    val input:String =  Console.readLine()

    val carNameList: List<String> = makeCarNames(input)
    var carScore: MutableList<Int> = mutableListOf()
    var carString: MutableList<String> = mutableListOf()

    initListData(carNameList, carScore, carString)

    val totalCount:Int = makeInteger(Console.readLine())


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
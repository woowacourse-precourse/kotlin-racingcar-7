package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun carName(): String{
        println(InputViewString.CAR_NAME_GUIDE)
        val input = Console.readLine()
        require(input.isNotBlank()){ExceptionString.BLANK}
        return input
    }

    fun tryCount(): Int{
        println(InputViewString.RACING_TRY_GUIDE)
        val input = Console.readLine()
        require(input.toUIntOrNull() != null){ExceptionInt.NOT_UINT}
        return input.toInt()
    }
}
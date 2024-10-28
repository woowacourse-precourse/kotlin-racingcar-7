package racingcar

import camp.nextstep.edu.missionutils.Console

class MyReader {
    fun readLine(): String =
        runCatching {
            Console.readLine()
        }.getOrElse {
            throw IllegalArgumentException()
        }


    fun close() = Console.close()
}
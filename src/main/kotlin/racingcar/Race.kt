package racingcar

class Race(private val cars: List<Car>, private val times: Int) {

    fun start() {}

    fun end() {}

    fun examineName(input: String): List<Car> {
        return listOf<Car>()
    }

    fun examineTimes(input: String): Int {
        return 0
    }

    fun getWinner(): List<String> {
        return listOf<String>()
    }

    companion object {
        fun ready(): Race {
            return Race(listOf<Car>(), 0)
        }
    }
}
package racingcar

class Race(private val cars: List<Car>, private val times: Int) {
class Race(

) {
    private var cars: List<Car> = listOf()
    private var times: Int = 0

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
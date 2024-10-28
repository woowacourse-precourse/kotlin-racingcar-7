package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(
    private val cars: List<Car>, private val turns: Int
) {
    fun play(): Sequence<List<Result>> {
        return sequence {
            repeat(turns) {
                playOneTurn()
                yield(playOneTurn())
            }
        }
    }

    fun getWinners(): List<Car> {
        val winningScore = cars.maxOf { it.moves }
        return cars.filter { it.moves == winningScore }
    }

    private fun playOneTurn(): List<Result> {
        return cars.map { car ->
            if (canMoveForward()) car.moveForward()
            car.toResult()
        }
    }

    private fun Car.toResult() = Result(name, moves)

    private fun canMoveForward() =
        Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE) >= RANDOM_WINNING_CRITERIA

    data class Result(
        val carName: String,
        val moves: Int
    ) {
        override fun toString(): String {
            return carName + SEPARATOR + MOVE_MARK.repeat(moves)
        }

        companion object {
            private const val SEPARATOR = " : "
            private const val MOVE_MARK = "-"
        }
    }

    companion object {
        private const val RANDOM_START_INCLUSIVE = 0
        private const val RANDOM_END_INCLUSIVE = 9
        private const val RANDOM_WINNING_CRITERIA = 4
    }
}
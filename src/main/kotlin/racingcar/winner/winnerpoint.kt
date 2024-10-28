package racingcar.winner

fun maxpointfind(carscore: Array<Int>): Int {
    var scoremax = 0
    for (maxval in carscore) {
        if (maxval > scoremax) {
            scoremax = maxval
        }
    }
    return scoremax
}
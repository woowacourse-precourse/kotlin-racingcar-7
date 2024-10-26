package racingcar

var carNames:List<String> = mutableListOf<String>()
var moveCounts:MutableList<Int> = mutableListOf<Int>()
var tryCounts:Int? = 0


fun argumentChecker(carName:String) {
	if (carNames.size < 2) {
		throw IllegalArgumentException("2개 이상의 자동차를 입력해주세요")
	}
	if (carName.trimIndent().length == 0) {
		throw IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다")
	}
	if (carName.length > 5) {
		throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요")
	}
}

fun getCarNames():List<String> {
	println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
	carNames = camp.nextstep.edu.missionutils.Console.readLine().split(',')

	for (carName in carNames) {
		argumentChecker(carName)
		moveCounts.add(0)
	}

	return carNames
}

fun getTryCounts():Int? {
	try {
		println("시도할 횟수는 몇 회인가요?")
		tryCounts = camp.nextstep.edu.missionutils.Console.readLine().toInt()
	} catch (exception:NumberFormatException) {
		throw IllegalArgumentException("숫자를 입력해주세요")
	}

	return tryCounts

}

fun move(idx:Int) {
	//전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
	var randNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)

	if (randNum >= 4) {
		moveCounts[idx] += 1
	}
}


fun main() {
	// TODO: 프로그램 구현
	getCarNames()
	getTryCounts()

	for (idx in 0 until moveCounts.size) {
		move(idx)
	}
}

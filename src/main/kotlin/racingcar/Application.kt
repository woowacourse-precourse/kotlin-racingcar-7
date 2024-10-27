package racingcar

import kotlin.math.max

var carNames:List<String> = mutableListOf<String>()
var moveCounts:MutableList<Int> = mutableListOf<Int>()
var tryCounts:Int = 0


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

fun getCarNames() {
	println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
	carNames = camp.nextstep.edu.missionutils.Console.readLine().split(',')

	for (carName in carNames) {
		argumentChecker(carName)
		moveCounts.add(0)
	}
}

fun getTryCounts() {
	try {
		println("시도할 횟수는 몇 회인가요?")
		tryCounts = camp.nextstep.edu.missionutils.Console.readLine().toInt()
	} catch (exception:NumberFormatException) {
		throw IllegalArgumentException("숫자를 입력해주세요")
	}
}


fun move(idx:Int, carName:String) {
	var randNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)

	if (randNum >= 4) {
		moveCounts[idx] += 1
	}

	print("$carName : ")

	for (i in 0 until moveCounts[idx]) {
		print("-")

	}
	print("\n")
}

fun display() {
	for ((idx, carName) in carNames.withIndex()) {
		move(idx, carName)
	}
	print("\n")

}

fun defineWinner():MutableList<String> {
	var winnerIndexList:List<Int> = mutableListOf()
	var maxCount = moveCounts.max()

	winnerIndexList = moveCounts.withIndex().filter { (_, count) -> count == maxCount }.map { it.index }


	val winnerList:MutableList<String> = mutableListOf()
	for (idx in winnerIndexList) {
		winnerList.add(carNames[idx])
	}

	return winnerList
}


fun main() {
	// TODO: 프로그램 구현
	getCarNames()
	getTryCounts()

	for (i in 0 until tryCounts) {
		display()
		print("\n")
	}

	val winners = defineWinner().joinToString(",")
	print("최종 우승자 : $winners\n")
}

package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
  println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
  val input = Console.readLine()
  
  println("시도할 횟수는 몇 회인가요?")
  val count = Console.readLine()
  
  val carNames = getCarNames(input)
  val moveCount = getMoveCount(count)
}

fun getCarNames(input: String): List<String> {
  val carNames = input.split(",").map { name ->
    name.trim()
  } // 이름을 쉼표로 구분하고, 양쪽 공백 제거
  
  return carNames
}

fun getMoveCount(count: String): Int {
  val moveCount = count.toInt()

  return moveCount
}

fun raceCars(carNames: List<String>, moveCount: Int) {
  val racingResults = mutableMapOf<String, Int>()
  
  // 초기값 설정
  carNames.forEach { name ->
    racingResults[name] = 0
  }
  
  // 전진 횟수마다 결과를 출력
  repeat(moveCount) {
    for (carName in carNames) {
      val randomValue = Randoms.pickNumberInRange(0, 9)
      
      if (randomValue >= 4 && racingResults[carName] != null) {
        racingResults[carName] = racingResults[carName]!! + 1 // 무작위 값이 4 이상일 때 앞으로 전진
      }
    }
    
    printRacingResults(racingResults) // 이동 결과 출력
  }
  
  // 최종 우승자 출력
  printFinalWinner(racingResults)
}

fun printRacingResults(racingResults: Map<String, Int>) {
  racingResults.forEach { (name, distance) ->
    println("$name : ${"-".repeat(distance)}")
  }
  
  println()
}

fun printFinalWinner(racingResults: Map<String, Int>) {
  val maxDistance = racingResults.values.maxOrNull() ?: 0 // 가장 많이 전진한 거리
  val winners = racingResults.filter { racingResult ->
    racingResult.value == maxDistance
  }.keys // 가장 많이 전진한 사람을 우승자로
  
  println("최종 우승자 : ${winners.joinToString(", ")}") // 최종 우승자 출력
}

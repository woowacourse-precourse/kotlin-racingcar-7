package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
  // TODO: 프로그램 구현

  /*
  1. 입력(자동차 이름)
  2. 타당한 입력인지 확인(이름이 5자 초과인가?)
  3. 참가 자동차 분류(중복되는 이름은 뒤에 번호를 붙여줘야함)
  4. 입력(n)
  5. 타당한 입력인지 확인(자연수인가?, NaN인가?)
  ※. 2,5 에서 타당한 입력을 확인 후 타당하지 않다면 IlleagalArgumentException을 뱉고 종료
  6. 경주 시작
  6-1. 참가자별 랜덤값 추출
  6-2. 4이상의 값인 경우 1칸 전진
  6-3. 현 상황 출력
  6-4. 6-1~3은 4에서 입력받은 n회 반복
  7. 경주 결과 출력(1등이 겹친다면 여러명 출력)
   */

  println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
  val inputCar = Console.readLine()
  var cars = inputCar.split(",")
  isOver5Letters(cars)
  cars = duplicateName(cars)
  println("시도할 횟수는 몇 회인가요?")
  val inputMove = Console.readLine()
  val move = isMovementValid(inputMove)
  race(cars, move)
}

fun isOver5Letters(cars: List<String>) {
  val carIter = cars.listIterator()
  carIter.forEach {
    if (5 < it.length) {
      throw IllegalArgumentException("이름이 5자를 넘습니다")
    }
  }
}

fun duplicateName(cars: List<String>): List<String> {
  val carAndNumber = mutableMapOf<String, Int>()
  val result = mutableListOf<String>()

  for (car in cars) {
    if (carAndNumber.containsKey(car)) {
      val carNumber = carAndNumber[car]!! + 1
      carAndNumber[car] = carNumber
      result.add("$car ${carNumber}호기")
    } else {
      carAndNumber[car] = 1
      result.add(car)
    }
  }
  return result
}

fun isMovementValid(inputMove: String): UInt {
  try {
    val move = inputMove.toUInt()
    return move
  } catch (e: Exception) {
    throw IllegalArgumentException("부적절한 이동 횟수 입니다")
  }
}

fun race(cars: List<String>, move: UInt) {
  val m = mutableMapOf<String, UInt>()
  for (car in cars) {
    m[car] = 0u
  }

  var turn = 1u
  while (turn <= move) {
    turnAction(cars, m)
    turnDisplay(cars, m, turn)
    turn++
  }

  winnerDisplay(m)
}

fun turnAction(cars: List<String>, m: MutableMap<String, UInt>) {
  for (car in cars) {
    if (4 <= Randoms.pickNumberInRange(0, 9)) {
      m[car] = m[car]!!.plus(1u)
    }
  }
}

fun turnDisplay(cars: List<String>, m: MutableMap<String, UInt>, turn : UInt) {
  if(turn == 1u){
    println("실행 결과")
  }
  for (car in cars) {
    print("$car : ")
    for(move in 1..m[car]!!.toInt()){
      print("-")
    }
    println()
  }
  println()
}

fun winnerDisplay(m : MutableMap<String, UInt>){
  val maxMove = m.maxBy { it.value }.value
  val winners = m.filterValues { it == maxMove }.keys
  println("최종 우승자 : ${winners.joinToString()}")
}
# kotlin-racingcar-precourse

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 입출력 요구 사항

- 입력 : 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분), 시도할 횟수
- 출력 : 차수별 실행 결과, 우승자 안내 문구

## 구현할 기능 목록

- [x] 입력 기능
- [x] 차수별 랜덤 시행
- [x] 차수별 실행 결과 출력
- [x] 우승자 안내 문구 출력
- [x] 예외 처리

## 문제 해결 과정

### 입력 기능

#### input 

```kotlin
fun input(): Pair<List<String>, Int> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val cars = readLine()!!.trim().split(",")
    println("시도할 횟수는 몇 회인가요?")
    val n = readln().toInt()
    return Pair(cars, n)
}
```
- 경주할 자동차 이름, 시도할 횟수를 `readline()`, `readln()`을 통해 입력 받음
- `cars`, `n` 을 `Pair`로 한번에 묶어서 리턴

#### main

```kotlin
val (cars, n) = input()
```
- 메인 함수에서 `input()` 함수를 실행하여 입력을 받아 경주할 자동차 이름, 시도할 횟수를 `cars`, `n`에 저장

### 차수별 랜덤 시행

#### race

```kotlin
fun race(cars: List<String>, n: Int): Array<Int> {
    val carsProgressCount = Array(cars.size){0}
    repeat(n){
        for(i in carsProgressCount.indices){
            carsProgressCount[i] += randomPick()
        }
        outputProgress(cars,carsProgressCount)
    }
    return carsProgressCount
}
```

- 차들의 전진 횟수를 저장 할 `carsProgressCount` 배열 선언
- 시행 횟수인 `n` 번 만큼 각 차들에 대해 `randomPick()` 을 진행한 후 `carsProgressCount` 배열에 전진 여부를 저장
- 각 차수별로 `outputProgress()` 함수를 통해 진행 상황을 출력
- 경기가 완료된 후에는 최종적인 진행 상황을 담은 `carsProgressCount` 배열을 리턴

#### randomPick

```kotlin
fun randomPick(): Int {
    val n = Randoms.pickNumberInRange(0, 9)
    return if (n >= 4) 1
    else 0
}
```

- 0~9 사이의 숫자중 하나를 랜덤으로 선택해 `n`에 저장
- `n`이 4이상이라면 전진햇음으로 1, 그외에는 전진하지 않았음으로 0을 리턴

### 차수별 실행 결과 출력

#### outputProgress

```kotlin
fun outputProgress(cars: List<String>, carsProgressCount: Array<Int>) {
    println("\n실행 결과")
    for(i in cars.indices){
        print("${cars[i]} : ")
        repeat(carsProgressCount[i]){
            print("-")
        }
        println()
    }
}
```
- 출력 형식에 맞게 각 차들의 이름이 담긴 리스트인 `cars` 와 각 차들의 진행 상황이 담긴 배열인 `carsProgressCount`를 출력

### 우승자 안내 문구 출력

#### main

```kotlin
    val winner = pickWinner(cars, carsProgressCount)
    outputWinner(winner)
```
- `pickWinner` 함수를 통해 우승자를 구한 후 `winner` 변수에 저장
- 저장된 우승자를 `outputWinner` 함수를 통해 출력

#### pickWinner

```kotlin
fun pickWinner(cars: List<String>, carsProgressCount: Array<Int>): String {
    val winner = mutableListOf<String>()
    var max = 0
    for(i in carsProgressCount.indices){
        if(max < carsProgressCount[i]){
            winner.clear()
            winner.add(cars[i])
            max = carsProgressCount[i]
        }else if(max == carsProgressCount[i]){
            winner.add(cars[i])
        }
    }
    return winner.joinToString(", ")
}
```

- 최종 진행 상황인 `carsProgressCount` 배열을 통해 가장 많이 전진한 차를 구함
- 가장 많이 전진한 차는 `winner` 리스트에 저장
- 저장된 `winner` 리스트를 `joinToString` 함수를 통해 스트링으로 변환후 리턴

#### outputWinner

```kotlin
fun outputWinner(winner: String) {
    println("\n최종 우승자 : $winner")
}
```

- 출력 형식에 맞게 우승차를 출력

### 예외 처리

#### 차의 이름 예외처리

```kotlin
    val cars = readLine()!!.trim().split(",")
    checkCarsName(cars)
```
- `input` 함수에서 입력을 받은후 차의 이름을 확인하는 `checkCarsName` 함수를 실행

```kotlin
fun checkCarsName(cars: List<String>) {
    if (cars.size<2) throw IllegalArgumentException("잘못된 입력입니다.")
    cars.forEach {
        if(it.length>5) throw IllegalArgumentException("잘못된 입력입니다.")
        if(it.isBlank()) throw IllegalArgumentException("잘못된 입력입니다.")
    }
    val count = cars.size
    if(cars.toSet().size != count) throw IllegalArgumentException("잘못된 입력입니다.")
}
```
- 입력된 차의 이름의 개수가 2개 미만인 경우 `IllegalArgumentException` 을 발생시킨 후 종료
- 각 차의 이름의 글자 수가 5글자를 넘는 경우 `IllegalArgumentException` 을 발생시킨 후 종료
- 차의 이름에 빈 문자가 온 경우 `IllegalArgumentException` 을 발생시킨 후 종료
- 동일한 차의 이름이 들어온 경우 `IllegalArgumentException` 을 발생시킨 후 종료

#### 입력된 시행 횟수 예외 처리

```kotlin
    val n = try {
        readln().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
    checkPositiveInteger(n)
```

- `input` 함수에서 입력을 받을때 받은 시행 횟수가 숫자가 아닌 경우 `IllegalArgumentException` 을 발생시킨 후 종료
- 이후 숫자인 것이 판별 되면 양수인지 체크하기 위해 `checkPositiveInteger` 함수를 실행

```kotlin
fun checkPositiveInteger(n: Int) {
    if(n<=0) throw IllegalArgumentException("잘못된 입력입니다.")
}
```

- 숫자 `n`이 양수가 아닌 경우 `IllegalArgumentException` 을 발생시킨 후 종료
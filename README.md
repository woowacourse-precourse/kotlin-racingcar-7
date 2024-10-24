# kotlin-racingcar-precourse

초간단 자동차 경주 게임을 구현한다.

# 구현 기능 목록

- 몇 번 이동할 것인지 횟수 입력 기능
- 자동차의 이름 입력 기능
    - 쉼표(`,`) 기준으로 한 번에 n 대의 이름 입력 받기
      - 해당 기능에서 자동차 갯수 확인
    - 각각의 이름은 5자 이하
- 자동차의 전진 기능
  - 전진 조건은 0~9 사이 무작위 값이 4 이상일 경우
- 각 실행 결과 출력 기능
- 우승자 출력 기능 
  - 우승자는 한 명 이상일 수 있음
  - 쉼표(`,`)로 우승자 여러 명 출력
- 잘못된 입력값에 대해 IllegalArgumentException 발생 기능

# 프로그래밍 요구사항

- **`indent depth` 2 이하로 구현할 것**
- 함수는 한 가지 일만 담당하게끔 구현
- 위의 기능 목록에 대해 각각을 테스트할 것
- 외부 라이브러리 사용 불가
- `Kotlin Style Guide` 원칙

# 라이브러리
- `camp.nextstep.edu.missionutils`
  - `Randoms.pickNumberInRange()`
  - `Console.readLine()`

---

# 슈도 코드 작성

```kotlin
val carMap: Map<String, Int>
val attemptNumber: Int

for (attemptNumber) {
  randomDice(carMap)
  printRaceResult(carMap)  // carMap의 Int 이용
}

val winner = getWinner(carMap)  // carMap의 Int 이용 최댓값 추출
printWinner(winner)  
```

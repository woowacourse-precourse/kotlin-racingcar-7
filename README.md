# kotlin-racingcar-precourse

## CarRacingGame 기능 목록

1. **자동차 이름 입력 (getCarNames)** :
   - `Console.readLine()`을 사용하여 사용자로부터 자동차 이름을 입력받음
   - 쉼표(,)로 구분하여 여러 자동차의 이름을 입력받음
   - 자동차 이름은 영어 소문자 5자 이하로 제한하며, 공백을 포함하는 것과 이름 중복을 허용하지 않음
   - 잘못 입력될 경우, `IllegalArgumentException`을 발생시킴

2. **시도 횟수 입력 (getAttemptCount)** :
   - `Console.readLine()`을 사용하여 시도 횟수를 입력받음
   - 시도 횟수는 숫자여야 하며, 0보다 크고 정수 최대값(Int.MAX_VALUE)보다 작아야 함
   - 잘못 입력될 경우, `IllegalArgumentException`을 발생시킴

3. **자동차 객체 생성 (Car 클래스)** :
   - 필드 : `name` (자동차 이름), `distance` (이동 거리)
   - 메서드 :
      - `moveForwardIfPossible` : 전진 조건에 따라 이동 거리를 증가
      - `shouldMove` : 0에서 9 사이의 무작위 값을 생성하고, 4 이상일 경우 true를 반환하여 전진 여부를 결정

4. **전진 여부 결정 (shouldMove)** :
   - `Randoms.pickNumberInRange(0, 9)`를 사용하여 0에서 9 사이의 무작위 값을 생성
   - 무작위 값이 4 이상일 경우, `moveForwardIfPossible` 메서드에서 전진

5. **레이스 한 차례 실행 (raceRound)** :
   - `raceRound` 메서드는 `cars` 리스트에 포함된 각 자동차 객체에 대해 `moveForwardIfPossible` 메서드를 호출하여 한 번의 레이스를 실행

6. **차수별 결과 출력 (printRaceStatus)** :
   - 입력된 시도 횟수만큼 게임을 진행
   - 각 차수마다 자동차의 이름과 전진 상태를 출력 (예: `pobi : --`)

7. **최종 우승자 출력 (printWinners)** :
   - 게임이 종료된 후 각 자동차의 최종 이동 거리를 비교하여 가장 멀리 이동한 자동차를 우승자로 선정
   - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력

8. **전체 레이스 실행 (startRace)** :
   - `startRace` 메서드는 `getCarNames`와 `getAttemptCount`로 자동차 이름과 시도 횟수를 받아 레이스 시작
   - 시도 횟수(`attemptCount`)만큼 `raceRound`를 반복 실행하고, 각 라운드 후 `printRaceStatus` 호출
   - 레이스가 종료된 후 `printWinners` 메서드로 최종 우승자 출력
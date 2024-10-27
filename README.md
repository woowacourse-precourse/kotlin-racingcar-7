# kotlin-racingcar-precourse

## CarRacingGame 기능 목록

1. **자동차 이름 입력 (getCarNames)** :
    - `Console.readLine()`을 사용하여 사용자로부터 자동차 이름을 입력받음
    - 쉼표(,)로 구분하여 여러 자동차의 이름을 입력받음
    - 자동차 이름은 5자 이하로 제한하며, 공백을 허용하지 않음
    - 잘못된 이름(5자를 초과하거나 공백인 경우)이 입력될 경우, `IllegalArgumentException`을 발생시킴

2. **시도 횟수 입력 (getAttemptCount)** :
    - `Console.readLine()`을 사용하여 시도 횟수를 입력받음
    - 숫자 타입이 아니거나 0 이하인 경우, `IllegalArgumentException`을 발생시킴

3. **자동차 객체 생성 (Car 클래스)** :
    - 필드 : `name` (자동차 이름), `distance` (이동 거리)
    - 메서드 :
        - `moveForwardIfPossible` : 전진 조건에 따라 이동 거리를 증가
        - `shouldMove` : 0에서 9 사이의 무작위 값을 생성하고, 4 이상일 경우 true를 반환하여 전진 여부를 결정

4. **전진 여부 결정 (shouldMove)** :
    - `Randoms.pickNumberInRange(0, 9)`를 사용하여 0에서 9 사이의 무작위 값을 생성
    - 무작위 값이 4 이상일 경우, `moveForwardIfPossible` 메서드에서 전진

5. **차수별 결과 출력 (printRaceStatus)** :
    - 입력된 시도 횟수만큼 게임을 진행
    - 각 차수마다 자동차의 이름과 전진 상태를 출력 (예: `pobi : --`)

6. **최종 우승자 출력 (printWinners)** :
    - 게임이 종료된 후 각 자동차의 최종 이동 거리를 비교하여 가장 멀리 이동한 자동차를 우승자로 선정
    - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력
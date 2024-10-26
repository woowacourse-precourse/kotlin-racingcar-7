# kotlin-racingcar-precourse

## 기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

pobi,woni,jun

시도할 횟수

5

출력

차수별 실행 결과

pobi : --

woni : ----

jun : ---

단독 우승자 안내 문구

최종 우승자 : pobi

공동 우승자 안내 문구

최종 우승자 : pobi, jun

### 실행 결과 예시
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

pobi,woni,jun

시도할 횟수는 몇 회인가요?

5

### 실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun

---

> 자동차 경주 결과 모두 출발지에 머물러 있을 때, 우승자는 없다.

---

## 구성 요소

### Car
- 자동차의 이름과 위치를 가지고 있는 객체
- 이름은 5자 이하만 가능하다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 위치를 반환하는 기능을 가진다.
- 자동차의 이름을 반환하는 기능을 가진다.

### RacingGame
- 자동차 경주 게임을 진행하는 객체
- 입력받은 횟수만큼 게임을 진행한다. 
- 게임을 진행한 후 우승자를 반환하는 기능을 가진다.

### RacingGameController
- RacingGame 객체를 생성하고 실행하는 객체
- 사용자로부터 자동차 이름과 시도할 횟수를 입력받는다. 

### RacingCars
- 자동차들을 가지고 있는 객체
- 우승 자동차 이름 리스트 반환 기능을 가진다.
- 자동차 이름을 입력받아 자동차 객체 리스트를 생성하는 기능을 가진다.
- 자동차 객체 리스트로 자동차 이동 기능을 실행하는 기능을 가진다.

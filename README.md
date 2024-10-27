# 우테코 프리코스 2주차 - 자동차 경주

**초간단 자동차 경주 게임**을 구현

<br/>

## ⚙️ 기능 목록 정리

- **입출력 기능**
  - **입력**
    - [x] 자동차 `이름`들을 입력 받고 `쉼표(,)`를 기준으로 구분한다.
    - [x] 사용자는 `몇 번의 이동`을 할 것인지를 `입력`할 수 있어야 한다.
  - **출력** (실행 결과와 우승자 이름 출력은 기능 속에 포함)
    - [x] 게임 시작전 출력할 문구 (이름 입력, 시도할 횟수 입력받는 부분)

<br/>

- **자동차 속성**
  - [x] 자동차라는 객체가 필요하고 자동차는 이름이라는 속성을 가지고 있다.
  - [x] 이름이라는 속성은 5자 이하만 가능하다.

<br/>

- **자동차 행위 (`주어진 횟수` 동안 `n대의 자동차`는 `전진` 또는 `멈출` 수 있다.)**
  - [x] 자동차는 전진, 멈춤 이라는 행위를 가지고 있다.
  - [x] 주어진 횟수 동안 행위들을 수행한다.

<br/>

- **전진 행위**
  - [x] 전진하는 조건은 `0에서 9 사이`에서 `무작위 값`을 구한 후 무작위 값이 `4 이상`일 경우이다.
  - [x] 전진하는 자동차를 출력할 때 `자동차 이름을 같이 출력`한다.
- **멈춤 행위**
  - [ ] ?

<br/>

- **자동차 경주 게임 (자동차 경주 게임을 시작하고 종료가 되면 우승자를 출력한다.)**
  - [x] 자동차 경주 게임 시작
  - [x] 우승자를 출력한다. 우승자는 여러 명일 수 있다.
  - [x] 우승자가 `여러 명일 경우` `쉼표(,)`를 이용하여 구분한다.

<br/>

- **예외처리**
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션은 종료되어야 한다.
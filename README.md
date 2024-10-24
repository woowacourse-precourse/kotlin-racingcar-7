# kotlin-racingcar-precourse

## 기능 목록

### 1. Domain : 비지니스 로직
- [X] 자동차 객체 관리
  - 이름
  - 주행 거리
  - 랜덤 숫자가 4이상이면 자동차를 전진시킨다.
- [ ] 게임 결과 객체 관리
  - 우승자

### 2. Usecase : 애플리케이션의 동작을 수행하는 절차나 흐름
- [ ] 자동차 게임 진행 로직
  - 이동 횟수만큼 자동차 게임 진행
- [ ] 우승자 판별 로직

### 3. Interface : 외부의 통신과 입출력 담당하는 계층
- [ ] 사용자의 입력
  - 사용자로부터 자동차 이름을 입력받는다.
  - 자동차 이름의 유효성을 검사한다. 아래의 경우 IllegalArgumentException을 발생
    - 5자 초과하는 문자열이 들어왔을 경우
    - 공백이 들어왔을 경우
    - 이름에 쉼표가 들어가는 경우
    - 동일한 이름을 넣는 경우
    - 빈 문자로 이루어진 경우
  - 자동차 이름을 쉼표(,)를 기준으로 분리한다.
  - 사용자로부터 이동 횟수를 입력받는다.
  - 이동횟수의 유효성을 검사한다. 아래의 경우 IllegalArgumentException을 발생
    - 숫자가 아닌 경우
    - 0이거나 음수인 경우
    - 소수인 경우

### 4. Infrastructure 
- [ ] 랜덤 숫자 뽑는 로직
  - 0에서 9 사이의 랜덤 숫자를 뽑는다.
- [ ] console input(UI)
  - 사용자에게 자동차 이름 입력을 안내하는 메시지를 출력한다.
  - 사용자에게 이동 횟수 입력을 안내하는 메시지를 출력한다.
- [ ] console output(UI)
  - 매 라운드가 끝날 때마다 각 자동차의 전진한 결과를 출력한다.
    - 자동차가 전진한 경우, 이동 결과를 "-"로 표시한다.
  - 최종 우승자를 출력하고 애플리케이션을 종료한다.
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
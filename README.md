### 사용자 입력

- 프로그램 실행 시 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 문구를 출력한다.
- 쉼표로 구분된 자동차 이름을 입력받는다.

### 시도할 횟수 입력

- "시도할 횟수는 몇 회인가요?" 문구를 출력한다.
- 경주 시도할 횟수를 입력받는다.

### 차수별 실행 결과 출력

- 차수별로 각 자동차의 이름과 전진 상황을 "-"로 출력한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

### 우승자 안내 문구 출력

- "최종 우승자" 문구와 함께 우승자 이름을 출력한다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분해 출력한다.

### 예외 케이스 처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
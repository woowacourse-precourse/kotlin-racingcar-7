# kotlin-racingcar-precourse

## TDD 로 프로젝트를 진행해봅니다.

### feature 1: 문자열에 , 를 기준으로 구분하며 이름은 5자 이하만 가능하다.
1-1 "pobi"을 입력했을 경우 ["pobi"]을 반환한다.

1-2 "pobi,woni"을 입력했을 경우 ["pobi","woni"]를 반환한다.

1-3 "pobi,woni,jun"을 입력했을 경우 ["pobi","woni","jun"]를 반환한다.

### feature 2: 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
2-1 구한 값이 4 이면 전진한다.

2-2 구한 값이 9 이면 전진한다.

2-3 구한 값이 3 이면 멈춰있는다.

2-4 구한 값이 0 이면 멈춰있는다.

### feature 3: 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
3-1 입력 전 문구를 표시한다.

3-2 사용자로부터 입력 받는다.

3-3 1을 입력하면 1번만 이동한다.

3-4 5를 입력하면 5번 이동한다.

### feature 4: 형식에 맞춰서 출력한다.
4-1 이동할 때마다 현재 상황을 출력한다.

4-2 우승자를 출력한다.

### feature 5: 잘못된 값이 입력된 경우 IllegalArgumentException 발생
5-1 자동차 이름에 "pobi,javaji"을 입력했을 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

5-2 자동차 이름에 "123456,b,c"을 입력했을 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

5-3 자동차 이름에 "pobi,dominic"을 입력했을 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

5-4 반복 횟수에 "a"을 입력했을 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.

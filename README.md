# kotlin-racingcar-precourse
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
   1) 자동차 이름을 입력받는 기능

3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
   1) 사용자가 쉼표(,) 이외의 구분자를 사용하면 오류 발생
   2) 이름이 6자 이상 되면 오류 발생

4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
   1) 이동횟수를 입력받는 기능

5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
   1) 자동차의 전진여부를 결정하는 기능

6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
   1) 각각의 자동차가 전진한 횟수를 비교하는 기능
   2) 우승자를 출력하는 기능

7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
   1) 우승한 자동차의 이름을 구분하는 기능

8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 출력예시
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
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

# 라이브러리 조건
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
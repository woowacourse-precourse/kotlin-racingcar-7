# [우테코 프리코스] 자동차 경주

## 🚀 미션 설명
- 자동차 이름 목록과 경주 횟수를 입력받고, 랜덤 값에 의해 결정된 경기 결과와 최종 우승자를 출력하는 간단한 경주 게임 
 
## ✒️ 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
 
## 🖨️ 입출력 요구 사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```
- 시도할 횟수
```
5
```
### 출력
- 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```
### 실행 결과 예시
```
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
```
 
## 🧷 추가로 정의한 사항
- 자동차 경주 게임은 최소 1명 이상이 참가한다.
- 자동차 이름은 최소 1자 이상 5자 이하이며 서로 중복이 불가능하다.
- 시도할 횟수 입력은 8자리 이하의 양의 정수로 제한한다.
- 자동차의 이름에 공백은 문자 사이만 허용한다.
    -  "wo ni", "a car"와 같이 문자 사이의 공백은 허용된다
    -  " woni", "pobi ", " "와 같이 입력의 앞 뒤 공백 혹은 공백만 입력시 예외로 처리한다.
- 자동차 이름의 길이는 UTF-16 BE 코드 유닛의 수를 기준으로 계산한다.
    - "👀", "👨‍👩‍👧", "n̥", "بِ" 등의 이모지나 결합 문자는 2 이상의 길이를 가질 수 있다.
- 최종 우승자가 여러명인 경우 출력은 입력 순서대로 출력한다.

## 🛠️ 구현할 기능 목록

1. 자동차 이름 문자열과 시도할 횟수를 입력 받아 초기화
    - 각 입력을 받기 전 입력 안내 문구를 출력한다.
    - 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용해 받는다.
    - 자동차 정보는 Data class인 Car 객체에 저장한다.
        - 자동차 이름은 ‘,’로 분할하여 name에 저장한다.
        - 이동한 거리는 distance에 저장되며 객체 생성시 0으로 초기화 한다.
    - 경주 시도 횟수를 정수형으로 입력 받는다.
2. 경주를 1회 진행한 뒤 결과를 출력하는 메소드 작성
    - Random 값은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 추출한다.
    - Car타입의 리스트인 cars을 1회 순회하며 아래의 작업을 수행한다.
        - 0에서 9까지의 정수 Random 값을 추출한다
        - 값이 4 이상일 경우 distance를 1 증가한다.
        - name과 콜론을 출력하고 ‘-’를 distance번 출력한다.
3. 경주 시도 횟수만큼 경주를 반복하여 출력
    - 경기 시작 전 “실행 결과”를 출력한다.
    - 2번에서 작성한 메소드를 경주 시도 횟수만큼 실행한다.
        - 매 실행마다 빈 라인을 출력한다.
4. 최종 우승자를 출력
    - cars리스트에 저장된 car객체들의 distance중 최대값을 구한다.
    - 최대값의 distance 가지는 객체의 name목록을 List로 저장한다.
    - "최종 우승자 : " 와 ", "로 join한 List값들을 출력한다.
5. 잘못된 입력에 대한 예외 처리
    - `IllegalArgumentException`을 발생시키고 애플리케이션 종료하기
    - 에외 검사목록
        - 최소 1명 이상이 참가하는가?
        - 쉼표로 분할된 각 자동차 이름은 1자 이상 5자 이하인가?
        - 자동차 이름에 중복이 존재하는가?
        - 시도한 횟수는 양의 정수이며 8자리 이하인가?
 
## 📝 테스트
- RacingGameUnitTest에서 구현 내용에 관한 단위 테스트를 수행한다
    - 실패하는 테스트를 작성 후 코드를 구현하여 테스트를 통과한다.
    - private 메소드를 직접 테스트하지 않는다 (https://shoulditestprivatemethods.com)
- RacingGameNormalTest에서 전체 로직에 대한 테스트를 수행한다.
- RacingGameExceptionTest에서 예외 케이스 검증 테스트 코드를 수행한다.
 
## ⚙️ 프로젝트 요구사항
- Kotlin 1.9.24에서 실행 가능해야 한다.
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Kotlin Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/kotlin)를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
## 📕 라이브러리
- [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils/tree/main/src/main/java/camp/nextstep/edu/missionutils)에서 제공하는 API를 사용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
      - ex) 0에서 9 사이의 정수 중 한개 반환 : `Randoms.pickNumberInRange(0, 9)`
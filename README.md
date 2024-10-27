# kotlin-racingcar-precourse

## 학습 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백을 최대한 반영한다.

## 과제 진행 요구 사항

- [X] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- [X] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [X] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.

## 기능 목록

- [X] 테스트 코드 작성
- [X] 요구사항 정리
- [X] 구현할 클래스 정의
- [ ] Race
    - [X] field 정의
    - [X] ready
    - [ ] start
    - [ ] end
- [ ] Car
    - [ ] field 정의
    - [ ] move
    - [ ] printResult
- [ ] 리펙토링

## 추가 정보

- 이름 정보 : 5자 이내의 문자(null, 공백만 있는 경우, 6자 이상인 경우 오류)
- 반복할 횟수 : 자연수(null, 숫자가 아닌 문자가 포함된 경우, 자연수가 아닌 경우 오류)
- 경주 결과 : 공동 우승자가 있는 경우 생각해 봐야 함
- Race : 경주
    - ready() - 이름정보 받기(examineName), 횟수 정보 받기(examineTimes)
    - start() - 지정된 횟수만큼 이동, 각 횟수 마다 결과 출력하기
    - end() - 결과 출력하기, 결과 계산하기(calculateWinner)
- Car
    - move() : 1회 이동하기
    - printResult() : 현재 상태 출력하기

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 요구 사항 1

- Kotlin 1.9.24에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Kotlin Style Guide를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

## 1주차 피드백

### 공통

- 요구 사항을 정확하게 준수한다.
- 기본적인 Git 명령어를 숙지한다.
- Git으로 관리할 자원을 고려한다.
- 커밋 메시지를 의미 있게 작성한다.
- 커밋 메시지에 이슈 혹은 풀 리퀘스트 번호를 포함하지 않는다.
- 풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다.
- 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
- 이름을 통해 의도를 드러낸다.
- 축약하지 않는다.
- 공백도 코딩 컨벤션이다.
- 공백 라인을 의미있게 사용한다.
- 스페이스와 탭을 혼용하지 않는다.
- 의미없는 주석을 달지 않는다.
- 코드 포매팅을 사용한다.

### Android

- Kotlin에서 제공하는 API를 적극 활용한다
- 배열 대신 컬렉션을 사용한다.
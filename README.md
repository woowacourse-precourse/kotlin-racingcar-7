# kotlin-racingcar-precourse
# ✅ 구현할 기능 목록

---
### 자동차 이름 입력
+ 사용자가 쉼표로 구분된 자동차 이름을 입력
+ 이름은 최대 5까지 입력 가능
+ 유효하지 않은 입력 시 예외 발생
### 시도 횟수 입력
+ 사용자가 경주 시도 횟수를 입력
+ 유효하지 않은 입력 시 예외 발생
### 자동차 이동
+ camp.nextstep.edu.missionutils.Randoms을 사용 (0~9사이 랜덤값 생성)
+ 랜덤값이 4 이상일 경우 자동차 전진
### 자동차 상태 출력
+ 각 시도 마다 "-"로 얼마나 전진 하였는지 표현
### 우승자 선정
+ 게임이 종료된 후, 가장 많이 전진한 자동차를 우승자로 선정
+ 최대 이동거리가 동일한 경우 공동 우승자로 선정

---

## 🚀과제 진행 요구 사항
+ 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
+ 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
+ Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
+ AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
+ 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

---

## 🎯프로그래밍 요구 사항
+ Kotlin 1.9.24에서 실행 가능해야 한다.
+ Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
+ 프로그램 실행의 시작점은 Application의 main()이다.
+ build.gradle.kts 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
+ 프로그램 종료 시 System.exit() 또는 exitProcess()를 호출하지 않는다.
+ 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
+ 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
+ 기본적으로 Kotlin Style Guide를 원칙으로 한다.

## 🎯프로그래밍 요구 사항2
+ indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    + 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    + 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
+ JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    + 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        + JUnit 5 User Guide
        + AssertJ User Guide
        + AssertJ Exception Assertions
        + Guide to JUnit 5 Parameterized Tests

### 라이브러리
+ camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
+ Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
+ 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

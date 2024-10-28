# 🎯 자동차 경주 게임

<br><br>
## 🛠️ 프로젝트 소개
초간단 자동차 경주 게임을 구현하는 과제입니다.

<br><br>
## 📌 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

<br><br>
## 💡 기능 목록

### 1. 입력 기능
- **자동차 이름 입력**
    - 사용자가 경주할 자동차의 이름을 쉼표(`,`)로 구분하여 입력합니다.
    - 각 자동차의 이름은 최대 5자까지 허용합니다.
    - 유효성 검사를 통해 이름 길이가 초과되거나 비어있는 경우 예외를 발생시킵니다.

- **이동 횟수 입력**
    - 사용자가 몇 번의 이동을 할지 입력합니다.
    - 입력한 값이 숫자여야 하며, 1 이상의 정수여야 합니다.
    - 유효하지 않은 입력 시 `IllegalArgumentException`을 발생시킵니다.

### 2. 자동차 경주 진행 기능
- **자동차 객체 생성 및 초기화**
    - 입력된 자동차 이름을 기반으로 자동차 객체를 생성하여 초기화합니다.

- **자동차 전진 조건 설정**
    - 0에서 9 사이의 랜덤 숫자를 추출하여, 4 이상일 경우 자동차가 전진합니다.
    - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 메서드를 이용합니다.

- **횟수별 경주 실행 및 위치 출력**
    - 주어진 횟수만큼 각 자동차의 전진 여부를 판단하고, 위치를 업데이트한 후 출력을 진행합니다.

### 3. 경기 진행 결과 출력 기능
- **매 시도별 자동차 위치 출력**
    - 시도 횟수별로 각 자동차의 이름과 전진한 거리를 출력합니다.

- **우승자 출력**
    - 가장 많이 전진한 자동차를 우승자로 설정합니다.
    - 우승자가 여러 명일 경우, 이름을 쉼표(`,`)로 구분하여 공동 우승자를 표시합니다.

### 4. 예외 처리 기능
- **잘못된 입력에 대한 예외 처리**
    - 유효하지 않은 입력을 받을 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료합니다.

<br><br>
## 💻 실행 예시
아래와 같은 순서로 프로그램이 실행됩니다.

```plaintext
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
<br><br>
## +) 이모지들 모음

### 체크 및 상태 표시 아이콘
✅ 완료된 작업 <br>
✔️ 체크 (체크 표시)<br>
❌ 실패 또는 미완료<br>
🔄 업데이트 중<br>
⏳ 진행 중 (로딩 중)<br>
🚀 출시됨 또는 배포됨<br>

### 주제 또는 기능을 나타내는 아이콘
💡 아이디어 또는 팁<br>
📌 중요 정보<br>
⚙️ 설정 또는 구성<br>
📝 문서화 필요<br>
🛠️ 도구 또는 작업<br>
🎉 새 기능 추가<br>
🐞 버그 또는 문제점<br>

### 사람 및 기여 관련 아이콘
👤 사용자<br>
👥 팀<br>
💬 논의 중<br>
🙏 감사<br>
👍 좋아요 또는 찬성<br>
👎 반대 또는 개선 필요<br>

### 파일 및 형식 관련 아이콘
📁 폴더<br>
📄 문서 파일<br>
🗂️ 카테고리 또는 분류<br>
📊 데이터 분석<br>
💻 코드 또는 프로그래밍<br>

### 시간 및 일정을 나타내는 아이콘
⏰ 일정 또는 마감 시간<br>
🗓️ 일정 또는 타임라인<br>
⏱️ 시간 기록<br>
🔜 곧 공개 예정<br>

### 기타 재미있는 아이콘
💥 에러 또는 예외<br>
🔥 긴급하거나 중요한 문제<br>
🌐 글로벌 또는 웹 관련<br>
💸 비용 관련<br>
🎯 목표<br>

# 미션 - 로또 게임

## 구현할 기능 목록

##### - inputView 이용해서 Lotto 구매 금액 입력 받는 기능 추가
##### - 구매 금액 만큼 로또 객체 생성하는 기능 추가 
##### - 구매한 로또 OutputView로 출력하는 기능 추가 
##### - 지난 주 당첨 번호 입력 받는 기능 추가 
##### - 보너스 당첨 번호 입력 받는 기능 추가 
##### - 지난 주 당첨 번호와 생성된 로또가 맞는 지 확인하는 기능 추가
##### - 당첨 통계 계산하는 기능 추가 
##### - 당첨 통계 결과 OutputView로 출력하는 기능 추가 

## 🚀 기능 요구사항
- 로또 게임 기능을 구현해야 한다. 규칙을 모르면 검색해 로또 규칙을 찾아본다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
- 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
- 수익률을 계산해 출력해야 한다.

<br>

## ✍🏻 입출력 요구사항
### ⌨️ 입력
- 로또 구입 금액
- 로또 당첨번호
- 로또 보너스 번호

### 🖥 출력
- 구입한 로또 개수만큼 생성된 로또번호 목록 
```
3개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[1, 3, 6, 7, 33, 37]
[6, 16, 25, 29, 39, 45]
```
- 당첨 통계
```
당첨 통계
--------------
3개 일치 (5000원) - 1개
4개 일치 (50000원) - 0개
5개 일치 (1500000원) - 0개
5개 일치, 보너스 볼 일치 (30000000원) - 0개
총 수익률은 1.66입니다.
```

### 💻 프로그래밍 실행 결과 예시
```
구입금액을 입력해 주세요.
3000

3개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[1, 3, 6, 7, 33, 37]
[6, 16, 25, 29, 39, 45]

지난 주 당첨번호를 입력해 주세요.
1,2,3,4,5,6
보너스 볼을 입력해주세요.
7

당첨 통계
--------------
3개 일치 (5000원) - 1개
4개 일치 (50000원) - 0개
5개 일치 (1500000원) - 0개
5개 일치, 보너스 볼 일치 (30000000원) - 0개
총 수익률은 1.66입니다.
… 
```

<br>

## 🎱 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- else 예약어를 쓰지 않는다.
- 접근제어자(public, protected, private, package)를 용도에 적합하게 사용해 구현한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- System.exit 메소드를 사용하지 않는다.
- 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.

### 프로그래밍 요구사항 - Application
- Application 클래스를 활용해 구현해야 한다.
- Application의 패키지 구조와 구현은 변경하지 않는다.
- `// TODO 구현 진행` 이 후 부터 구현한다.

```java
public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
    }
}
```

### 프로그래밍 요구사항 - domain.Lotto
- domain.Lotto 객체를 활용해 구현해야 한다.
- domain.Lotto 기본 생성자를 추가할 수 없다.
- numbers 변수의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다. 

```java
public class domain.Lotto {
	private final List<Integer> numbers;

	public domain.Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	// 추가 기능 구현
}
```

### 프로그래밍 요구사항 - domain.WinningLotto
- domain.WinningLotto 객체를 활용해 구현해야 한다.
- match() 메서드의 반환 값인 Rank는 저장소에서 제공한다.
- domain.WinningLotto 기본 생성자를 추가할 수 없다.
- lotto, bonusNo 변수의 접근제어자인 private을 변경할 수 없다.
- WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.

```java
public class domain.WinningLotto {
	private final domain.Lotto lotto;
	private final int bonusNo;

	public domain.WinningLotto(domain.Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public domain.Rank match(domain.Lotto userLotto) {
		// TODO 로직 구현
		return null;
	}
}
```

<br>

## 📈 진행 요구사항
- 미션은 [로또게임 구현](https://github.com/cleancode-practice-study/java-practice-lotto) 를 fork/clone해 시작한다.
- 기능을 구현하기 전에 java-practice-lotto/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.

<br>

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNum() {
		List<Integer> num = numbers;
		return num;
	}

	public void printLottoNums() {
		System.out.println(numbers);
	}

}

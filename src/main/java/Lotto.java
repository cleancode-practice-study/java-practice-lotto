import java.util.List;

public class Lotto {
	private final List<Integer> numbers;
	private static final int MAX_LOTTO_COUNT = 6;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public void printLottoNumber() {
		System.out.print("[");
		for(int i = 0; i < MAX_LOTTO_COUNT; i++){
			System.out.print(this.numbers.get(i));

			if(i < 5){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}

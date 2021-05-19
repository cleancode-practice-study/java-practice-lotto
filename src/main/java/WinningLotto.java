import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		return Rank.valueOf(getNumMatch(userLotto), getBonusNoMatch(userLotto));
	}

	private boolean getBonusNoMatch(Lotto userLotto){
		return userLotto.getNumbers().contains(bonusNo);
	}

	private int getNumMatch(Lotto userLotto){
		List<Integer> user = userLotto.getNumbers();
		List<Integer> answer = lotto.getNumbers();

		user.retainAll(answer);

		return user.size();
	}
}

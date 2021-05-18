import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		boolean matchBonus = bonusMatch(userLotto);

		return Rank.valueOf(getNumMatch(userLotto), matchBonus);
	}

	private boolean bonusMatch(Lotto userLotto){
		return userLotto.getNumbers().contains(bonusNo);
	}

	private int getNumMatch(Lotto userLotto){
		List<Integer> user = userLotto.getNumbers();
		List<Integer> answer = lotto.getNumbers();

		user.retainAll(answer);

		return user.size();
	}
}

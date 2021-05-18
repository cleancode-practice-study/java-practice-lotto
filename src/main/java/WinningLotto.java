import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		int matchOfCount = getMatchOfCount(userLotto);
		boolean matchOfBonus = getMatchOfBonus(userLotto);

		Rank resultOfMatch = Rank.valueOf(matchOfCount, matchOfBonus);

		return resultOfMatch;
	}

	private int getMatchOfCount (Lotto userLotto) {
		List<Integer> userLottoNums = userLotto.getNum();
		List<Integer> targetNums = lotto.getNum();

		int matchOfCount = 0;

		for(int targetNum : targetNums) {
			if(userLottoNums.contains(targetNums.get(targetNum))) {
				matchOfCount++;
			}
		}

		return matchOfCount;
	}

	private boolean getMatchOfBonus (Lotto userLotto) {
		List<Integer> userLottoNums = userLotto.getNum();

		boolean matchOfBonus = false;

		for(int userNum : userLottoNums) {
			if(userNum == bonusNo) {
				matchOfBonus = true;
			}
		}

		return matchOfBonus;
	}
}

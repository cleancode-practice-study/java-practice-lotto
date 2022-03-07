package domain;

import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> lottoResult;

    public WinningResult (Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getCountOfLottoResult(Rank rank) {
        return lottoResult.get(rank);
    }

    public int getLottoTotalMoney() {
        int totalWinMoney = 0;

        for(Rank rank : lottoResult.keySet()) {
            if(lottoResult.get(rank) > 0) {
                totalWinMoney += rank.getWinningMoney();
            }
        }

        return totalWinMoney;
    }
}

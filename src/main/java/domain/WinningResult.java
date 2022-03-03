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
}

package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes (List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    public int getLottoesCount() {
        return lottoes.size();
    }

    public WinningResult getLottoWinResult(WinningLotto winningLotto) {
        Map<Rank, Integer> lottoResult = createResult();

        for(Lotto lotto : lottoes) {
            Rank rank = winningLotto.match(lotto);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }

        return new WinningResult(lottoResult);
    }

    private Map<Rank, Integer> createResult(){
        Map<Rank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(Rank.MISS, 0);
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);

        return lottoResult;
    }
}

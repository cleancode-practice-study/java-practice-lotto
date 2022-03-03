package domain;

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

    public Map<Rank, Integer> getLottoWinResult(Map<Rank, Integer> lottoResult, WinningLotto winningLotto) {
        for(Lotto lotto : lottoes) {
            Rank rank = winningLotto.match(lotto);

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }

        return lottoResult;
    }
}

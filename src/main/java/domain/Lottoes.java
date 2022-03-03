package domain;

import java.util.List;

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
}

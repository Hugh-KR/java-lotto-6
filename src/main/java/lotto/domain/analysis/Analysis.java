package lotto.domain.analysis;

import java.util.List;
import lotto.domain.rank.Rank;

public class Analysis {

    private final List<Rank> ranks;
    private final double profitRate;

    public Analysis(final List<Rank> ranks, final int operand) {
        this.ranks = ranks;
        this.profitRate = calculateProfitRate(ranks, operand);
    }

    private double calculateProfitRate(final List<Rank> ranks, final int operand) {
        long profit = ranks.stream()
                .mapToLong(Rank::getProfit)
                .sum();
        return (double) profit / operand;
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }

    public double getProfitRate() {
        return this.profitRate;
    }
}

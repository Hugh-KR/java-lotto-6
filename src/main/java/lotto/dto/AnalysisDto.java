package lotto.dto;

import java.util.Collections;
import lotto.domain.analysis.Analysis;
import lotto.domain.rank.Rank;

public record AnalysisDto(
        int threeMatched,
        int fourMatched,
        int fiveMatched,
        int fiveMatchedWithBonus,
        int sixMatched,
        double profitRate
) {
    public static AnalysisDto toDto(final Analysis analysis) {
        return new AnalysisDto(
                Collections.frequency(analysis.getRanks(), Rank.THREE_MATCHED),
                Collections.frequency(analysis.getRanks(), Rank.FOUR_MATCHED),
                Collections.frequency(analysis.getRanks(), Rank.FIVE_MATCHED),
                Collections.frequency(analysis.getRanks(), Rank.FIVE_MATCHED_WITH_BONUS),
                Collections.frequency(analysis.getRanks(), Rank.SIX_MATCHED),
                analysis.getProfitRate()
        );
    }
}

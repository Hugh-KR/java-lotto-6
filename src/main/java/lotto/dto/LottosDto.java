package lotto.dto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.utils.Delimiter;

public class LottosDto {

    private final List<String> numbers;
    private final String joinedNumbers;

    public LottosDto(final List<String> numbers) {
        this.numbers = numbers;
        this.joinedNumbers = Delimiter.joinWithComma(numbers);
    }

    public static LottosDto toDto(final Lotto lotto) {
        return new LottosDto(lotto.parseString());
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return Delimiter.formatWithTarget(this.joinedNumbers);
    }
}

package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.errorMessage.input.IllegalArgumentAmountException;
import lotto.constant.errorMessage.lotto.LottoExceptionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static final String PROVIDER_PATH = "lotto.domain.lotto.provider.LottoTestProvider#";

    private void exceptionVerification(final List<Integer> numbers, final String message) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentAmountException.class)
                .hasMessageContaining(message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersOutOfSizeException")
    @DisplayName("로또 번호는 6개의 숫자로 구성되어야 한다.")
    void lottoOutOfSizeExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_OUT_OF_SIZE.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersOutOfRangeException")
    @DisplayName("로또 번호는 1부터 45 사이의 숫자로 구성되어야 한다.")
    void lottoOutOfRangeExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersDuplicatedException")
    @DisplayName("로또 번호는 중복 값이 존재할 수 없다.")
    void lottoNumbersDuplicatedExceptionTest(final List<Integer> numbers) {
        String message = LottoExceptionStatus.LOTTO_NUMBER_IS_DUPLICATED.getMessage();
        exceptionVerification(numbers, message);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNumbersContainsTargetNumber")
    @DisplayName("로또 번호는 타겟값을 가지고 있으면 참을 반환한다.")
    void containsTrueTest(final List<Integer> numbers, final int targetNumber) {
        final Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContains(targetNumber)).isTrue();
    }
}

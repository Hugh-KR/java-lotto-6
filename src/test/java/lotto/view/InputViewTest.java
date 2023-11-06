package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.AppConfig;
import lotto.view.reader.CustomReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InputViewTest {

    private static final String PROVIDER_PATH = "lotto.view.provider.PurchaseAmountInputTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final InputView inputView = APP_CONFIG.inputView;

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNotNumericException")
    @DisplayName("숫자 이외의 값은 입력할 수 없다.")
    void purchaseAmountNotNumericExceptionTest(final String input) {
        customReader.initInput(input);
        assertThatThrownBy(inputView::readPurchaseAmount)
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForNormalInput")
    @DisplayName("로또 구입 금액 입력 테스트")
    void readPurchaseAmountTest(final String input, final int expected) {
        customReader.initInput(input);
        final int amount = inputView.readPurchaseAmount();
        assertThat(amount).isEqualTo(expected);
    }
}

package lotto.exception.winning;

import lotto.exception.ExceptionStatus;

public enum WinningExceptionStatus implements ExceptionStatus {

    READ_IS_NULL("NULL 은 입력할 수 없습니다."),
    READ_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MESSAGE_PREFIX = "당첨 번호는 ";
    private static final String MESSAGE_SUFFIX = "다시 입력해 주세요.";

    private final String message;

    WinningExceptionStatus(final String message) {
        this.message = ERROR_PREFIX + MESSAGE_PREFIX + message + MESSAGE_SUFFIX;
    }

    public String getMessage() {
        return this.message;
    }
}
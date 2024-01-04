package lotto.controller;

import java.util.function.Supplier;
import lotto.exception.custom.CustomIllegalArgumentException;

public class ExceptionHandler {

    private static final ExceptionHandler EXCEPTION_HANDLER = new ExceptionHandler();
    private static final String ERROR_PREFIX = "[ERROR]";

    private ExceptionHandler() {
    }

    public static <T> T getExceptionHandler(final Supplier<T> supplier) {
        return EXCEPTION_HANDLER.handle(supplier);
    }

    private <T> T handle(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CustomIllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}

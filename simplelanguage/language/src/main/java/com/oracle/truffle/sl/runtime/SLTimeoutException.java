package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.exception.AbstractTruffleException;
import com.oracle.truffle.api.interop.ExceptionType;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.Node;

/**
 * Exception thrown when script execution exceeds the configured timeout.
 */
@ExportLibrary(InteropLibrary.class)
public final class SLTimeoutException extends AbstractTruffleException {

    private static final long serialVersionUID = 1L;

    @TruffleBoundary
    public SLTimeoutException(String message) {
        super(message);
    }

    @TruffleBoundary
    public SLTimeoutException(String message, Node location) {
        super(message, location);
    }

    @ExportMessage
    ExceptionType getExceptionType() {
        return ExceptionType.INTERRUPT;
    }
}

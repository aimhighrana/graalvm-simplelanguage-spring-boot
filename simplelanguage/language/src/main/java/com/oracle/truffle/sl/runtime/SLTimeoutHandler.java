package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage;
import org.graalvm.options.OptionCategory;
import org.graalvm.options.OptionDescriptor;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionKey;
import org.graalvm.options.OptionStability;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles timeout configuration for SimpleLanguage.
 */
public final class SLTimeoutHandler {

    public static final String OPTION_NAME = "sl.ScriptTimeout";
    public static final OptionKey<Long> TIMEOUT = new OptionKey<>(0L);

    private final long timeoutMillis;
    private long startTime;

    public SLTimeoutHandler(TruffleLanguage.Env env) {
        this.timeoutMillis = env.getOptions().get(TIMEOUT);
    }

    public void start() {
        if (timeoutMillis > 0) {
            startTime = System.currentTimeMillis();
        }
    }

    @TruffleBoundary
    public void checkTimeout() {
        if (timeoutMillis > 0) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime > timeoutMillis) {
                throw new SLTimeoutException("Script execution timed out after " + timeoutMillis + " milliseconds");
            }
        }
    }

    public static OptionDescriptors createOptionDescriptors() {
        List<OptionDescriptor> options = new ArrayList<>();
        options.add(OptionDescriptor.newBuilder(
            TIMEOUT,
            OPTION_NAME)
            .help("Sets the timeout (in milliseconds) for script execution")
            .category(OptionCategory.USER)
            .stability(OptionStability.STABLE)
            .build()
        );
        return OptionDescriptors.create(options);
    }
}

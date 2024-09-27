// CheckStyle: start generated
package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.sl.runtime.SLBigNumber;

@GeneratedBy(SLTypes.class)
public final class SLTypesGen extends SLTypes {

    protected SLTypesGen() {
    }

    public static boolean isLong(Object value) {
        return value instanceof Long;
    }

    public static long asLong(Object value) {
        assert value instanceof Long : "SLTypesGen.asLong: long expected";
        return (long) value;
    }

    public static long expectLong(Object value) throws UnexpectedResultException {
        if (value instanceof Long) {
            return (long) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

    public static boolean isBoolean(Object value) {
        return value instanceof Boolean;
    }

    public static boolean asBoolean(Object value) {
        assert value instanceof Boolean : "SLTypesGen.asBoolean: boolean expected";
        return (boolean) value;
    }

    public static boolean expectBoolean(Object value) throws UnexpectedResultException {
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException(value);
    }

    public static SLBigNumber expectImplicitSLBigNumber(int state, Object value) throws UnexpectedResultException {
        if ((state & 0b1) != 0 && value instanceof SLBigNumber) {
            return (SLBigNumber) value;
        } else if ((state & 0b10) != 0 && value instanceof Long) {
            return castBigNumber((long) value);
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitSLBigNumber(int state, Object value) {
        return ((state & 0b1) != 0 && value instanceof SLBigNumber)
             || ((state & 0b10) != 0 && value instanceof Long);
    }

    public static boolean isImplicitSLBigNumber(Object value) {
        return value instanceof SLBigNumber
             || value instanceof Long;
    }

    public static SLBigNumber asImplicitSLBigNumber(int state, Object value) {
        if (CompilerDirectives.inInterpreter()) {
            return asImplicitSLBigNumber(value);
        }
        if ((state & 0b1) != 0 && value instanceof SLBigNumber) {
            return (SLBigNumber) value;
        } else if ((state & 0b10) != 0 && value instanceof Long) {
            return castBigNumber((long) value);
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static SLBigNumber asImplicitSLBigNumber(Object value) {
        if (value instanceof SLBigNumber) {
            return (SLBigNumber) value;
        } else if (value instanceof Long) {
            return castBigNumber((long) value);
        } else {
            throw new IllegalArgumentException("Illegal implicit source type.");
        }
    }

    public static int specializeImplicitSLBigNumber(Object value) {
        if (value instanceof SLBigNumber) {
            return 0b1;
        } else if (value instanceof Long) {
            return 0b10;
        } else {
            return 0;
        }
    }

}

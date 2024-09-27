// CheckStyle: start generated
package com.oracle.truffle.sl.nodes.util;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.DenyReplace;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.api.strings.TruffleString.FromJavaStringNode;
import com.oracle.truffle.api.strings.TruffleString.FromLongNode;
import com.oracle.truffle.sl.nodes.SLTypes;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.runtime.SLBigNumber;
import com.oracle.truffle.sl.runtime.SLFunction;
import com.oracle.truffle.sl.runtime.SLNull;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLToTruffleStringNode.class)
@SuppressWarnings("unused")
public final class SLToTruffleStringNodeGen extends SLToTruffleStringNode {

    private static final Uncached UNCACHED = new Uncached();
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private FromJavaStringNode fromString_fromJavaStringNode_;
    @Child private FromLongNode fromLong_fromLongNode_;
    @Child private FromJavaStringNode fromBigNumber_fromJavaStringNode_;
    @Child private FromInterop0Data fromInterop0_cache;
    @Child private FromLongNode fromInterop1_fromLongNode_;
    @Child private FromJavaStringNode fromInterop1_fromJavaStringNode_;

    private SLToTruffleStringNodeGen() {
    }

    @ExplodeLoop
    @Override
    public TruffleString execute(Object arg0Value) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1) != 0 /* is-state_0 fromNull(SLNull) */ && SLTypes.isSLNull(arg0Value)) {
            SLNull arg0Value_ = SLTypes.asSLNull(arg0Value);
            return SLToTruffleStringNode.fromNull(arg0Value_);
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 fromString(String, FromJavaStringNode) */ && arg0Value instanceof String) {
            String arg0Value_ = (String) arg0Value;
            return SLToTruffleStringNode.fromString(arg0Value_, this.fromString_fromJavaStringNode_);
        }
        if ((state_0 & 0b100) != 0 /* is-state_0 fromTruffleString(TruffleString) */ && arg0Value instanceof TruffleString) {
            TruffleString arg0Value_ = (TruffleString) arg0Value;
            return SLToTruffleStringNode.fromTruffleString(arg0Value_);
        }
        if ((state_0 & 0b1000) != 0 /* is-state_0 fromBoolean(boolean) */ && arg0Value instanceof Boolean) {
            boolean arg0Value_ = (boolean) arg0Value;
            return SLToTruffleStringNode.fromBoolean(arg0Value_);
        }
        if ((state_0 & 0b10000) != 0 /* is-state_0 fromLong(long, FromLongNode) */ && arg0Value instanceof Long) {
            long arg0Value_ = (long) arg0Value;
            return SLToTruffleStringNode.fromLong(arg0Value_, this.fromLong_fromLongNode_);
        }
        if ((state_0 & 0b100000) != 0 /* is-state_0 fromBigNumber(SLBigNumber, FromJavaStringNode) */ && SLTypesGen.isImplicitSLBigNumber((state_0 & 0b11000000000) >>> 9 /* extract-implicit-state_0 0:SLBigNumber */, arg0Value)) {
            SLBigNumber arg0Value_ = SLTypesGen.asImplicitSLBigNumber((state_0 & 0b11000000000) >>> 9 /* extract-implicit-state_0 0:SLBigNumber */, arg0Value);
            return SLToTruffleStringNode.fromBigNumber(arg0Value_, this.fromBigNumber_fromJavaStringNode_);
        }
        if ((state_0 & 0b1000000) != 0 /* is-state_0 fromFunction(SLFunction) */ && arg0Value instanceof SLFunction) {
            SLFunction arg0Value_ = (SLFunction) arg0Value;
            return SLToTruffleStringNode.fromFunction(arg0Value_);
        }
        if ((state_0 & 0b110000000) != 0 /* is-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) || fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */) {
            if ((state_0 & 0b10000000) != 0 /* is-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */) {
                FromInterop0Data s7_ = this.fromInterop0_cache;
                while (s7_ != null) {
                    if ((s7_.interop_.accepts(arg0Value))) {
                        return SLToTruffleStringNode.fromInterop(arg0Value, s7_.interop_, s7_.fromLongNode_, s7_.fromJavaStringNode_);
                    }
                    s7_ = s7_.next_;
                }
            }
            if ((state_0 & 0b100000000) != 0 /* is-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */) {
                return this.fromInterop1Boundary(state_0, arg0Value);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(arg0Value);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private TruffleString fromInterop1Boundary(int state_0, Object arg0Value) {
        EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
        Node prev_ = encapsulating_.set(this);
        try {
            {
                InteropLibrary fromInterop1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                return SLToTruffleStringNode.fromInterop(arg0Value, fromInterop1_interop__, this.fromInterop1_fromLongNode_, this.fromInterop1_fromJavaStringNode_);
            }
        } finally {
            encapsulating_.set(prev_);
        }
    }

    private TruffleString executeAndSpecialize(Object arg0Value) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (SLTypes.isSLNull(arg0Value)) {
                SLNull arg0Value_ = SLTypes.asSLNull(arg0Value);
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 fromNull(SLNull) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromNull(arg0Value_);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                this.fromString_fromJavaStringNode_ = super.insert((FromJavaStringNode.create()));
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 fromString(String, FromJavaStringNode) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromString(arg0Value_, this.fromString_fromJavaStringNode_);
            }
            if (arg0Value instanceof TruffleString) {
                TruffleString arg0Value_ = (TruffleString) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 fromTruffleString(TruffleString) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromTruffleString(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 fromBoolean(boolean) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromBoolean(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                this.fromLong_fromLongNode_ = super.insert((FromLongNode.create()));
                this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 fromLong(long, FromLongNode) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromLong(arg0Value_, this.fromLong_fromLongNode_);
            }
            {
                int sLBigNumberCast0;
                if ((sLBigNumberCast0 = SLTypesGen.specializeImplicitSLBigNumber(arg0Value)) != 0) {
                    SLBigNumber arg0Value_ = SLTypesGen.asImplicitSLBigNumber(sLBigNumberCast0, arg0Value);
                    this.fromBigNumber_fromJavaStringNode_ = super.insert((FromJavaStringNode.create()));
                    state_0 = (state_0 | (sLBigNumberCast0 << 9) /* set-implicit-state_0 0:SLBigNumber */);
                    this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 fromBigNumber(SLBigNumber, FromJavaStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return SLToTruffleStringNode.fromBigNumber(arg0Value_, this.fromBigNumber_fromJavaStringNode_);
                }
            }
            if (arg0Value instanceof SLFunction) {
                SLFunction arg0Value_ = (SLFunction) arg0Value;
                this.state_0_ = state_0 = state_0 | 0b1000000 /* add-state_0 fromFunction(SLFunction) */;
                lock.unlock();
                hasLock = false;
                return SLToTruffleStringNode.fromFunction(arg0Value_);
            }
            if ((exclude) == 0 /* is-not-exclude fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */) {
                int count7_ = 0;
                FromInterop0Data s7_ = this.fromInterop0_cache;
                if ((state_0 & 0b10000000) != 0 /* is-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */) {
                    while (s7_ != null) {
                        if ((s7_.interop_.accepts(arg0Value))) {
                            break;
                        }
                        s7_ = s7_.next_;
                        count7_++;
                    }
                }
                if (s7_ == null) {
                    // assert (s7_.interop_.accepts(arg0Value));
                    if (count7_ < (SLToTruffleStringNode.LIMIT)) {
                        s7_ = super.insert(new FromInterop0Data(fromInterop0_cache));
                        s7_.interop_ = s7_.insertAccessor((INTEROP_LIBRARY_.create(arg0Value)));
                        s7_.fromLongNode_ = s7_.insertAccessor((FromLongNode.create()));
                        s7_.fromJavaStringNode_ = s7_.insertAccessor((FromJavaStringNode.create()));
                        VarHandle.storeStoreFence();
                        this.fromInterop0_cache = s7_;
                        this.state_0_ = state_0 = state_0 | 0b10000000 /* add-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */;
                    }
                }
                if (s7_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return SLToTruffleStringNode.fromInterop(arg0Value, s7_.interop_, s7_.fromLongNode_, s7_.fromJavaStringNode_);
                }
            }
            {
                InteropLibrary fromInterop1_interop__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        fromInterop1_interop__ = (INTEROP_LIBRARY_.getUncached(arg0Value));
                        this.fromInterop1_fromLongNode_ = super.insert((FromLongNode.create()));
                        this.fromInterop1_fromJavaStringNode_ = super.insert((FromJavaStringNode.create()));
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */;
                        this.fromInterop0_cache = null;
                        state_0 = state_0 & 0xffffff7f /* remove-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */;
                        this.state_0_ = state_0 = state_0 | 0b100000000 /* add-state_0 fromInterop(Object, InteropLibrary, FromLongNode, FromJavaStringNode) */;
                        lock.unlock();
                        hasLock = false;
                        return SLToTruffleStringNode.fromInterop(arg0Value, fromInterop1_interop__, this.fromInterop1_fromLongNode_, this.fromInterop1_fromJavaStringNode_);
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b111111111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b111111111) & ((state_0 & 0b111111111) - 1)) == 0 /* is-single-state_0  */) {
                FromInterop0Data s7_ = this.fromInterop0_cache;
                if ((s7_ == null || s7_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static SLToTruffleStringNode create() {
        return new SLToTruffleStringNodeGen();
    }

    public static SLToTruffleStringNode getUncached() {
        return SLToTruffleStringNodeGen.UNCACHED;
    }

    @GeneratedBy(SLToTruffleStringNode.class)
    private static final class FromInterop0Data extends Node {

        @Child FromInterop0Data next_;
        @Child InteropLibrary interop_;
        @Child FromLongNode fromLongNode_;
        @Child FromJavaStringNode fromJavaStringNode_;

        FromInterop0Data(FromInterop0Data next_) {
            this.next_ = next_;
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
    @GeneratedBy(SLToTruffleStringNode.class)
    @DenyReplace
    private static final class Uncached extends SLToTruffleStringNode {

        @TruffleBoundary
        @Override
        public TruffleString execute(Object arg0Value) {
            if (SLTypes.isSLNull(arg0Value)) {
                SLNull arg0Value_ = SLTypes.asSLNull(arg0Value);
                return SLToTruffleStringNode.fromNull(arg0Value_);
            }
            if (arg0Value instanceof String) {
                String arg0Value_ = (String) arg0Value;
                return SLToTruffleStringNode.fromString(arg0Value_, (FromJavaStringNode.getUncached()));
            }
            if (arg0Value instanceof TruffleString) {
                TruffleString arg0Value_ = (TruffleString) arg0Value;
                return SLToTruffleStringNode.fromTruffleString(arg0Value_);
            }
            if (arg0Value instanceof Boolean) {
                boolean arg0Value_ = (boolean) arg0Value;
                return SLToTruffleStringNode.fromBoolean(arg0Value_);
            }
            if (arg0Value instanceof Long) {
                long arg0Value_ = (long) arg0Value;
                return SLToTruffleStringNode.fromLong(arg0Value_, (FromLongNode.getUncached()));
            }
            if (SLTypesGen.isImplicitSLBigNumber(arg0Value)) {
                SLBigNumber arg0Value_ = SLTypesGen.asImplicitSLBigNumber(arg0Value);
                return SLToTruffleStringNode.fromBigNumber(arg0Value_, (FromJavaStringNode.getUncached()));
            }
            if (arg0Value instanceof SLFunction) {
                SLFunction arg0Value_ = (SLFunction) arg0Value;
                return SLToTruffleStringNode.fromFunction(arg0Value_);
            }
            return SLToTruffleStringNode.fromInterop(arg0Value, (INTEROP_LIBRARY_.getUncached(arg0Value)), (FromLongNode.getUncached()), (FromJavaStringNode.getUncached()));
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MEGAMORPHIC;
        }

        @Override
        public boolean isAdoptable() {
            return false;
        }

    }
}

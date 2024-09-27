// CheckStyle: start generated
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.strings.TruffleString.ConcatNode;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.util.SLToTruffleStringNode;
import com.oracle.truffle.sl.nodes.util.SLToTruffleStringNodeGen;
import com.oracle.truffle.sl.runtime.SLBigNumber;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLAddNode.class)
public final class SLAddNodeGen extends SLAddNode {

    @Child private SLExpressionNode leftNode_;
    @Child private SLExpressionNode rightNode_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private Add2Data add2_cache;

    private SLAddNodeGen(SLExpressionNode leftNode, SLExpressionNode rightNode) {
        this.leftNode_ = leftNode;
        this.rightNode_ = rightNode;
    }

    private boolean fallbackGuard_(int state_0, Object leftNodeValue, Object rightNodeValue) {
        if (SLTypesGen.isImplicitSLBigNumber(leftNodeValue) && SLTypesGen.isImplicitSLBigNumber(rightNodeValue)) {
            return false;
        }
        if (((state_0 & 0b100)) == 0 /* is-not-state_0 add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) */ && (isString(leftNodeValue, rightNodeValue))) {
            return false;
        }
        return true;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1110) == 0 /* only-active add(long, long) */ && ((state_0 & 0b1111) != 0  /* is-not add(long, long) && add(SLBigNumber, SLBigNumber) && add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) && typeError(Object, Object) */)) {
            return executeGeneric_long_long0(state_0, frameValue);
        } else {
            return executeGeneric_generic1(state_0, frameValue);
        }
    }

    private Object executeGeneric_long_long0(int state_0, VirtualFrame frameValue) {
        long leftNodeValue_;
        try {
            leftNodeValue_ = this.leftNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            Object rightNodeValue = this.rightNode_.executeGeneric(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        long rightNodeValue_;
        try {
            rightNodeValue_ = this.rightNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        assert (state_0 & 0b1) != 0 /* is-state_0 add(long, long) */;
        try {
            return add(leftNodeValue_, rightNodeValue_);
        } catch (ArithmeticException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            Lock lock = getLock();
            lock.lock();
            try {
                this.exclude_ = this.exclude_ | 0b1 /* add-exclude add(long, long) */;
                this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 add(long, long) */;
            } finally {
                lock.unlock();
            }
            return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
        }
    }

    private Object executeGeneric_generic1(int state_0, VirtualFrame frameValue) {
        Object leftNodeValue_ = this.leftNode_.executeGeneric(frameValue);
        Object rightNodeValue_ = this.rightNode_.executeGeneric(frameValue);
        if ((state_0 & 0b1) != 0 /* is-state_0 add(long, long) */ && leftNodeValue_ instanceof Long) {
            long leftNodeValue__ = (long) leftNodeValue_;
            if (rightNodeValue_ instanceof Long) {
                long rightNodeValue__ = (long) rightNodeValue_;
                try {
                    return add(leftNodeValue__, rightNodeValue__);
                } catch (ArithmeticException ex) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    Lock lock = getLock();
                    lock.lock();
                    try {
                        this.exclude_ = this.exclude_ | 0b1 /* add-exclude add(long, long) */;
                        this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 add(long, long) */;
                    } finally {
                        lock.unlock();
                    }
                    return executeAndSpecialize(leftNodeValue__, rightNodeValue__);
                }
            }
        }
        if ((state_0 & 0b10) != 0 /* is-state_0 add(SLBigNumber, SLBigNumber) */ && SLTypesGen.isImplicitSLBigNumber((state_0 & 0b110000) >>> 4 /* extract-implicit-state_0 0:SLBigNumber */, leftNodeValue_)) {
            SLBigNumber leftNodeValue__ = SLTypesGen.asImplicitSLBigNumber((state_0 & 0b110000) >>> 4 /* extract-implicit-state_0 0:SLBigNumber */, leftNodeValue_);
            if (SLTypesGen.isImplicitSLBigNumber((state_0 & 0b11000000) >>> 6 /* extract-implicit-state_0 1:SLBigNumber */, rightNodeValue_)) {
                SLBigNumber rightNodeValue__ = SLTypesGen.asImplicitSLBigNumber((state_0 & 0b11000000) >>> 6 /* extract-implicit-state_0 1:SLBigNumber */, rightNodeValue_);
                return add(leftNodeValue__, rightNodeValue__);
            }
        }
        if ((state_0 & 0b1100) != 0 /* is-state_0 add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) || typeError(Object, Object) */) {
            if ((state_0 & 0b100) != 0 /* is-state_0 add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) */) {
                Add2Data s2_ = this.add2_cache;
                if (s2_ != null) {
                    if ((isString(leftNodeValue_, rightNodeValue_))) {
                        return add(leftNodeValue_, rightNodeValue_, s2_.toTruffleStringNodeLeft_, s2_.toTruffleStringNodeRight_, s2_.concatNode_);
                    }
                }
            }
            if ((state_0 & 0b1000) != 0 /* is-state_0 typeError(Object, Object) */) {
                if (fallbackGuard_(state_0, leftNodeValue_, rightNodeValue_)) {
                    return typeError(leftNodeValue_, rightNodeValue_);
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1000) != 0 /* is-state_0 typeError(Object, Object) */) {
            return SLTypesGen.expectLong(executeGeneric(frameValue));
        }
        long leftNodeValue_;
        try {
            leftNodeValue_ = this.leftNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            Object rightNodeValue = this.rightNode_.executeGeneric(frameValue);
            return SLTypesGen.expectLong(executeAndSpecialize(ex.getResult(), rightNodeValue));
        }
        long rightNodeValue_;
        try {
            rightNodeValue_ = this.rightNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return SLTypesGen.expectLong(executeAndSpecialize(leftNodeValue_, ex.getResult()));
        }
        if ((state_0 & 0b1) != 0 /* is-state_0 add(long, long) */) {
            try {
                return add(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-exclude add(long, long) */;
                    this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 add(long, long) */;
                } finally {
                    lock.unlock();
                }
                return SLTypesGen.expectLong(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return SLTypesGen.expectLong(executeAndSpecialize(leftNodeValue_, rightNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        try {
            if ((state_0 & 0b1110) == 0 /* only-active add(long, long) */ && ((state_0 & 0b1111) != 0  /* is-not add(long, long) && add(SLBigNumber, SLBigNumber) && add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) && typeError(Object, Object) */)) {
                executeLong(frameValue);
                return;
            }
            executeGeneric(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return;
        }
    }

    private Object executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if ((exclude) == 0 /* is-not-exclude add(long, long) */ && leftNodeValue instanceof Long) {
                long leftNodeValue_ = (long) leftNodeValue;
                if (rightNodeValue instanceof Long) {
                    long rightNodeValue_ = (long) rightNodeValue;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 add(long, long) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return add(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-exclude add(long, long) */;
                            this.state_0_ = this.state_0_ & 0xfffffffe /* remove-state_0 add(long, long) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            {
                int sLBigNumberCast0;
                if ((sLBigNumberCast0 = SLTypesGen.specializeImplicitSLBigNumber(leftNodeValue)) != 0) {
                    SLBigNumber leftNodeValue_ = SLTypesGen.asImplicitSLBigNumber(sLBigNumberCast0, leftNodeValue);
                    int sLBigNumberCast1;
                    if ((sLBigNumberCast1 = SLTypesGen.specializeImplicitSLBigNumber(rightNodeValue)) != 0) {
                        SLBigNumber rightNodeValue_ = SLTypesGen.asImplicitSLBigNumber(sLBigNumberCast1, rightNodeValue);
                        state_0 = (state_0 | (sLBigNumberCast0 << 4) /* set-implicit-state_0 0:SLBigNumber */);
                        state_0 = (state_0 | (sLBigNumberCast1 << 6) /* set-implicit-state_0 1:SLBigNumber */);
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 add(SLBigNumber, SLBigNumber) */;
                        lock.unlock();
                        hasLock = false;
                        return add(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            if ((isString(leftNodeValue, rightNodeValue))) {
                Add2Data s2_ = super.insert(new Add2Data());
                s2_.toTruffleStringNodeLeft_ = s2_.insertAccessor((SLToTruffleStringNodeGen.create()));
                s2_.toTruffleStringNodeRight_ = s2_.insertAccessor((SLToTruffleStringNodeGen.create()));
                s2_.concatNode_ = s2_.insertAccessor((ConcatNode.create()));
                VarHandle.storeStoreFence();
                this.add2_cache = s2_;
                this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 add(Object, Object, SLToTruffleStringNode, SLToTruffleStringNode, ConcatNode) */;
                lock.unlock();
                hasLock = false;
                return add(leftNodeValue, rightNodeValue, s2_.toTruffleStringNodeLeft_, s2_.toTruffleStringNodeRight_, s2_.concatNode_);
            }
            this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 typeError(Object, Object) */;
            lock.unlock();
            hasLock = false;
            return typeError(leftNodeValue, rightNodeValue);
        } finally {
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    @Override
    public NodeCost getCost() {
        int state_0 = this.state_0_;
        if ((state_0 & 0b1111) == 0) {
            return NodeCost.UNINITIALIZED;
        } else {
            if (((state_0 & 0b1111) & ((state_0 & 0b1111) - 1)) == 0 /* is-single-state_0  */) {
                return NodeCost.MONOMORPHIC;
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static SLAddNode create(SLExpressionNode leftNode, SLExpressionNode rightNode) {
        return new SLAddNodeGen(leftNode, rightNode);
    }

    @GeneratedBy(SLAddNode.class)
    private static final class Add2Data extends Node {

        @Child SLToTruffleStringNode toTruffleStringNodeLeft_;
        @Child SLToTruffleStringNode toTruffleStringNodeRight_;
        @Child ConcatNode concatNode_;

        Add2Data() {
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.NONE;
        }

        <T extends Node> T insertAccessor(T node) {
            return super.insert(node);
        }

    }
}

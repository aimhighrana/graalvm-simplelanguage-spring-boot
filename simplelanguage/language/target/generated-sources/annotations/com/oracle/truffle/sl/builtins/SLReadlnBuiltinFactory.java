// CheckStyle: start generated
package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.api.strings.TruffleString.FromJavaStringNode;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLReadlnBuiltin.class)
@SuppressWarnings("unused")
public final class SLReadlnBuiltinFactory implements NodeFactory<SLReadlnBuiltin> {

    private static final SLReadlnBuiltinFactory INSTANCE = new SLReadlnBuiltinFactory();

    private SLReadlnBuiltinFactory() {
    }

    @Override
    public Class<SLReadlnBuiltin> getNodeClass() {
        return SLReadlnBuiltin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList();
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(SLExpressionNode[].class));
    }

    @Override
    public SLReadlnBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[])) {
            return create((SLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLReadlnBuiltin> getInstance() {
        return INSTANCE;
    }

    public static SLReadlnBuiltin create(SLExpressionNode[] arguments) {
        return new SLReadlnBuiltinNodeGen(arguments);
    }

    @GeneratedBy(SLReadlnBuiltin.class)
    public static final class SLReadlnBuiltinNodeGen extends SLReadlnBuiltin {

        @CompilationFinal private volatile int state_0_;
        @Child private FromJavaStringNode fromJavaStringNode_;

        private SLReadlnBuiltinNodeGen(SLExpressionNode[] arguments) {
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            if (state_0 != 0 /* is-state_0 readln(FromJavaStringNode) */) {
                return readln(this.fromJavaStringNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize();
        }

        private TruffleString executeAndSpecialize() {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                this.fromJavaStringNode_ = super.insert((FromJavaStringNode.create()));
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readln(FromJavaStringNode) */;
                lock.unlock();
                hasLock = false;
                return readln(this.fromJavaStringNode_);
            } finally {
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        @Override
        public NodeCost getCost() {
            int state_0 = this.state_0_;
            if (state_0 == 0) {
                return NodeCost.UNINITIALIZED;
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

    }
}

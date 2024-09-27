// CheckStyle: start generated
package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.api.strings.TruffleString.ToJavaStringNode;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLAddToHostClassPathBuiltin.class)
public final class SLAddToHostClassPathBuiltinFactory implements NodeFactory<SLAddToHostClassPathBuiltin> {

    private static final SLAddToHostClassPathBuiltinFactory INSTANCE = new SLAddToHostClassPathBuiltinFactory();

    private SLAddToHostClassPathBuiltinFactory() {
    }

    @Override
    public Class<SLAddToHostClassPathBuiltin> getNodeClass() {
        return SLAddToHostClassPathBuiltin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList(SLExpressionNode.class);
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(SLExpressionNode[].class));
    }

    @Override
    public SLAddToHostClassPathBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[])) {
            return create((SLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLAddToHostClassPathBuiltin> getInstance() {
        return INSTANCE;
    }

    public static SLAddToHostClassPathBuiltin create(SLExpressionNode[] arguments) {
        return new SLAddToHostClassPathBuiltinNodeGen(arguments);
    }

    @GeneratedBy(SLAddToHostClassPathBuiltin.class)
    public static final class SLAddToHostClassPathBuiltinNodeGen extends SLAddToHostClassPathBuiltin {

        @Child private SLExpressionNode arguments0_;
        @CompilationFinal private volatile int state_0_;
        @Child private ToJavaStringNode toJavaStringNode_;

        private SLAddToHostClassPathBuiltinNodeGen(SLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            if (state_0 != 0 /* is-state_0 execute(TruffleString, ToJavaStringNode) */ && arguments0Value_ instanceof TruffleString) {
                TruffleString arguments0Value__ = (TruffleString) arguments0Value_;
                return execute(arguments0Value__, this.toJavaStringNode_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                if (arguments0Value instanceof TruffleString) {
                    TruffleString arguments0Value_ = (TruffleString) arguments0Value;
                    this.toJavaStringNode_ = super.insert((ToJavaStringNode.create()));
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(TruffleString, ToJavaStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return execute(arguments0Value_, this.toJavaStringNode_);
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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

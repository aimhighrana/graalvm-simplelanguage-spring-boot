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
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import java.util.Arrays;
import java.util.List;

@GeneratedBy(SLExitBuiltin.class)
public final class SLExitBuiltinFactory implements NodeFactory<SLExitBuiltin> {

    private static final SLExitBuiltinFactory INSTANCE = new SLExitBuiltinFactory();

    private SLExitBuiltinFactory() {
    }

    @Override
    public Class<SLExitBuiltin> getNodeClass() {
        return SLExitBuiltin.class;
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
    public SLExitBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[])) {
            return create((SLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLExitBuiltin> getInstance() {
        return INSTANCE;
    }

    public static SLExitBuiltin create(SLExpressionNode[] arguments) {
        return new SLExitBuiltinNodeGen(arguments);
    }

    @GeneratedBy(SLExitBuiltin.class)
    public static final class SLExitBuiltinNodeGen extends SLExitBuiltin {

        @Child private SLExpressionNode arguments0_;
        @CompilationFinal private int state_0_;

        private SLExitBuiltinNodeGen(SLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            long arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(ex.getResult());
            }
            if (state_0 != 0 /* is-state_0 execute(long) */) {
                return execute(arguments0Value_);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof Long) {
                long arguments0Value_ = (long) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(long) */;
                return execute(arguments0Value_);
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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

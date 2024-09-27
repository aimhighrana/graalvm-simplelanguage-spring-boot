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
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.runtime.SLFunction;
import java.util.Arrays;
import java.util.List;

@GeneratedBy(SLRegisterShutdownHookBuiltin.class)
public final class SLRegisterShutdownHookBuiltinFactory implements NodeFactory<SLRegisterShutdownHookBuiltin> {

    private static final SLRegisterShutdownHookBuiltinFactory INSTANCE = new SLRegisterShutdownHookBuiltinFactory();

    private SLRegisterShutdownHookBuiltinFactory() {
    }

    @Override
    public Class<SLRegisterShutdownHookBuiltin> getNodeClass() {
        return SLRegisterShutdownHookBuiltin.class;
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
    public SLRegisterShutdownHookBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[])) {
            return create((SLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLRegisterShutdownHookBuiltin> getInstance() {
        return INSTANCE;
    }

    public static SLRegisterShutdownHookBuiltin create(SLExpressionNode[] arguments) {
        return new SLRegisterShutdownHookBuiltinNodeGen(arguments);
    }

    @GeneratedBy(SLRegisterShutdownHookBuiltin.class)
    public static final class SLRegisterShutdownHookBuiltinNodeGen extends SLRegisterShutdownHookBuiltin {

        @Child private SLExpressionNode arguments0_;
        @CompilationFinal private int state_0_;

        private SLRegisterShutdownHookBuiltinNodeGen(SLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            if (state_0 != 0 /* is-state_0 execute(SLFunction) */ && arguments0Value_ instanceof SLFunction) {
                SLFunction arguments0Value__ = (SLFunction) arguments0Value_;
                return execute(arguments0Value__);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            int state_0 = this.state_0_;
            if (arguments0Value instanceof SLFunction) {
                SLFunction arguments0Value_ = (SLFunction) arguments0Value;
                this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 execute(SLFunction) */;
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

// CheckStyle: start generated
package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.api.strings.TruffleString.EqualNode;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLEvalBuiltin.class)
public final class SLEvalBuiltinFactory implements NodeFactory<SLEvalBuiltin> {

    private static final SLEvalBuiltinFactory INSTANCE = new SLEvalBuiltinFactory();

    private SLEvalBuiltinFactory() {
    }

    @Override
    public Class<SLEvalBuiltin> getNodeClass() {
        return SLEvalBuiltin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList(SLExpressionNode.class, SLExpressionNode.class);
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(SLExpressionNode[].class));
    }

    @Override
    public SLEvalBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[])) {
            return create((SLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLEvalBuiltin> getInstance() {
        return INSTANCE;
    }

    public static SLEvalBuiltin create(SLExpressionNode[] arguments) {
        return new SLEvalBuiltinNodeGen(arguments);
    }

    @GeneratedBy(SLEvalBuiltin.class)
    public static final class SLEvalBuiltinNodeGen extends SLEvalBuiltin {

        @Child private SLExpressionNode arguments0_;
        @Child private SLExpressionNode arguments1_;
        @CompilationFinal private volatile int state_0_;
        @CompilationFinal private volatile int exclude_;
        @Child private EvalCachedData evalCached_cache;

        private SLEvalBuiltinNodeGen(SLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @ExplodeLoop
        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state_0 = this.state_0_;
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            Object arguments1Value_ = this.arguments1_.executeGeneric(frameValue);
            if (state_0 != 0 /* is-state_0 evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) || evalUncached(TruffleString, TruffleString) */ && arguments0Value_ instanceof TruffleString) {
                TruffleString arguments0Value__ = (TruffleString) arguments0Value_;
                if (arguments1Value_ instanceof TruffleString) {
                    TruffleString arguments1Value__ = (TruffleString) arguments1Value_;
                    if ((state_0 & 0b1) != 0 /* is-state_0 evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */) {
                        EvalCachedData s0_ = this.evalCached_cache;
                        while (s0_ != null) {
                            if ((SLEvalBuiltin.stringsEqual(s0_.equalNodeId_, s0_.cachedId_, arguments0Value__)) && (SLEvalBuiltin.stringsEqual(s0_.equalNodeCode_, s0_.cachedCode_, arguments1Value__))) {
                                return evalCached(arguments0Value__, arguments1Value__, s0_.cachedId_, s0_.cachedCode_, s0_.callNode_, s0_.equalNodeId_, s0_.equalNodeCode_);
                            }
                            s0_ = s0_.next_;
                        }
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 evalUncached(TruffleString, TruffleString) */) {
                        return evalUncached(arguments0Value__, arguments1Value__);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            try {
                int state_0 = this.state_0_;
                int exclude = this.exclude_;
                if (arguments0Value instanceof TruffleString) {
                    TruffleString arguments0Value_ = (TruffleString) arguments0Value;
                    if (arguments1Value instanceof TruffleString) {
                        TruffleString arguments1Value_ = (TruffleString) arguments1Value;
                        if ((exclude) == 0 /* is-not-exclude evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */) {
                            int count0_ = 0;
                            EvalCachedData s0_ = this.evalCached_cache;
                            if ((state_0 & 0b1) != 0 /* is-state_0 evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */) {
                                while (s0_ != null) {
                                    if ((SLEvalBuiltin.stringsEqual(s0_.equalNodeId_, s0_.cachedId_, arguments0Value_)) && (SLEvalBuiltin.stringsEqual(s0_.equalNodeCode_, s0_.cachedCode_, arguments1Value_))) {
                                        break;
                                    }
                                    s0_ = s0_.next_;
                                    count0_++;
                                }
                            }
                            if (s0_ == null) {
                                {
                                    TruffleString cachedId__ = (arguments0Value_);
                                    EqualNode equalNodeId__ = super.insert((EqualNode.create()));
                                    if ((SLEvalBuiltin.stringsEqual(equalNodeId__, cachedId__, arguments0Value_))) {
                                        TruffleString cachedCode__ = (arguments1Value_);
                                        EqualNode equalNodeCode__ = super.insert((EqualNode.create()));
                                        if ((SLEvalBuiltin.stringsEqual(equalNodeCode__, cachedCode__, arguments1Value_)) && count0_ < (SLEvalBuiltin.LIMIT)) {
                                            s0_ = super.insert(new EvalCachedData(evalCached_cache));
                                            s0_.cachedId_ = cachedId__;
                                            s0_.cachedCode_ = cachedCode__;
                                            s0_.callNode_ = s0_.insertAccessor((DirectCallNode.create(parse(arguments0Value_, arguments1Value_))));
                                            s0_.equalNodeId_ = s0_.insertAccessor(equalNodeId__);
                                            s0_.equalNodeCode_ = s0_.insertAccessor(equalNodeCode__);
                                            VarHandle.storeStoreFence();
                                            this.evalCached_cache = s0_;
                                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */;
                                        }
                                    }
                                }
                            }
                            if (s0_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return evalCached(arguments0Value_, arguments1Value_, s0_.cachedId_, s0_.cachedCode_, s0_.callNode_, s0_.equalNodeId_, s0_.equalNodeCode_);
                            }
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-exclude evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */;
                        this.evalCached_cache = null;
                        state_0 = state_0 & 0xfffffffe /* remove-state_0 evalCached(TruffleString, TruffleString, TruffleString, TruffleString, DirectCallNode, EqualNode, EqualNode) */;
                        this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 evalUncached(TruffleString, TruffleString) */;
                        lock.unlock();
                        hasLock = false;
                        return evalUncached(arguments0Value_, arguments1Value_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
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
                if ((state_0 & (state_0 - 1)) == 0 /* is-single-state_0  */) {
                    EvalCachedData s0_ = this.evalCached_cache;
                    if ((s0_ == null || s0_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @GeneratedBy(SLEvalBuiltin.class)
        private static final class EvalCachedData extends Node {

            @Child EvalCachedData next_;
            @CompilationFinal TruffleString cachedId_;
            @CompilationFinal TruffleString cachedCode_;
            @Child DirectCallNode callNode_;
            @Child EqualNode equalNodeId_;
            @Child EqualNode equalNodeCode_;

            EvalCachedData(EvalCachedData next_) {
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
    }
}

// CheckStyle: start generated
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.EncapsulatingNodeReference;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.util.SLToMemberNode;
import com.oracle.truffle.sl.nodes.util.SLToMemberNodeGen;
import com.oracle.truffle.sl.nodes.util.SLToTruffleStringNode;
import com.oracle.truffle.sl.nodes.util.SLToTruffleStringNodeGen;
import com.oracle.truffle.sl.runtime.SLObject;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLReadPropertyNode.class)
@SuppressWarnings("unused")
public final class SLReadPropertyNodeGen extends SLReadPropertyNode {

    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    @Child private SLExpressionNode receiverNode_;
    @Child private SLExpressionNode nameNode_;
    @CompilationFinal private volatile int state_0_;
    @CompilationFinal private volatile int exclude_;
    @Child private ReadArray0Data readArray0_cache;
    @Child private ReadSLObject0Data readSLObject0_cache;
    @Child private SLToTruffleStringNode readSLObject1_toTruffleStringNode_;
    @Child private ReadObject0Data readObject0_cache;
    @Child private SLToMemberNode readObject1_asMember_;

    private SLReadPropertyNodeGen(SLExpressionNode receiverNode, SLExpressionNode nameNode) {
        this.receiverNode_ = receiverNode;
        this.nameNode_ = nameNode;
    }

    @ExplodeLoop
    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state_0 = this.state_0_;
        Object receiverNodeValue_ = this.receiverNode_.executeGeneric(frameValue);
        Object nameNodeValue_ = this.nameNode_.executeGeneric(frameValue);
        if (state_0 != 0 /* is-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) || readArray(Object, Object, InteropLibrary, InteropLibrary) || readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) || readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) || readObject(Object, Object, InteropLibrary, SLToMemberNode) || readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
            if ((state_0 & 0b11) != 0 /* is-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) || readArray(Object, Object, InteropLibrary, InteropLibrary) */) {
                if ((state_0 & 0b1) != 0 /* is-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */) {
                    ReadArray0Data s0_ = this.readArray0_cache;
                    while (s0_ != null) {
                        if ((s0_.arrays_.accepts(receiverNodeValue_)) && (s0_.numbers_.accepts(nameNodeValue_)) && (s0_.arrays_.hasArrayElements(receiverNodeValue_))) {
                            return readArray(receiverNodeValue_, nameNodeValue_, s0_.arrays_, s0_.numbers_);
                        }
                        s0_ = s0_.next_;
                    }
                }
                if ((state_0 & 0b10) != 0 /* is-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            InteropLibrary readArray1_arrays__ = (INTEROP_LIBRARY_.getUncached());
                            if ((readArray1_arrays__.hasArrayElements(receiverNodeValue_))) {
                                return this.readArray1Boundary(state_0, receiverNodeValue_, nameNodeValue_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if ((state_0 & 0b1100) != 0 /* is-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) || readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */ && receiverNodeValue_ instanceof SLObject) {
                SLObject receiverNodeValue__ = (SLObject) receiverNodeValue_;
                if ((state_0 & 0b100) != 0 /* is-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */) {
                    ReadSLObject0Data s2_ = this.readSLObject0_cache;
                    while (s2_ != null) {
                        if ((s2_.objectLibrary_.accepts(receiverNodeValue__))) {
                            return readSLObject(receiverNodeValue__, nameNodeValue_, s2_.objectLibrary_, s2_.toTruffleStringNode_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state_0 & 0b1000) != 0 /* is-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */) {
                    return this.readSLObject1Boundary(state_0, receiverNodeValue__, nameNodeValue_);
                }
            }
            if ((state_0 & 0b110000) != 0 /* is-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) || readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
                if ((state_0 & 0b10000) != 0 /* is-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
                    ReadObject0Data s4_ = this.readObject0_cache;
                    while (s4_ != null) {
                        if ((s4_.objects_.accepts(receiverNodeValue_)) && (!(SLReadPropertyNode.isSLObject(receiverNodeValue_))) && (s4_.objects_.hasMembers(receiverNodeValue_))) {
                            return readObject(receiverNodeValue_, nameNodeValue_, s4_.objects_, s4_.asMember_);
                        }
                        s4_ = s4_.next_;
                    }
                }
                if ((state_0 & 0b100000) != 0 /* is-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(SLReadPropertyNode.isSLObject(receiverNodeValue_)))) {
                            InteropLibrary readObject1_objects__ = (INTEROP_LIBRARY_.getUncached());
                            if ((readObject1_objects__.hasMembers(receiverNodeValue_))) {
                                return this.readObject1Boundary(state_0, receiverNodeValue_, nameNodeValue_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(receiverNodeValue_, nameNodeValue_);
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object readArray1Boundary(int state_0, Object receiverNodeValue_, Object nameNodeValue_) {
        {
            InteropLibrary readArray1_arrays__ = (INTEROP_LIBRARY_.getUncached());
            InteropLibrary readArray1_numbers__ = (INTEROP_LIBRARY_.getUncached());
            return readArray(receiverNodeValue_, nameNodeValue_, readArray1_arrays__, readArray1_numbers__);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object readSLObject1Boundary(int state_0, SLObject receiverNodeValue__, Object nameNodeValue_) {
        {
            DynamicObjectLibrary readSLObject1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(receiverNodeValue__));
            return readSLObject(receiverNodeValue__, nameNodeValue_, readSLObject1_objectLibrary__, this.readSLObject1_toTruffleStringNode_);
        }
    }

    @SuppressWarnings("static-method")
    @TruffleBoundary
    private Object readObject1Boundary(int state_0, Object receiverNodeValue_, Object nameNodeValue_) {
        {
            InteropLibrary readObject1_objects__ = (INTEROP_LIBRARY_.getUncached());
            return readObject(receiverNodeValue_, nameNodeValue_, readObject1_objects__, this.readObject1_asMember_);
        }
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeGeneric(frameValue);
        return;
    }

    private Object executeAndSpecialize(Object receiverNodeValue, Object nameNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        try {
            int state_0 = this.state_0_;
            int exclude = this.exclude_;
            if (((exclude & 0b1)) == 0 /* is-not-exclude readArray(Object, Object, InteropLibrary, InteropLibrary) */) {
                int count0_ = 0;
                ReadArray0Data s0_ = this.readArray0_cache;
                if ((state_0 & 0b1) != 0 /* is-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */) {
                    while (s0_ != null) {
                        if ((s0_.arrays_.accepts(receiverNodeValue)) && (s0_.numbers_.accepts(nameNodeValue)) && (s0_.arrays_.hasArrayElements(receiverNodeValue))) {
                            break;
                        }
                        s0_ = s0_.next_;
                        count0_++;
                    }
                }
                if (s0_ == null) {
                    {
                        InteropLibrary arrays__ = super.insert((INTEROP_LIBRARY_.create(receiverNodeValue)));
                        // assert (s0_.arrays_.accepts(receiverNodeValue));
                        // assert (s0_.numbers_.accepts(nameNodeValue));
                        if ((arrays__.hasArrayElements(receiverNodeValue)) && count0_ < (SLReadPropertyNode.LIBRARY_LIMIT)) {
                            s0_ = super.insert(new ReadArray0Data(readArray0_cache));
                            s0_.arrays_ = s0_.insertAccessor(arrays__);
                            s0_.numbers_ = s0_.insertAccessor((INTEROP_LIBRARY_.create(nameNodeValue)));
                            VarHandle.storeStoreFence();
                            this.readArray0_cache = s0_;
                            this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */;
                        }
                    }
                }
                if (s0_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return readArray(receiverNodeValue, nameNodeValue, s0_.arrays_, s0_.numbers_);
                }
            }
            {
                InteropLibrary readArray1_numbers__ = null;
                InteropLibrary readArray1_arrays__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        {
                            readArray1_arrays__ = (INTEROP_LIBRARY_.getUncached());
                            if ((readArray1_arrays__.hasArrayElements(receiverNodeValue))) {
                                readArray1_numbers__ = (INTEROP_LIBRARY_.getUncached());
                                this.exclude_ = exclude = exclude | 0b1 /* add-exclude readArray(Object, Object, InteropLibrary, InteropLibrary) */;
                                this.readArray0_cache = null;
                                state_0 = state_0 & 0xfffffffe /* remove-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */;
                                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 readArray(Object, Object, InteropLibrary, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return readArray(receiverNodeValue, nameNodeValue, readArray1_arrays__, readArray1_numbers__);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            if (receiverNodeValue instanceof SLObject) {
                SLObject receiverNodeValue_ = (SLObject) receiverNodeValue;
                if (((exclude & 0b10)) == 0 /* is-not-exclude readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */) {
                    int count2_ = 0;
                    ReadSLObject0Data s2_ = this.readSLObject0_cache;
                    if ((state_0 & 0b100) != 0 /* is-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */) {
                        while (s2_ != null) {
                            if ((s2_.objectLibrary_.accepts(receiverNodeValue_))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        // assert (s2_.objectLibrary_.accepts(receiverNodeValue_));
                        if (count2_ < (SLReadPropertyNode.LIBRARY_LIMIT)) {
                            s2_ = super.insert(new ReadSLObject0Data(readSLObject0_cache));
                            s2_.objectLibrary_ = s2_.insertAccessor((DYNAMIC_OBJECT_LIBRARY_.create(receiverNodeValue_)));
                            s2_.toTruffleStringNode_ = s2_.insertAccessor((SLToTruffleStringNodeGen.create()));
                            VarHandle.storeStoreFence();
                            this.readSLObject0_cache = s2_;
                            this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */;
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return readSLObject(receiverNodeValue_, nameNodeValue, s2_.objectLibrary_, s2_.toTruffleStringNode_);
                    }
                }
                {
                    DynamicObjectLibrary readSLObject1_objectLibrary__ = null;
                    readSLObject1_objectLibrary__ = (DYNAMIC_OBJECT_LIBRARY_.getUncached(receiverNodeValue_));
                    this.readSLObject1_toTruffleStringNode_ = super.insert((SLToTruffleStringNodeGen.create()));
                    this.exclude_ = exclude = exclude | 0b10 /* add-exclude readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */;
                    this.readSLObject0_cache = null;
                    state_0 = state_0 & 0xfffffffb /* remove-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */;
                    this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 readSLObject(SLObject, Object, DynamicObjectLibrary, SLToTruffleStringNode) */;
                    lock.unlock();
                    hasLock = false;
                    return readSLObject(receiverNodeValue_, nameNodeValue, readSLObject1_objectLibrary__, this.readSLObject1_toTruffleStringNode_);
                }
            }
            if (((exclude & 0b100)) == 0 /* is-not-exclude readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
                int count4_ = 0;
                ReadObject0Data s4_ = this.readObject0_cache;
                if ((state_0 & 0b10000) != 0 /* is-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */) {
                    while (s4_ != null) {
                        if ((s4_.objects_.accepts(receiverNodeValue)) && (!(SLReadPropertyNode.isSLObject(receiverNodeValue))) && (s4_.objects_.hasMembers(receiverNodeValue))) {
                            break;
                        }
                        s4_ = s4_.next_;
                        count4_++;
                    }
                }
                if (s4_ == null) {
                    if ((!(SLReadPropertyNode.isSLObject(receiverNodeValue)))) {
                        // assert (s4_.objects_.accepts(receiverNodeValue));
                        InteropLibrary objects__ = super.insert((INTEROP_LIBRARY_.create(receiverNodeValue)));
                        if ((objects__.hasMembers(receiverNodeValue)) && count4_ < (SLReadPropertyNode.LIBRARY_LIMIT)) {
                            s4_ = super.insert(new ReadObject0Data(readObject0_cache));
                            s4_.objects_ = s4_.insertAccessor(objects__);
                            s4_.asMember_ = s4_.insertAccessor((SLToMemberNodeGen.create()));
                            VarHandle.storeStoreFence();
                            this.readObject0_cache = s4_;
                            this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */;
                        }
                    }
                }
                if (s4_ != null) {
                    lock.unlock();
                    hasLock = false;
                    return readObject(receiverNodeValue, nameNodeValue, s4_.objects_, s4_.asMember_);
                }
            }
            {
                InteropLibrary readObject1_objects__ = null;
                {
                    EncapsulatingNodeReference encapsulating_ = EncapsulatingNodeReference.getCurrent();
                    Node prev_ = encapsulating_.set(this);
                    try {
                        if ((!(SLReadPropertyNode.isSLObject(receiverNodeValue)))) {
                            readObject1_objects__ = (INTEROP_LIBRARY_.getUncached());
                            if ((readObject1_objects__.hasMembers(receiverNodeValue))) {
                                this.readObject1_asMember_ = super.insert((SLToMemberNodeGen.create()));
                                this.exclude_ = exclude = exclude | 0b100 /* add-exclude readObject(Object, Object, InteropLibrary, SLToMemberNode) */;
                                this.readObject0_cache = null;
                                state_0 = state_0 & 0xffffffef /* remove-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */;
                                this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 readObject(Object, Object, InteropLibrary, SLToMemberNode) */;
                                lock.unlock();
                                hasLock = false;
                                return readObject(receiverNodeValue, nameNodeValue, readObject1_objects__, this.readObject1_asMember_);
                            }
                        }
                    } finally {
                        encapsulating_.set(prev_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.receiverNode_, this.nameNode_}, receiverNodeValue, nameNodeValue);
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
                ReadArray0Data s0_ = this.readArray0_cache;
                ReadSLObject0Data s2_ = this.readSLObject0_cache;
                ReadObject0Data s4_ = this.readObject0_cache;
                if ((s0_ == null || s0_.next_ == null) && (s2_ == null || s2_.next_ == null) && (s4_ == null || s4_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
        }
        return NodeCost.POLYMORPHIC;
    }

    public static SLReadPropertyNode create(SLExpressionNode receiverNode, SLExpressionNode nameNode) {
        return new SLReadPropertyNodeGen(receiverNode, nameNode);
    }

    @GeneratedBy(SLReadPropertyNode.class)
    private static final class ReadArray0Data extends Node {

        @Child ReadArray0Data next_;
        @Child InteropLibrary arrays_;
        @Child InteropLibrary numbers_;

        ReadArray0Data(ReadArray0Data next_) {
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
    @GeneratedBy(SLReadPropertyNode.class)
    private static final class ReadSLObject0Data extends Node {

        @Child ReadSLObject0Data next_;
        @Child DynamicObjectLibrary objectLibrary_;
        @Child SLToTruffleStringNode toTruffleStringNode_;

        ReadSLObject0Data(ReadSLObject0Data next_) {
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
    @GeneratedBy(SLReadPropertyNode.class)
    private static final class ReadObject0Data extends Node {

        @Child ReadObject0Data next_;
        @Child InteropLibrary objects_;
        @Child SLToMemberNode asMember_;

        ReadObject0Data(ReadObject0Data next_) {
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

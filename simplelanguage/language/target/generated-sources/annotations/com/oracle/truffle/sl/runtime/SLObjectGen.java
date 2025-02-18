// CheckStyle: start generated
package com.oracle.truffle.sl.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.DenyReplace;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.object.DynamicObjectLibrary;
import com.oracle.truffle.api.strings.TruffleString.FromJavaStringNode;
import com.oracle.truffle.api.utilities.TriState;
import com.oracle.truffle.sl.runtime.SLObject.IsIdenticalOrUndefined;
import java.util.concurrent.locks.Lock;

@GeneratedBy(SLObject.class)
@SuppressWarnings("unused")
final class SLObjectGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);
    private static final LibraryFactory<DynamicObjectLibrary> DYNAMIC_OBJECT_LIBRARY_ = LibraryFactory.resolve(DynamicObjectLibrary.class);

    static  {
        LibraryExport.register(SLObject.class, new InteropLibraryExports());
    }

    private SLObjectGen() {
    }

    @GeneratedBy(SLObject.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, SLObject.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof SLObject;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof SLObject;
            return new Cached(receiver);
        }

        @GeneratedBy(SLObject.class)
        private static final class Cached extends InteropLibrary {

            @Child private DynamicObjectLibrary receiverDynamicObjectLibrary_;
            @CompilationFinal private volatile int state_0_;
            @Child private FromJavaStringNode fromJavaStringNode;

            protected Cached(Object receiver) {
                SLObject castReceiver = ((SLObject) receiver) ;
                this.receiverDynamicObjectLibrary_ = super.insert(DYNAMIC_OBJECT_LIBRARY_.create((castReceiver)));
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof SLObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                if (!(receiver instanceof SLObject)) {
                    return false;
                } else if (!this.receiverDynamicObjectLibrary_.accepts((receiver))) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            protected TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) != 0 /* is-state_0 doSLObject(SLObject, SLObject) || doOther(SLObject, Object) */) {
                    if ((state_0 & 0b1) != 0 /* is-state_0 doSLObject(SLObject, SLObject) */ && arg1Value instanceof SLObject) {
                        SLObject arg1Value_ = (SLObject) arg1Value;
                        return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                    }
                    if ((state_0 & 0b10) != 0 /* is-state_0 doOther(SLObject, Object) */) {
                        if (isIdenticalOrUndefinedFallbackGuard_(state_0, arg0Value, arg1Value)) {
                            return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
                        }
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return isIdenticalOrUndefinedAndSpecialize(arg0Value, arg1Value);
            }

            private TriState isIdenticalOrUndefinedAndSpecialize(SLObject arg0Value, Object arg1Value) {
                int state_0 = this.state_0_;
                if (arg1Value instanceof SLObject) {
                    SLObject arg1Value_ = (SLObject) arg1Value;
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 doSLObject(SLObject, SLObject) */;
                    return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                }
                this.state_0_ = state_0 = state_0 | 0b10 /* add-state_0 doOther(SLObject, Object) */;
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @Override
            public NodeCost getCost() {
                int state_0 = this.state_0_;
                if ((state_0 & 0b11) == 0) {
                    return NodeCost.UNINITIALIZED;
                } else {
                    if (((state_0 & 0b11) & ((state_0 & 0b11) - 1)) == 0 /* is-single-state_0  */) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            @Override
            public boolean hasLanguage(Object receiver) {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).hasLanguage();
            }

            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).getLanguage();
            }

            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).identityHashCode();
            }

            @Override
            public boolean hasMetaObject(Object receiver) {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).hasMetaObject();
            }

            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).getMetaObject();
            }

            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).toDisplayString(allowSideEffects);
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert receiver instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((SLObject) receiver)).hasMembers();
            }

            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100) != 0 /* is-state_0 removeMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary removeMemberNode__removeMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        arg0Value.removeMember(arg1Value, this.fromJavaStringNode, removeMemberNode__removeMember_objectLibrary__);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                removeMemberNode_AndSpecialize(arg0Value, arg1Value);
                return;
            }

            private void removeMemberNode_AndSpecialize(SLObject arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        DynamicObjectLibrary removeMemberNode__removeMember_objectLibrary__ = null;
                        this.fromJavaStringNode = super.insert(this.fromJavaStringNode == null ? ((FromJavaStringNode.create())) : this.fromJavaStringNode);
                        removeMemberNode__removeMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b100 /* add-state_0 removeMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.removeMember(arg1Value, this.fromJavaStringNode, removeMemberNode__removeMember_objectLibrary__);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) throws UnsupportedMessageException {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                {
                    DynamicObjectLibrary getMembersNode__getMembers_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                    return arg0Value.getMembers(arg1Value, getMembersNode__getMembers_objectLibrary__);
                }
            }

            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 existsMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary existsMemberNode__existsMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        return arg0Value.existsMember(arg1Value, this.fromJavaStringNode, existsMemberNode__existsMember_objectLibrary__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return existsMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private boolean existsMemberNode_AndSpecialize(SLObject arg0Value, String arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        DynamicObjectLibrary existsMemberNode__existsMember_objectLibrary__ = null;
                        this.fromJavaStringNode = super.insert(this.fromJavaStringNode == null ? ((FromJavaStringNode.create())) : this.fromJavaStringNode);
                        existsMemberNode__existsMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b1000 /* add-state_0 existsMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.existsMember(arg1Value, this.fromJavaStringNode, existsMemberNode__existsMember_objectLibrary__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 existsMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary existsMemberNode__existsMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        return arg0Value.existsMember(arg1Value, this.fromJavaStringNode, existsMemberNode__existsMember_objectLibrary__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return existsMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b1000) != 0 /* is-state_0 existsMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary existsMemberNode__existsMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        return arg0Value.existsMember(arg1Value, this.fromJavaStringNode, existsMemberNode__existsMember_objectLibrary__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return existsMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                {
                    InteropLibrary isMemberInsertableNode__isMemberInsertable_receivers__ = (this);
                    return arg0Value.isMemberInsertable(arg1Value, isMemberInsertableNode__isMemberInsertable_receivers__);
                }
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b10000) != 0 /* is-state_0 readMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary readMemberNode__readMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        return arg0Value.readMember(arg1Value, this.fromJavaStringNode, readMemberNode__readMember_objectLibrary__);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return readMemberNode_AndSpecialize(arg0Value, arg1Value);
            }

            private Object readMemberNode_AndSpecialize(SLObject arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        DynamicObjectLibrary readMemberNode__readMember_objectLibrary__ = null;
                        this.fromJavaStringNode = super.insert(this.fromJavaStringNode == null ? ((FromJavaStringNode.create())) : this.fromJavaStringNode);
                        readMemberNode__readMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b10000 /* add-state_0 readMember(SLObject, String, FromJavaStringNode, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        return arg0Value.readMember(arg1Value, this.fromJavaStringNode, readMemberNode__readMember_objectLibrary__);
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) throws UnsupportedMessageException, UnknownIdentifierException, UnsupportedTypeException {
                assert arg0Value_ instanceof SLObject : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                SLObject arg0Value = ((SLObject) arg0Value_);
                int state_0 = this.state_0_;
                if ((state_0 & 0b100000) != 0 /* is-state_0 writeMember(SLObject, String, Object, FromJavaStringNode, DynamicObjectLibrary) */) {
                    {
                        DynamicObjectLibrary writeMemberNode__writeMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        arg0Value.writeMember(arg1Value, arg2Value, this.fromJavaStringNode, writeMemberNode__writeMember_objectLibrary__);
                        return;
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                writeMemberNode_AndSpecialize(arg0Value, arg1Value, arg2Value);
                return;
            }

            private void writeMemberNode_AndSpecialize(SLObject arg0Value, String arg1Value, Object arg2Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    {
                        DynamicObjectLibrary writeMemberNode__writeMember_objectLibrary__ = null;
                        this.fromJavaStringNode = super.insert(this.fromJavaStringNode == null ? ((FromJavaStringNode.create())) : this.fromJavaStringNode);
                        writeMemberNode__writeMember_objectLibrary__ = this.receiverDynamicObjectLibrary_;
                        this.state_0_ = state_0 = state_0 | 0b100000 /* add-state_0 writeMember(SLObject, String, Object, FromJavaStringNode, DynamicObjectLibrary) */;
                        lock.unlock();
                        hasLock = false;
                        arg0Value.writeMember(arg1Value, arg2Value, this.fromJavaStringNode, writeMemberNode__writeMember_objectLibrary__);
                        return;
                    }
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            private static boolean isIdenticalOrUndefinedFallbackGuard_(int state_0, SLObject arg0Value, Object arg1Value) {
                if (((state_0 & 0b1)) == 0 /* is-not-state_0 doSLObject(SLObject, SLObject) */ && arg1Value instanceof SLObject) {
                    return false;
                }
                return true;
            }

        }
        @GeneratedBy(SLObject.class)
        @DenyReplace
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof SLObject) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof SLObject;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public TriState isIdenticalOrUndefined(Object arg0Value_, Object arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                if (arg1Value instanceof SLObject) {
                    SLObject arg1Value_ = (SLObject) arg1Value;
                    return IsIdenticalOrUndefined.doSLObject(arg0Value, arg1Value_);
                }
                return IsIdenticalOrUndefined.doOther(arg0Value, arg1Value);
            }

            @TruffleBoundary
            @Override
            public boolean hasLanguage(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .hasLanguage();
            }

            @TruffleBoundary
            @Override
            public Class<? extends TruffleLanguage<?>> getLanguage(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .getLanguage();
            }

            @TruffleBoundary
            @Override
            public int identityHashCode(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .identityHashCode();
            }

            @TruffleBoundary
            @Override
            public boolean hasMetaObject(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .hasMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object getMetaObject(Object receiver) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .getMetaObject();
            }

            @TruffleBoundary
            @Override
            public Object toDisplayString(Object receiver, boolean allowSideEffects) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .toDisplayString(allowSideEffects);
            }

            @TruffleBoundary
            @Override
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((SLObject) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public void removeMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                arg0Value.removeMember(arg1Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
                return;
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object arg0Value_, boolean arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.getMembers(arg1Value, DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.existsMember(arg1Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberModifiable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.existsMember(arg1Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberRemovable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.existsMember(arg1Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
            }

            @TruffleBoundary
            @Override
            public boolean isMemberInsertable(Object arg0Value_, String arg1Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.isMemberInsertable(arg1Value, (this));
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                return arg0Value.readMember(arg1Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
            }

            @TruffleBoundary
            @Override
            public void writeMember(Object arg0Value_, String arg1Value, Object arg2Value) {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                SLObject arg0Value = ((SLObject) arg0Value_);
                arg0Value.writeMember(arg1Value, arg2Value, (FromJavaStringNode.getUncached()), DYNAMIC_OBJECT_LIBRARY_.getUncached((arg0Value)));
                return;
            }

        }
    }
}

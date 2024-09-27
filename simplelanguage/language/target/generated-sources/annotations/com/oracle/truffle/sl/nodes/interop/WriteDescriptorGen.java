// CheckStyle: start generated
package com.oracle.truffle.sl.nodes.interop;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.DenyReplace;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.sl.nodes.interop.NodeObjectDescriptor.WriteDescriptor;
import java.util.concurrent.locks.Lock;

@GeneratedBy(WriteDescriptor.class)
final class WriteDescriptorGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(WriteDescriptor.class, new InteropLibraryExports());
    }

    private WriteDescriptorGen() {
    }

    @GeneratedBy(WriteDescriptor.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, WriteDescriptor.class, false, false, 0);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof WriteDescriptor;
            InteropLibrary uncached = new Uncached();
            return uncached;
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof WriteDescriptor;
            return new Cached();
        }

        @GeneratedBy(WriteDescriptor.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private volatile int state_0_;
            @CompilationFinal private BranchProfile error_;

            protected Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof WriteDescriptor) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof WriteDescriptor;
            }

            @Override
            public boolean hasMembers(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((WriteDescriptor) receiver)).hasMembers();
            }

            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((WriteDescriptor) receiver)).isMemberReadable(member);
            }

            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                return (((WriteDescriptor) receiver)).getMembers(includeInternal);
            }

            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnsupportedMessageException, UnknownIdentifierException {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                assert assertAdopted();
                WriteDescriptor arg0Value = ((WriteDescriptor) arg0Value_);
                int state_0 = this.state_0_;
                if (state_0 != 0 /* is-state_0 readMember(WriteDescriptor, String, BranchProfile) */) {
                    return arg0Value.readMember(arg1Value, this.error_);
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(WriteDescriptor arg0Value, String arg1Value) throws UnknownIdentifierException {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                try {
                    int state_0 = this.state_0_;
                    this.error_ = (BranchProfile.create());
                    this.state_0_ = state_0 = state_0 | 0b1 /* add-state_0 readMember(WriteDescriptor, String, BranchProfile) */;
                    lock.unlock();
                    hasLock = false;
                    return arg0Value.readMember(arg1Value, this.error_);
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
        @GeneratedBy(WriteDescriptor.class)
        @DenyReplace
        private static final class Uncached extends InteropLibrary {

            protected Uncached() {
            }

            @Override
            @TruffleBoundary
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof WriteDescriptor) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof WriteDescriptor;
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
            public boolean hasMembers(Object receiver) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((WriteDescriptor) receiver) .hasMembers();
            }

            @TruffleBoundary
            @Override
            public boolean isMemberReadable(Object receiver, String member) {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((WriteDescriptor) receiver) .isMemberReadable(member);
            }

            @TruffleBoundary
            @Override
            public Object getMembers(Object receiver, boolean includeInternal) throws UnsupportedMessageException {
                // declared: true
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((WriteDescriptor) receiver) .getMembers(includeInternal);
            }

            @TruffleBoundary
            @Override
            public Object readMember(Object arg0Value_, String arg1Value) throws UnknownIdentifierException {
                // declared: true
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                WriteDescriptor arg0Value = ((WriteDescriptor) arg0Value_);
                return arg0Value.readMember(arg1Value, (BranchProfile.getUncached()));
            }

        }
    }
}

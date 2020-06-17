/*
 * Copyright (c) 2011-2025 PiChen
 */
/**
 * Generic framework code included with
 * [Expert One-On-One J2EE Design and Development](http://www.amazon.com/exec/obidos/tg/detail/-/1861007841/)
 * by Rod Johnson (Wrox, 2002).
 * This code is free to use and modify.
 * Please contact [rod.johnson@interface21.com](mailto:rod.johnson@interface21.com)
 * for commercial support.
 */
package com.interface21.core

import java.io.PrintStream
import java.io.PrintWriter

/**
 * Handy class for wrapping runtime Exceptions with a root cause. This time-honoured
 * technique is no longer necessary in Java 1.4, which provides built-in support for
 * exception nesting. Thus exceptions in applications written to use Java 1.4 need not
 * extend this class.
 *
 *
 *
 * Abstract to force the programmer to extend the class.
 * printStackTrace() etc. are forwarded to the wrapped Exception.
 * The present assumption is that all application-specific exceptions that could be
 * displayed to humans (users, administrators etc.) will implement the ErrorCoded interface.
 *
 *
 *
 * The similarity between this class and the NestedCheckedException class is unavoidable,
 * as Java forces these two classes to have different superclasses (ah, the inflexibility
 * of concrete inheritance!).
 *
 *
 *
 * As discussed in [Expert One-On-One J2EE Design and Development](http://www.amazon.com/exec/obidos/tg/detail/-/1861007841/),
 * runtime exceptions are often a better alternative to checked exceptions. However, all exceptions
 * should preserve their stack trace, if caused by a lower-level exception.
 *
 * @author Rod Johnson
 * @version $Id$
 */
abstract class NestedRuntimeException : RuntimeException, HasRootCause {
    /**
     * Returns the nested cause, or null if none.
     */
    /**
     * Root cause of this nested exception
     */
    private val rootCause_kt: Throwable?

    /**
     * Constructs a `ExceptionWrapperException` with the specified
     * detail message.
     *
     * @param msg the detail message
     */
    constructor(msg: String?) : this(msg, null)

    /**
     * Constructs a `RemoteException` with the specified
     * detail message and nested exception.
     *
     * @param msg the detail message
     * @param ex  the nested exception
     */
    constructor(msg: String?, ex: Throwable?) : super(msg) {
        rootCause_kt = ex
    }

    /**
     * Returns the detail message, including the message from the nested
     * exception if there is one.
     */
    override val message: String
        get() = if (rootCause_kt == null) super.message!! else """${super.message}; nested exception is: 
	${rootCause_kt.toString()}"""

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified stream `ps`.
     *
     * @param ps the print stream
     */
    override fun printStackTrace(ps: PrintStream) {
        if (rootCause_kt == null) {
            super.printStackTrace(ps)
        } else {
            //ps.println(this);
            rootCause_kt!!.printStackTrace(ps)
        }
    }

    /**
     * Prints the composite message and the embedded stack trace to
     * the specified print writer `pw`
     *
     * @param pw the print writer
     */
    override fun printStackTrace(pw: PrintWriter) {
        if (rootCause_kt == null) {
            super.printStackTrace(pw)
        } else {
            //pw.println(this);
            rootCause_kt!!.printStackTrace(pw)
        }
    }
}
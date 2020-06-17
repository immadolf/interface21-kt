/*
 * Copyright (c) 2011-2025 PiChen
 */
package com.interface21.core

/**
 * 由具有根本原因的异常实现的接口。 这使不共享公共超类的异常能够始终暴露根本原因。
 * 这在Java 1.4中不再是必需的，尽管不会兼容。
 *
 * @author Rod Johnson
 * @version $Id$
 */
interface HasRootCause {
    /**
     * 返回这个异常的根因.
     *
     * @return 个异常的根因,如果没有根因则返回NULL.
     */
    fun getRootCause(): Throwable?
}
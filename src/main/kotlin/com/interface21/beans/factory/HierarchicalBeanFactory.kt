package com.interface21.beans.factory

/**
 * 给那些有继承结构的bean工厂类实现的接口，表示有分层能力。
 *
 * @author 40313
 * @date 2020/6/12
 * @since
 */
interface HierarchicalBeanFactory : BeanFactory {

    /**
     * Returns the parent bean factory, or null if there is none.
     * 返回当前工厂类的父工厂，如果没有则返回null。
     *
     * @return the parent bean factory, or null if there is no parent
     */
    fun getParentBeanFactory(): BeanFactory?

}
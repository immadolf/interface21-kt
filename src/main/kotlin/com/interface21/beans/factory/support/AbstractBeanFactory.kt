package com.interface21.beans.factory.support

import com.interface21.beans.factory.BeanFactory
import com.interface21.beans.factory.HierarchicalBeanFactory

/**
 * 抽象类，方便实现BeanFactory.
 *
 * 这个类使用模版方法模式。
 *
 * 子类必须实现的方法只有getBeanDefinition(name).
 *
 * 此类处理运行时bean引用的解析，FactoryBean取消引用和集合属性的管理。
 * 它还允许管理bean工厂层次结构，实现HierarchicalBeanFactory接口。
 *
 * @author 40313
 * @date 2020/6/12
 * @since
 */
abstract class AbstractBeanFactory(private val parentBeanFactory: BeanFactory) : HierarchicalBeanFactory {

    constructor()

    override fun getParentBeanFactory() = parentBeanFactory


    /**
     * 返回给定名称的bean.如果找不到则查询父工厂.
     *
     * @param name 用来获取bean的名称
     */
    override fun getBean(name: String) = getBeanInternal(name, null)

    private fun getBeanInternal(name: String, newlyCreatedBeans: Map<Any, Any>?): Any? {

    }

    override fun <T> getBean(name: String, requiredType: Class<T>): T? {
        TODO("Not yet implemented")
    }

    override fun isSingleton(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAliases(name: String): Array<String> {
        TODO("Not yet implemented")
    }
}
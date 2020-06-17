package com.interface21.beans.factory

/**
 * 包含一组bean定义的对象实现的接口，每个bean定义都需要有一个唯一的名称。获取到的bean对象可能是单例的，
 * 也可能是独立的（原型）,这取决于具体的实现类,通常来说，单例的形式更常用.
 *
 * 这种方法的重点是BeanFactory是应用程序组件的中央注册表，
 * 并集中了应用程序组件的配置（例如，不再需要单个对象读取属性文件）。
 * 有关此方法的好处的讨论，请参见“一对一J2EE专家设计和开发”的第4章和第11章。
 *
 * 通常，BeanFactory将加载存储在配置源（例如XML文档）中的bean定义，并使用com.interface21.beans包来配置bean。
 * 但是，实现可以根据需要直接在Java代码中直接返回它创建的Java对象。
 * 定义的存储方式没有任何限制：LDAP，RDBMS，XML，属性文件等。
 * 鼓励实现以支持Bean之间对Singleton或Prototypes的引用。
 *
 * @author 40313
 * @date 2020/6/12
 * @since
 */
interface BeanFactory {

    fun getBean(name: String): Any?

    fun <T> getBean(name: String, requiredType: Class<T>): T?

    fun isSingleton(name: String): Boolean

    fun getAliases(name: String): Array<String>

}
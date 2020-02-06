MyBatis的开发步骤:
1. 编写dao接口
2. 编写映射文件
3. 注册映射文件


模糊查询: #{username}和${username}的区别是什么?
#: 表示占位符
$: 表示字符串拼接, 存在SQL注入的问题, 不建议使用.

|标签|属性|说明|
:--|:--|:--
mapper|namespace|唯一的区分不同的配置文件. 在使用代理方式的dao编码时, 取值要和Dao接口名称保持一致
insert、delete、update、select|id|文件中要求唯一。 在使用代理方式的dao编码时， 取值要和dao接口的方法保持一致
insert、delete、update、select|parameterType|指定参数的类型。Integer存在别名：int、integer。绝大多数情况可以省略该属性。 因为MyBatis能反射出类型
insert、delete、update、select|resultType|指定实体的类型。在结果集的字段名和实体类属性名一致时使用。 自动映射
insert、delete、update、select|resultMap|一般要配合resultMap标签使用。 指向手动映射的id的取值


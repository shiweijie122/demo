	练习：
	使用Spring + MyBatis集成的方式完成t_dept的增删改查操作。

	练习：
	使用Spring + MyBatis完成登录模块中的持久层实现。
	提示：
		按照Spring集成MyBatis的步骤检查看缺少哪些环节：
	step1.　导包。
		检查看缺少哪些包。
	step2. 在spring配置文件当中，添加SqlSessionFactoryBean的配置。
		注：注意包名要写完整，"."要改成"/"。
	step3. 实体类（不用写了，用之前的Admin）。
		注：该类有属性与表的字段名不一样，建议使用别名来解决。
	step4.　映射文件。
		注：应该与Mapper映射器保持一致。
	step5.　Mapper映射器(不用写了，用之前的AdminDAO)。
	step6. 添加MapperScannerConfigurer的配置。
	接下来，就可以启动spring容器，测试AdminDAO了。
	如果测试通过，可以测试整个登录模块。
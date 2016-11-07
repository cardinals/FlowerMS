1.该项目使用maven-3.3.3进行构建，maven构建使用JDK1.8环境，非1.8实测出现版本错误。。。
2.开发环境IntelliJ IDEA15.0.2+JDK1.8+mysql 50611+Tomcat8，并基于Maven导入MyEclipse2015，测试构建成功
3.数据库使用项目提供的flower.sql导入mysql即可使用；
4.数据库连接：（将类路径下的jdbc.properties中的连接参数修改成本地mysql相应的连接参数即可）
	driver=com.mysql.jdbc.Driver
	url=jdbc:mysql://localhost:3306/flower?useUnicode=true&characterEncoding=utf8
	user=root
	password=
5.初始管理员帐号：admin		密码：123456
6.提交文件说明：
	FlowerMS.zip：可直接解压到Tomcat下部署的项目文件夹压缩文件（包含了部分测试数据、上传图片文件等，和flower.sql数据库备份中的数据相一致）
	FlowerMS-src.zip：项目开发源码压缩包，其中的target文件夹下的FlowerMS.war是项目生成的原始结果
	使用技术.txt：整个项目所使用的部分技术点列表。
7.项目部署：
	东软教室中局域网：10.25.116.237:8080/FlowerMS/
	外网网站部署(2016-07-15 21:00:00开始生效)：http://www.coselding.cn/FlowerMS/


省平台后台

注意事项：

版本：2.1
1、山东版本上传图片问题，8080端口加上就可以上传。
2、后台用户头像的地址配置写死在cotent/aside.jsp页面，参数：rootUrl；
3、后台藏品二维码生成需要修改地址，在wwlist.jsp页面修改
var elText1 = 'http://bwsc.scmuseum.cn/mip/sc/m/index.html#/scrollMode?id='+elText+'&isSm=0';

打包方法
1、进入到项目目录下
	cd E:\eclipse-workspace\admin_bj
2、运行如下脚本：
	236测试环境：mvn clean package -D maven.test.skip=true -P beta
	政务云正式环境：mvn clean package -D maven.test.skip=true -P prod
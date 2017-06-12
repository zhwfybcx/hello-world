//配置
var config = {};
config.pageindex = 1;
config.pagesize = 10;

//本地
//config.name = "/cms/";//项目名
//
config.name = "/";//项目名

config.server = location.protocol + '//' + location.host+ config.name;//服务地址
config.file = location.protocol + '//' + location.host+ config.name;//文件地址
config.imagePath = "http://files.maidoupo.com/pic/images";//图片地址
config.cssPath = "http://files.maidoupo.com/pic/css";//CSS地址

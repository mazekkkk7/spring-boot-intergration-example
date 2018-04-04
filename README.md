# SpringBoot
使用SpringBoot快速构建项目:  
1、使用Maven构建项目  
2、集成RedisDemo  
3、集成ActiveMqDemo  
4、集成Mybatis的通用Mapper和PageHelper插件  
5、添加canal模块通过分析bin-log将数据写入到redis从数据库（ 需要在本地构建canal环境参考https://github.com/alibaba/canal/wiki ）  
6、集成Mybatis二级缓存使用Redis作为二级缓存  
7、集成spring-mina解决使用TcpIp交互的场景  
8、集成spring-cache使用redis作为缓存容器在方法上使用@Cache方法将结果缓存至redis中再次请求直接从redis获取数据，  
需要结合@CachePut(重写缓存)@CacheEvit清除缓存配合使用(注意如果在缓存的实体中存在List、ArrayList属性的话那么最好转为  
String[]数组的对象因为List本身有实现Serializable接口会将多层的List转为ArrayList$subList导致序列化成功却无法反序列化)  
9、集成spring-data-elasticsearch 本地使用elasticsearch 2.4.6  
10、如果使用idea开发工程 建议安装插件 阿里规约 安装及使用教程请自行google
# springboot集成activemq
1. 安装activemq服务  
安装地址：  
http://activemq.apache.org/components/classic/download/  
安装教程： 
https://www.cnblogs.com/donsenChen/p/8656563.html

2. 依赖导入  
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-activemq</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-pool</artifactId>
        </dependency>
```
<br>
3. 主要配置参数
<br>

```properties
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```
<br>
4. 配置动态监听器，监听发送消息模式是queue还是topic，动态切换，不使用spring.jms.pub-sub-domain配置
<br>

```
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConcurrency("1");
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
```
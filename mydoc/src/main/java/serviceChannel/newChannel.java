
服务端channel创建：
1、入口：serverBootstrap.bind ->AbstractBootstrap.doBind
                             ->AbstractBootstrap.initAndRegister
                                          ->channelFactory.newChannel() 创建channel
                                          ->init 初始化channel
2、在channelFactory方法中,通过ReflectiveChannelFactory工厂类创建NioServerSocketChannel,这个NioServerSocketChannel是在服务端
 服务端启动代码中的通过ServerBootstrap.channel设置的
3、NioServerSocketChannel的构造方法中通过newSocket方法，调用SelectorProvider对象来返回一个jdk底层的channel，由此可见，netty的channel
   是对jdkchannel的封装
4、在ServerBootstrap.init方法，初始化创建好的服务端channel
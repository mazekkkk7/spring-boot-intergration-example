package cn.mazekkkk.product.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by maze on 17/2/21.
 */
@Configuration
@EnableAutoConfiguration
public class MinaConfig implements EnvironmentAware {

    @Autowired
    private MinaHandler minaHandler;

    private RelaxedPropertyResolver minaPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.minaPropertyResolver = new RelaxedPropertyResolver(environment,"apache.mina.nio.");
    }

    @Bean
    public IoAcceptor getIoAcceptor() throws IOException {
        IoAcceptor ioAcceptor = new NioSocketAcceptor();;
        ioAcceptor.getSessionConfig().setReadBufferSize(Integer.parseInt(minaPropertyResolver.getProperty("readbuffersize")));
        ioAcceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, Integer.parseInt(minaPropertyResolver.getProperty("idletime")));
        ioAcceptor.setHandler(ioHandlerAdapter());
        ioAcceptor.bind(new InetSocketAddress(Integer.parseInt(minaPropertyResolver.getProperty("port"))));
        return ioAcceptor;
    }

    @Bean
    public DefaultIoFilterChainBuilder getDefaultIoFilterChainBuilder() throws IOException {
        DefaultIoFilterChainBuilder chain = this.getIoAcceptor().getFilterChain();
        LoggingFilter lf= new LoggingFilter();
        /**
         * 日志记录器
         */
        lf.setSessionClosedLogLevel(LogLevel.NONE);
        lf.setSessionCreatedLogLevel(LogLevel.NONE);
        lf.setSessionOpenedLogLevel(LogLevel.NONE);
        lf.setMessageReceivedLogLevel(LogLevel.NONE);
        lf.setMessageSentLogLevel(LogLevel.NONE);
        chain.addLast("logger",lf);
        /**
         * 设置编码过滤器 ProtocolCodecFilter用来把进来的ByteBuffer转换成POJO的消息对象
         */
        chain.addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

        return chain;
    }

    @Bean
    public IoHandlerAdapter ioHandlerAdapter(){
        return minaHandler;
    }


}

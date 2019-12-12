package com.gh.dubbo.security.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

/**
 * 启用基于redis的httpSession的实现
 */
@EnableRedisHttpSession
public class HttpSessionByRedisConfig {


//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }

//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer keySerializer = new StringRedisSerializer();
//        RedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setKeySerializer(keySerializer);
//        redisTemplate.setValueSerializer(valueSerializer);
//        redisTemplate.setHashKeySerializer(keySerializer);
//        redisTemplate.setHashValueSerializer(valueSerializer);
//        redisTemplate.setEnableTransactionSupport(true);
//        return redisTemplate;
//    }

    /**
     * FindByIndexNameSessionRepository是session为spring security 提供的用于在集群环境下控制会话并发的会话注册表实现类
     */

//    @Bean
//    public FindByIndexNameSessionRepository findByIndexNameSessionRepository(RedisTemplate redisTemplate) {
//        return new RedisIndexedSessionRepository(redisTemplate);
//    }
    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry(FindByIndexNameSessionRepository sessionRepository) {
        return new SpringSessionBackedSessionRegistry(sessionRepository);
    }

//    httpSession 的事件监听，改用sessions 提供的会话注册表
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}

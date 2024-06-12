package com.flight.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	private final String redisHost;
	private final int redisPort;

	public RedisConfig(
		@Value("${spring.data.redis.host}") String redisHost,
		@Value("${spring.data.redis.port}") String redisPort) {
		this.redisHost = redisHost;
		this.redisPort = Integer.parseInt(redisPort);
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory(){

		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(redisHost, redisPort);

		return new LettuceConnectionFactory(redisConfig);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

		return redisTemplate;
	}
}

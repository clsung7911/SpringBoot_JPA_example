package com.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration
@PropertySource("classpath:/application.properties")
//생성자를 주입
@RequiredArgsConstructor
public class DBConnection {
	//@RequiredArgsConstructor로 인해 선언만으로 생성자 주입가능
	//ApplicationContext : 스프링의 컨테이너(Container) 중 하나로, 빈(Bean)의 생성과 사용, 관계, 생명 주기 등을 관리
	private final ApplicationContext context;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig config() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(config());
	}
	
	@Bean
	//SqlSessionFactory : DB의 커넥션과, SQL 실행에 대한 모든 것을 갖는 객체
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml"));
        return factoryBean.getObject();
    }

    @Bean
    //SqlSessionTemplate : SQL 실행에 필요한 모든 메서드(INSERT, UPDATE, DELETE, SELECT)를 갖는 객체
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
	
}

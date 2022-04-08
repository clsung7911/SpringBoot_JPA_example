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
//�����ڸ� ����
@RequiredArgsConstructor
public class DBConnection {
	//@RequiredArgsConstructor�� ���� �������� ������ ���԰���
	//ApplicationContext : �������� �����̳�(Container) �� �ϳ���, ��(Bean)�� ������ ���, ����, ���� �ֱ� ���� ����
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
	//SqlSessionFactory : DB�� Ŀ�ؼǰ�, SQL ���࿡ ���� ��� ���� ���� ��ü
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml"));
        return factoryBean.getObject();
    }

    @Bean
    //SqlSessionTemplate : SQL ���࿡ �ʿ��� ��� �޼���(INSERT, UPDATE, DELETE, SELECT)�� ���� ��ü
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
	
}

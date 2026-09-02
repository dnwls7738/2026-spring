package kr.ac.kopo.config;

import javax.sql.DataSource;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan("kr.ac.kopo.mapper")
@PropertySource("classpath:config/db.properties")
@ComponentScan(basePackages = { "kr.ac.kopo.board" , "kr.ac.kopo.member"})
@Configuration
public class DBConfig {

	@Value("${jdbc.driver}")
	private String driver;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.user}")
	private String user;

	@Value("${jdbc.password}")
	private String password;

	
	// DB 접속 정보
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		
		//커넥션 풀 2개
		ds.setInitialSize(2);
		//커넥션 풀 최대 5개
		ds.setMaxTotal(5);
		
		return ds;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();	
		factoryBean.setDataSource(dataSource);
		
		// xml mapper location
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		
		factoryBean.setTypeAliasesPackage("kr.ac.kopo.*.vo");
		
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}

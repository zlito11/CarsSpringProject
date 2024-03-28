package com.carshopexample.carsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class CarsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsApiApplication.class, args);
	}

	@Configuration
	class DatabaseConfiguration {

		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) throws SQLException {
			String schema = "sa";
			try (var connection = dataSource.getConnection()) {
				DatabaseMetaData metaData = connection.getMetaData();
				ResultSet schemas = metaData.getSchemas();
				boolean schemaExists = false;
				while (schemas.next()){
					if (schema.equals(schemas.getString("TABLE_SCHEM"))) {
						schemaExists = true;
						break;
					}
				}
				if(!schemaExists) {
					connection.createStatement().execute("CREATE SCHEMA " + schema);
				}
			}
			return new JdbcTemplate(dataSource);
		}
	}
}
package com.bawnya.ravid.learning;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class CustomerConfiguration {

    @Bean
    public DataSource dataSource() {
      EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
      return embeddedDatabaseBuilder
          .setType(EmbeddedDatabaseType.H2).build();
    }
}

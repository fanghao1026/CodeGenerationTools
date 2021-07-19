package fh.love.cyh.codegenerationtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CodeGenerationToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeGenerationToolsApplication.class, args);
    }

}

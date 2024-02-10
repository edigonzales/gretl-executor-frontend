package ch.so.agi.gretl;

import com.github.javaparser.utils.Log;
//import ch.so.agi.gretl.data.SamplePersonRepository;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import ch.so.agi.gretl.services.JobConfigService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "gretl-executor-frontend")
public class Application implements AppShellConfigurator {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @Value("${app.jobsDirectory}")
//    private String jobsDirectory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    @Bean
//    CommandLineRunner init(JobConfigService jobConfigService) {
//        return args -> {
//            List<Path> tomlFiles = new ArrayList<Path>();
//            try (Stream<Path> walk = Files.walk(Paths.get(jobsDirectory))) {
//                tomlFiles = walk
//                        .filter(p -> !Files.isDirectory(p))   
//                        .filter(f -> {
//                            if (f.toString().toLowerCase().endsWith("toml")) {
//                                return true;
//                            }
//                            return false;
//                        })
//                        .collect(Collectors.toList());        
//            }
//            log.debug("Toml files found: {}", tomlFiles);
//            
//
//        };
//    }

//    @Bean
//    SqlDataSourceScriptDatabaseInitializer dataSourceScriptDatabaseInitializer(DataSource dataSource,
//            SqlInitializationProperties properties, SamplePersonRepository repository) {
//        // This bean ensures the database is only initialized when empty
//        return new SqlDataSourceScriptDatabaseInitializer(dataSource, properties) {
//            @Override
//            public boolean initializeDatabase() {
//                if (repository.count() == 0L) {
//                    return super.initializeDatabase();
//                }
//                return false;
//            }
//        };
//    }
}

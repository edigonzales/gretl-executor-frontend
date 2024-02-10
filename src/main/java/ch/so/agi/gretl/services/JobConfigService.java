package ch.so.agi.gretl.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class JobConfigService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${app.jobsDirectory}")
    private String jobsDirectory;
    
    private List<Path> tomlFiles;

    @PostConstruct
    public void load() throws IOException {
        tomlFiles = new ArrayList<Path>();
        try (Stream<Path> walk = Files.walk(Paths.get(jobsDirectory))) {
            tomlFiles = walk
                    .filter(p -> !Files.isDirectory(p))   
                    .filter(f -> {
                        if (f.toString().toLowerCase().endsWith("toml")) {
                            return true;
                        }
                        return false;
                    })
                    // Sehr dumm, da alle toml-Dateien gleich heissen und die Job-
                    // Verzeichnisse im gleichen Rootverzeichnis liegen.
                    // Es müsste eigentlich nach Parent-Verzeichnis sortiert werden.
                    .sorted() 
                    .collect(Collectors.toList());        
        }
        log.debug("Toml files found: {}", tomlFiles);

    }

    public List<Path> getTomlFiles() {
        return tomlFiles;
    }
    
}

package ch.so.agi.gretl.services;

import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.StorageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class FooService {
    
//    @Autowired
//    StorageProvider storageProvider;

//    @Autowired
//    private JobScheduler jobScheduler;
    
    @PostConstruct
    public void foo() {
        
    }

}

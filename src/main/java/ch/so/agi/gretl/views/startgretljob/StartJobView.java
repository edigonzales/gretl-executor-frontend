package ch.so.agi.gretl.views.startgretljob;

import ch.so.agi.gretl.services.JobConfigService;
import ch.so.agi.gretl.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jobrunr.scheduling.JobScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

@SpringComponent
@UIScope
@PageTitle("Start Job")
@Route(value = "start", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class StartJobView extends Composite<VerticalLayout> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    private JobConfigService jobConfigService;
    
//  @Autowired
    private JobScheduler jobScheduler;

    public StartJobView(JobConfigService jobConfigService, JobScheduler jobScheduler) {
        this.jobConfigService = jobConfigService;
        this.jobScheduler = jobScheduler;

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");

        ComboBox jobComboBox = new ComboBox();
        jobComboBox.setLabel("GRETL Jobs");
        //jobComboBox.setWidth("min-content");
        setJobComboBoxData(jobComboBox);
        
//        TextField textField = new TextField();
//        textField.setRequired(true);
//        Checkbox checkbox = new Checkbox();
        
        Button runButton = new Button();
        runButton.setText("Run");
        runButton.setWidth("min-content");
        runButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        runButton.addClickListener(e -> {
            if (jobComboBox.isEmpty()) {
                return;
            }
            System.out.println(jobComboBox.getValue().toString());
            addJobToQueue();
            
            Notification notification = Notification.show("Job was added to queue.");
            notification.setPosition(Notification.Position.MIDDLE);


            
        });
        
        
        
//        textField.setLabel("Text field Dummy");
//        textField.setWidth("min-content");
//        checkbox.setLabel("Checkbox Dummy");
//        checkbox.setWidth("100%");
        
        
        
        getContent().add(jobComboBox);
//        getContent().add(textField);
//        getContent().add(checkbox);
        getContent().add(runButton);
    }

//    TomlParseResult tomlResult = Toml.parse(tomlFile);
//    tomlResult.

    
    record JobConfigItem(String id, String label, String type) {
    }

    private void setJobComboBoxData(ComboBox comboBox) {
        List<String> jobItems = new ArrayList<>();
        
        List<Path> tomlFiles = jobConfigService.getTomlFiles();
        for (Path tomlFile : tomlFiles) {
            String jobName = tomlFile.getParent().toFile().getName();
            //log.debug(jobName);
            jobItems.add(jobName);
            
        }
        
        
        
//        jobConfigItems.add(new JobConfigItem("first", "First", null));
//        jobConfigItems.add(new JobConfigItem("second", "Second", null));
//        jobConfigItems.add(new JobConfigItem("third", "Third", Boolean.TRUE));
//        jobConfigItems.add(new JobConfigItem("fourth", "Fourth", null));
        comboBox.setItems(jobItems);
//        comboBox.setItemLabelGenerator(item -> ((JobConfigItem) item).label());
    }
    
    private void addJobToQueue() {
        
    }
}

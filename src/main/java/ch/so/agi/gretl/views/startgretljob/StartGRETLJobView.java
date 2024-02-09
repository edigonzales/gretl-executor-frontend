package ch.so.agi.gretl.views.startgretljob;

import ch.so.agi.gretl.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Start GRETL-Job")
@Route(value = "start", layout = MainLayout.class)
@Uses(Icon.class)
public class StartGRETLJobView extends Composite<VerticalLayout> {

    public StartGRETLJobView() {
        ComboBox comboBox = new ComboBox();
        TextField textField = new TextField();
        Checkbox checkbox = new Checkbox();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        comboBox.setLabel("GRETL-Jobs");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        textField.setLabel("Text field Dummy");
        textField.setWidth("min-content");
        checkbox.setLabel("Checkbox Dummy");
        checkbox.setWidth("100%");
        buttonPrimary.setText("Run");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(comboBox);
        getContent().add(textField);
        getContent().add(checkbox);
        getContent().add(buttonPrimary);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}

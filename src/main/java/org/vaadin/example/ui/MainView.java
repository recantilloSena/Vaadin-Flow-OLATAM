package org.vaadin.example.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.example.back.GreetService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Route("index")
@PageTitle("Intro Vaadin")
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

    @Inject
    private GreetService greetService;
    

    @PostConstruct
    public void init() {
        
        TextField textField = new TextField("Your name");
        
        
        Button button = new Button("Hola Java UI");
   

        button.addClickListener(e->{
           Notification.show( greetService.greet(textField.getValue()) ) ;
           
        });

         

       
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        
        button.addClickShortcut(Key.ENTER);

        
       

        add(textField, button);
    }

}

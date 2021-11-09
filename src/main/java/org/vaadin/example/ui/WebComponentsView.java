package org.vaadin.example.ui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("index5")
@PageTitle("Web Components")
@CssImport("./styles/shared-styles.css")
public class WebComponentsView extends HorizontalLayout {

    private ToggleButton toggleButton = new ToggleButton("Estado");
    private TextField name;
    private Button sayHello;

    public WebComponentsView() {
        name = new TextField("Saludos");
        sayHello = new Button("Activar Saludos");
        add(name, sayHello, toggleButton);
        setMargin(true);
        setSpacing(true);
        //Organizar los componetes
        setVerticalComponentAlignment(Alignment.END, name, sayHello, toggleButton);

        //El Nuevo Componete es dinámico
        toggleButton.addCheckListener(e->{
            if (e.getSource().isChecked()) {
                Notification.show("Activado!");
            }else{
                Notification.show("Inactivo");
            }

        });



        sayHello.addClickListener( e-> {
            toggleButton.setChecked(true);
            //Adicionar CSS a componentes Java directamente
            sayHello.addClassName("oracle");
            name.addClassName("oracle");
        });



    }

}

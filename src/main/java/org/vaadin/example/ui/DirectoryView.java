package org.vaadin.example.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.example.back.Creditos;
import org.vaadin.example.back.CreditosRepository;

import javax.inject.Inject;
import java.util.Collection;

@Route("index4")
@PageTitle("Vaadin Directory")
@CssImport("./styles/shared-styles.css")
public class DirectoryView extends VerticalLayout {

    private final GridCrud<Creditos> gridcrud;


    @Inject
    public DirectoryView(CreditosRepository creditosService) {
        this.gridcrud = new GridCrud<>(Creditos.class);


        //Activa BeanValidation - En los formularios
        //gridcrud.getCrudFormFactory().setUseBeanValidation(true);

        gridcrud.setCrudListener(new CrudListener<Creditos>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Collection<Creditos> findAll() {
                return creditosService.findAll();
            }

            @Override
            public Creditos add(Creditos creditos) {
                return creditosService.create(creditos);
            }

            @Override
            public Creditos update(Creditos creditos) {
                return creditosService.update(creditos);
            }

            @Override
            public void delete(Creditos creditos) {
                creditosService.delete(creditos);
            }
        });

        gridcrud.setHeight("30em");


        add(gridcrud);
    }

}

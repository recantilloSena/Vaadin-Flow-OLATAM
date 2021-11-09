package org.vaadin.example.ui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.example.back.Creditos;
import org.vaadin.example.back.CreditosRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Route("index3")
@PageTitle("Backend Data")
@CssImport("./styles/shared-styles.css")
public class BindDataView  extends HorizontalLayout {

    @Inject
    private  CreditosRepository creditoService;
    //CDI del Backend

    private  Grid<Creditos> grid;
    private  ComboBox<Creditos> combo;

    @PostConstruct
    public void init() {
        this.grid  = new Grid<>(Creditos.class);
        this.combo = new ComboBox<>();
        setSpacing(true);
        setMargin(true);

        //setupGrid();


        Button boton = new Button("Cargar desde el Back");
        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(boton,combo,grid);

        boton.addClickListener((t) -> {
          grid.setItems(creditoService.findAll());

          combo.setItems(creditoService.findAll());
          combo.setItemLabelGenerator(Creditos::getNombre);

        });

       }

    private void setupGrid() {

        grid.removeAllColumns();

        //Expresiones o cálculos para las Columnas
        grid.addColumn(credito ->  credito.getFecha().toString().substring(0, 4) )
                .setHeader("Año")
                .setSortable(true)
                .setFrozen(true)
                .setAutoWidth(true) ;

        //Type Safe Columns add
        grid.addColumn(Creditos::getNombre)
                .setHeader("Nombre Cliente") ;

        //Componentes en Columnas
        grid.addComponentColumn(  item -> createButton(grid,item) )
                .setHeader("Cupo de Crédito");

        grid.addComponentColumn(  item -> createProgress(grid,item) )
                .setHeader("Tipo de Crédito");


    }

    private Button createButton(Grid<Creditos> grid, Creditos item) {

        if( item.getCredito() > 0.6) {
            Button boton = new Button("",new Icon(VaadinIcon.PLUS_SQUARE_O));
            boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            return boton;
        }else{
            Button boton = new Button("", new Icon(VaadinIcon.MINUS_CIRCLE_O));
            boton.addThemeVariants(ButtonVariant.LUMO_ERROR);
            return boton;
        }
    }

    private ProgressBar createProgress(Grid<Creditos> grid, Creditos item) {

        ProgressBar bar = new ProgressBar( );
        bar.setValue(item.getCredito());

        if( item.getCredito() > 0.6) {
            bar.addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
            return bar;
        }else{
            bar.addThemeVariants(ProgressBarVariant.LUMO_ERROR);
            return bar;
        }
    }



}

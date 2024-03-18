package com.example.application.views.queries;

import com.example.application.bindObject.QueryParam;
import com.example.application.event.QueryFormSaveEvent;
import com.example.application.eventlistener.QueryFormSaveEventListener;
import com.example.application.services.SearchService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.List;

@PageTitle("Query Form")
@Route(value = "query-form", layout = MainLayout.class)
@Uses(Icon.class)
public class QueryForm extends Composite<VerticalLayout> {
    private TextField query = new TextField("Query");
    private BeanValidationBinder<QueryParam> binder = new BeanValidationBinder<>(QueryParam.class);
    public QueryForm() {
        addClassName("query-form");
        binder.bindInstanceFields(this);
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();

        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        getContent().setAlignItems(FlexComponent.Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Query document");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        layoutRow.addClassName(LumoUtility.Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Search");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener((event -> {
            QueryParam queryParam = new QueryParam();
            try {
                binder.writeBean(queryParam);
                System.out.println(queryParam.toString());

                List<String> searchResults = 
                    SearchService.search(queryParam.getQuery(), 5);
                System.out.println(searchResults);
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
            fireEvent(new QueryFormSaveEvent(this, queryParam));
        }));
        buttonSecondary.setText("Cancel");
        buttonSecondary.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(query);
        layoutColumn2.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
        addListener(QueryFormSaveEvent.class, new QueryFormSaveEventListener());
    }

    public void setQueryParam(QueryParam queryParam) {
        this.binder.setBean(queryParam);
    }


}

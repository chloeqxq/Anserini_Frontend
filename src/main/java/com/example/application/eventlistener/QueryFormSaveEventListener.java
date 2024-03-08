package com.example.application.eventlistener;

import com.example.application.event.QueryFormSaveEvent;
import com.vaadin.flow.component.ComponentEventListener;

public class QueryFormSaveEventListener  implements ComponentEventListener<QueryFormSaveEvent> {
    @Override
    public void onComponentEvent(QueryFormSaveEvent event) {
        System.out.println("Hello, this is QueryFormSaveEventListener");
        System.out.println(event.getQueryParam().toString());


    }
}

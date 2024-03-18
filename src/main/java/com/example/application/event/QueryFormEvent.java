package com.example.application.event;

import com.example.application.model.QueryParam;
import com.example.application.views.queries.QueryForm;
import com.vaadin.flow.component.ComponentEvent;

public abstract class QueryFormEvent extends ComponentEvent<QueryForm> {
    private QueryParam queryParam;

    protected QueryFormEvent(QueryForm source, QueryParam queryParam) {
        super(source, false);
        this.queryParam = queryParam;
    }

    public QueryParam getQueryParam() {
        return queryParam;
    }
}


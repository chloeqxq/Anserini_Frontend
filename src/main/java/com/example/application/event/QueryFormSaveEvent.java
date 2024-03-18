package com.example.application.event;

import com.example.application.model.QueryParam;
import com.example.application.views.queries.QueryForm;

public class QueryFormSaveEvent extends QueryFormEvent{
    public QueryFormSaveEvent(QueryForm source, QueryParam queryParam) {
        super(source, queryParam);
    }
}

package com.example.application.model;

public class QueryParam {
    private String index;
    private String query;
    private String output;

    public QueryParam() {
    }
    // Index:
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }

    // Topic:
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                ", query='" + query + '\'' +
                '}';
    }
}

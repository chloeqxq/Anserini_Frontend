package com.example.application.bindObject;

public class QueryParam {
    private String index;
    private String topics;
    private String topicReader;
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
    public String getTopics() {
        return topics;
    }
    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getTopicReader() {
        return topicReader;
    }

    public void setTopicReader(String topicReader) {
        this.topicReader = topicReader;
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
                ", topics='" + topics + '\'' +
                '}';
    }
}

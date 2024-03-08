package com.example.application.bindObject;

public class QueryParam {
    private String index;
    private String topics;
    private String topicReader;
    private String output;
    private String format;
    private String parallelism;
    private String k1;
    private String b;
    private String hits;

    public QueryParam() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getParallelism() {
        return parallelism;
    }

    public void setParallelism(String parallelism) {
        this.parallelism = parallelism;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "index='" + index + '\'' +
                ", topics='" + topics + '\'' +
                ", topicReader='" + topicReader + '\'' +
                ", output='" + output + '\'' +
                ", format='" + format + '\'' +
                ", parallelism='" + parallelism + '\'' +
                ", k1='" + k1 + '\'' +
                ", b='" + b + '\'' +
                ", hits='" + hits + '\'' +
                '}';
    }
}

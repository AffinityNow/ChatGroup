package com.affinitynow.user;

import java.util.Map;

public class User {
    private String userName;
    private Map<String, Topic> topics;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", topics=" + topics +
                '}';
    }
}

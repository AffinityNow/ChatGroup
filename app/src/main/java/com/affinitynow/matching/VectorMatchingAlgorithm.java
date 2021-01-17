package com.affinitynow.matching;

import com.affinitynow.user.Topic;
import com.affinitynow.user.User;

import java.util.List;
import java.util.Set;

public class VectorMatchingAlgorithm implements MatchingAlgorithm {
    private Integer[][] matrix;
    private Set<Topic> topics;
    private List<User> users;

    public VectorMatchingAlgorithm(Set<Topic> topics, List<User> users) {
        this.matrix = new Integer[10][10];
        this.topics = topics;
        this.users = users;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public void setMatrix() {
        for (int i = 0; i < users.size() ; i++) {
            for (int j = 0; j < topics.size(); j++) {
                if(users.get(i).getTopics().containsValue(j))
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    @Override
    public boolean match(User user1, User user2) {
        return false;
    }
}

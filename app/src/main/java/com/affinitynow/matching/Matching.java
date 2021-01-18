package com.affinitynow.matching;

import com.affinitynow.user.Topic;
import com.affinitynow.user.User;

import java.util.Map;

public class Matching {

    public boolean match(User user1, User user2) {
        for (Topic topic: user1.getTopics().values()) {
            for (Topic topic2: user2.getTopics().values()) {
                if (topic.equals(topic2))
                    System.out.println(String.format("The matching topic : %s", topic));
                    return true;
            }
        }
        return false;
    }
}

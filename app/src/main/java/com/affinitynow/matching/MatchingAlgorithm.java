package com.affinitynow.matching;

import com.affinitynow.user.User;

public interface MatchingAlgorithm {
    boolean match(User user1, User user2);
}

package com.affinitynow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.affinitynow.matching.Matching;
import com.affinitynow.user.Topic;
import com.affinitynow.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchActivity extends AppCompatActivity {
    private List<User> users = new ArrayList<>();
    
    public static void start(Context context) {
        Intent starter = new Intent(context, MatchActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        User u1 = new User("Toto");
        User u2 = new User("Chakir");
        User u3 = new User("Avi");
        User u4 = new User("Jean-Michel");
        User u5 = new User("Titi");
        User u6 = new User("Tata");
        User u7 = new User("Tutu");
        User u8 = new User("Jean");
        User u9 = new User("Michel");
        User u10 = new User("Tyty");

        users.add(u2);
        users.add(u3);
        users.add(u5);
        users.add(u6);
        users.add(u7);
        users.add(u8);
        users.add(u9);
        users.add(u10);

        Topic t1 = new Topic("Tennis");
        Topic t2 = new Topic("FOOT");
        Topic t3 = new Topic("IT");
        Topic t4 = new Topic("Cuisine");

        Map<String, Topic> topics1 = new HashMap<>();
        Map<String, Topic> topics2 = new HashMap<>();
        Map<String, Topic> topics3 = new HashMap<>();
        Map<String, Topic> topics4 = new HashMap<>();

        topics1.put("Tennis", t1);
        topics1.put("FOOT", t2);
        topics1.put("IT", t3);
        topics1.put("Cuisine", t4);

        topics2.put("Tennis", t1);
        topics2.put("FOOT", t2);
        topics2.put("Cuisine", t4);

        topics3.put("Tennis", t1);
        topics3.put("Cuisine", t4);

        topics4.put("IT", t3);
        topics4.put("Cuisine", t4);

        u1.setTopics(topics1);
        u2.setTopics(topics2);
        u3.setTopics(topics3);
        u4.setTopics(topics4);
        u5.setTopics(topics1);
        u6.setTopics(topics2);
        u7.setTopics(topics3);
        u8.setTopics(topics4);
        u9.setTopics(topics4);
        u10.setTopics(topics4);

        Matching matching = new Matching();

        for (User user: users) {
            if(matching.match(u1, user))
                System.out.println(String.format("%s match with %s ", u1.getUserName(), user.getUserName()));
        }
    }
}

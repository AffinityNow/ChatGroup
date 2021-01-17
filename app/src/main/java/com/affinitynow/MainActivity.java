package com.affinitynow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.affinitynow.utils.Constants;
import com.cometchat.pro.core.AppSettings;
import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText usernameEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCometChat();

        usernameEditText = findViewById(R.id.usernameEditText);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> attemptLogin());
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(usernameEditText.getText())) {
            usernameEditText.setError(getString(R.string.required_field_empty));
            return;
        }

        loginWithCometChat(usernameEditText.getText().toString());
    }

    private void loginWithCometChat(String username) {
        CometChat.login(username, Constants.COMET_CHAT_API_KEY, new CometChat.CallbackListener<User>() {
            @Override
            public void onSuccess(User user) {
                redirectToNextScreen();
            }
            @Override
            public void onError(CometChatException e) {
                Log.d(TAG, "Login failed with exception: " + e.getMessage());
            }
        });
    }

    private void redirectToNextScreen() {
        GroupListActivity.start(this);
    }

    private void initCometChat() {
        AppSettings appSettings=new AppSettings.AppSettingsBuilder().subscribePresenceForAllUsers().setRegion(Constants.region).build();
        CometChat.init(this, Constants.COMET_CHAT_APP_ID, appSettings ,new CometChat.CallbackListener<String>() {
            @Override
            public void onSuccess(String successMessage) {
                Log.d(TAG, "Initialization completed successfully");
            }

            @Override
            public void onError(CometChatException e) {
                Log.d(TAG, "Initialization failed with exception: " + e.getMessage());
            }
        });
    }
}
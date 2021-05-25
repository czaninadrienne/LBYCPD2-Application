package com.app.Kawani;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebasePushNotifications extends FirebaseMessagingService {

    private static final String TAG = FirebasePushNotifications.class.getSimpleName();

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        Log.d(TAG,"Token :"+token);
    }

}

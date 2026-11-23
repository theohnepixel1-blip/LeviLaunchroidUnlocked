package org.levimc.launcher.core.news;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.messaging.FirebaseMessaging;

import org.levimc.launcher.R;
import org.levimc.launcher.ui.activities.NewsActivity;

public final class NewsNotificationHelper {
    public static final String TOPIC = "levilauncher-news";
    public static final String CHANNEL_ID = "launcher_news";

    private NewsNotificationHelper() {
    }

    public static void initialize(Context context) {
        try {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(TOPIC);
        } catch (Exception ignored) {
        }
    }

    public static void show(Context context, String id, String title, String body, String url) {
    }

    private static void createChannel(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return;
        NotificationManager manager = context.getSystemService(NotificationManager.class);
        if (manager == null) return;
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.news_notification_channel),
                NotificationManager.IMPORTANCE_HIGH
        );
        channel.setDescription(context.getString(R.string.news_notification_channel_description));
        manager.createNotificationChannel(channel);
    }
}

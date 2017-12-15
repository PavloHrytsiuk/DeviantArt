package org.hrytsiuk.deviantart.core.pictures;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public final class PicturePref {
    private SharedPreferences preferences;
    private final Context context;

    public PicturePref(Context context) {
        this.context = context;
    }

    public void saveStringData(@NonNull final String data, @NonNull final String name) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor shEd = preferences.edit();
        shEd.putString(name, data);
        shEd.apply();
    }

    public String loadStringData(@NonNull final String name) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(name, "");
    }

    public void deleteStringData(@NonNull final String name) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().remove(name).apply();
    }
}

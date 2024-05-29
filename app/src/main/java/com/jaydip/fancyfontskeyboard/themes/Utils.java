package com.jaydip.fancyfontskeyboard.themes;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.jaydip.fancyfontskeyboard.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    static AlertDialog alertDialog;

    public static ArrayList<String> getFromAssets(Context context, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = new String[0];
        try {
            strArr = context.getAssets().list(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        arrayList.addAll(Arrays.asList(strArr));
        return arrayList;
    }

    public static void maxNativeSize(Context context, RelativeLayout relativeLayout) {
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(dpToPixel(context, 300), dpToPixel(context, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)));
    }

    public static int dpToPixel(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AlertDialog loadingPopup(Context context) {
        alertDialog = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_loader, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        alertDialog = create;
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return alertDialog;
    }
}

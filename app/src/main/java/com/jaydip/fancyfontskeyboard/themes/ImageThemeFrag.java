package com.jaydip.fancyfontskeyboard.themes;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.adapters.ImageThemeAdapter;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.List;

public class ImageThemeFrag extends Fragment {
    ImageView dummyBgIV;
    CardView dummyLayout;
    GridLayoutManager gridLayoutManager;
    ImageThemeAdapter imageThemeAdapter;
    RecyclerView imageThemeRV;

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_gradient_theme, viewGroup, false);
        this.imageThemeRV = (RecyclerView) inflate.findViewById(R.id.gradientThemeRV);
        this.dummyLayout = (CardView) inflate.findViewById(R.id.dummyLayout);
        this.dummyBgIV = (ImageView) inflate.findViewById(R.id.dummyBgIV);
        new getThemeAsync().execute(new Void[0]);
        return inflate;
    }

    public class getThemeAsync extends AsyncTask<Void, Void, Void> {
        AlertDialog alertDialog;
        List<String> list;

        public getThemeAsync() {
        }


        public void onPreExecute() {
            super.onPreExecute();
            AlertDialog loadingPopup = Utils.loadingPopup(ImageThemeFrag.this.getActivity());
            this.alertDialog = loadingPopup;
            loadingPopup.show();
            ImageThemeFrag.this.imageThemeRV.setVisibility(View.GONE);
            ImageThemeFrag.this.setDemoKeyboard();
        }


        public Void doInBackground(Void... voidArr) {
            this.list = Utils.getFromAssets(ImageThemeFrag.this.getActivity(), "bg_images");
            return null;
        }


        public void onPostExecute(Void r6) {
            super.onPostExecute((Void) r6);
            ImageThemeFrag.this.gridLayoutManager = new GridLayoutManager(ImageThemeFrag.this.getActivity(), 2);
            ImageThemeFrag.this.imageThemeRV.setLayoutManager(ImageThemeFrag.this.gridLayoutManager);
            ImageThemeFrag.this.imageThemeRV.setItemAnimator(new DefaultItemAnimator());
            ImageThemeFrag.this.imageThemeAdapter = new ImageThemeAdapter(this.list, ImageThemeFrag.this.getActivity(), "bg_images", new ImageThemeAdapter.ImageInterface() {
                @Override
                public void OnClick(String str) {
                    PreferenceManager.getInstance().putString("THEME", str);
                    ImageThemeFrag.this.imageThemeAdapter.notifyDataSetChanged();
                    ImageThemeFrag.this.setDemoKeyboard();
                }
            });
            ImageThemeFrag.this.imageThemeRV.setAdapter(ImageThemeFrag.this.imageThemeAdapter);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    ImageThemeFrag.this.imageThemeRV.setVisibility(View.VISIBLE);
                }
            }, 1000);
        }

    }

    public void setDemoKeyboard() {
        this.dummyLayout.setVisibility(View.VISIBLE);
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (string.contains("THEME") || !string.contains("bg_images")) {
            this.dummyLayout.setVisibility(View.GONE);
        } else {
            Glide.with(getActivity()).load(Uri.parse(string)).into(this.dummyBgIV);
        }
    }
}

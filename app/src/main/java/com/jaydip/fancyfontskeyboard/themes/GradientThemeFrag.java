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
import com.jaydip.fancyfontskeyboard.adapters.GradientThemeAdapter;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.List;

public class GradientThemeFrag extends Fragment {
    ImageView dummyBgIV;
    CardView dummyLayout;
    GradientThemeAdapter gradientAdapter;
    RecyclerView gradientThemeRV;
    GridLayoutManager gridLayoutManager;

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_gradient_theme, viewGroup, false);
        this.gradientThemeRV = (RecyclerView) inflate.findViewById(R.id.gradientThemeRV);
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
            AlertDialog loadingPopup = Utils.loadingPopup(GradientThemeFrag.this.getActivity());
            this.alertDialog = loadingPopup;
            loadingPopup.show();
            GradientThemeFrag.this.gradientThemeRV.setVisibility(View.GONE);
            GradientThemeFrag.this.setDemoKeyboard();
        }


        public Void doInBackground(Void... voidArr) {
            this.list = Utils.getFromAssets(GradientThemeFrag.this.getActivity(), "gradient");
            return null;
        }


        public void onPostExecute(Void r6) {
            super.onPostExecute((Void) r6);
            GradientThemeFrag.this.gridLayoutManager = new GridLayoutManager(GradientThemeFrag.this.getActivity(), 3);
            GradientThemeFrag.this.gradientThemeRV.setLayoutManager(GradientThemeFrag.this.gridLayoutManager);
            GradientThemeFrag.this.gradientThemeRV.setItemAnimator(new DefaultItemAnimator());
            GradientThemeFrag.this.gradientAdapter = new GradientThemeAdapter(this.list, GradientThemeFrag.this.getActivity(), "gradient", new GradientThemeAdapter.GradientInterface() {
                @Override
                public void OnClick(String str) {
                    PreferenceManager.getInstance().putString("THEME", str);
                    GradientThemeFrag.this.gradientAdapter.notifyDataSetChanged();
                    GradientThemeFrag.this.setDemoKeyboard();
                }
            });
            GradientThemeFrag.this.gradientThemeRV.setAdapter(GradientThemeFrag.this.gradientAdapter);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    GradientThemeFrag.this.gradientThemeRV.setVisibility(View.VISIBLE);
                }
            }, 1000);
        }

    }

    public void setDemoKeyboard() {
        this.dummyLayout.setVisibility(View.VISIBLE);
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (string.contains("THEME") || !string.contains("gradient")) {
            this.dummyLayout.setVisibility(View.GONE);
        } else {
            Glide.with(getActivity()).load(Uri.parse(string)).into(this.dummyBgIV);
        }
    }
}

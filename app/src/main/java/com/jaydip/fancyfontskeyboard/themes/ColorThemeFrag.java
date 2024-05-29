package com.jaydip.fancyfontskeyboard.themes;

import android.app.AlertDialog;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.adapters.ColorThemeAdapter;
import com.jaydip.fancyfontskeyboard.util.FancyFontModel;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.ArrayList;
import java.util.List;

public class ColorThemeFrag extends Fragment {
    ColorThemeAdapter colorThemeAdapter;
    RecyclerView colorThemeRV;
    ImageView dummyBgIV;
    ImageView dummyKeyIV;
    CardView dummyLayout;
    GridLayoutManager gridLayoutManager;

    @Override 
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_color_theme, viewGroup, false);
        this.colorThemeRV = (RecyclerView) inflate.findViewById(R.id.gradientThemeRV);
        this.dummyLayout = (CardView) inflate.findViewById(R.id.dummyLayout);
        this.dummyBgIV = (ImageView) inflate.findViewById(R.id.dummyBgIV);
        this.dummyKeyIV = (ImageView) inflate.findViewById(R.id.dummyKeyIV);
        new getThemeAsync().execute(new Void[0]);
        return inflate;
    }

    public class getThemeAsync extends AsyncTask<Void, Void, Void> {
        AlertDialog alertDialog;
        List<FancyFontModel> fancyFontModels;

        public getThemeAsync() {
        }


        public void onPreExecute() {
            super.onPreExecute();
            AlertDialog loadingPopup = Utils.loadingPopup(ColorThemeFrag.this.getActivity());
            this.alertDialog = loadingPopup;
            loadingPopup.show();
            ColorThemeFrag.this.colorThemeRV.setVisibility(View.GONE);
            ColorThemeFrag.this.setDemoKeyboard();
        }


        public Void doInBackground(Void... voidArr) {
            this.fancyFontModels = ColorThemeFrag.this.getColorThemes();
            return null;
        }


        public void onPostExecute(Void r5) {
            super.onPostExecute((Void) r5);
            ColorThemeFrag.this.gridLayoutManager = new GridLayoutManager(ColorThemeFrag.this.getActivity(), 3);
            ColorThemeFrag.this.colorThemeRV.setLayoutManager(ColorThemeFrag.this.gridLayoutManager);
            ColorThemeFrag.this.colorThemeRV.setItemAnimator(new DefaultItemAnimator());
            ColorThemeFrag.this.colorThemeAdapter = new ColorThemeAdapter(ColorThemeFrag.this.getActivity(), this.fancyFontModels, new ColorThemeAdapter.ColorInterface() {
                @Override
                public void OnClick(FancyFontModel fancyFontModel) {
                    PreferenceManager.getInstance().putString("THEME", fancyFontModel.getThemeName());
                    ColorThemeFrag.this.colorThemeAdapter.notifyDataSetChanged();
                    ColorThemeFrag.this.setDemoKeyboard();
                }
            });
            ColorThemeFrag.this.colorThemeRV.setAdapter(ColorThemeFrag.this.colorThemeAdapter);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    ColorThemeFrag.this.colorThemeRV.setVisibility(View.VISIBLE);
                }
            }, 1000);
        }
        

    }

    public void setDemoKeyboard() {
        this.dummyLayout.setVisibility(View.VISIBLE);
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (string.equals("THEME1")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_1));
            setBtnColor(R.color.key_background_normal_1);
        } else if (string.equals("THEME2")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_2));
            setBtnColor(R.color.key_background_normal_2);
        } else if (string.equals("THEME3")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_3));
            setBtnColor(R.color.key_background_normal_3);
        } else if (string.equals("THEME4")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_4));
            setBtnColor(R.color.key_background_normal_4);
        } else if (string.equals("THEME5")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_5));
            setBtnColor(R.color.key_background_normal_5);
        } else if (string.equals("THEME6")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_6));
            setBtnColor(R.color.key_background_normal_6);
        } else if (string.equals("THEME7")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_7));
            setBtnColor(R.color.key_background_normal_7);
        } else if (string.equals("THEME8")) {
            this.dummyBgIV.setBackgroundColor(getResources().getColor(R.color.keyboard_background_8));
            setBtnColor(R.color.key_background_normal_8);
        } else {
            this.dummyLayout.setVisibility(View.GONE);
        }
    }

    public List<FancyFontModel> getColorThemes() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FancyFontModel(R.color.keyboard_background_1, "THEME1"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_2, "THEME2"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_3, "THEME3"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_4, "THEME4"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_5, "THEME5"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_6, "THEME6"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_7, "THEME7"));
        arrayList.add(new FancyFontModel(R.color.keyboard_background_8, "THEME8"));
        return arrayList;
    }

    public void setBtnColor(int i) {
        this.dummyKeyIV.setColorFilter(ContextCompat.getColor(getContext(), i), PorterDuff.Mode.MULTIPLY);
    }
}

package com.jaydip.fancyfontskeyboard.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.List;

public class GradientThemeAdapter extends RecyclerView.Adapter<GradientThemeAdapter.ImageHolder> {
    List<String> categoryList;
    Context context;
    String folder;
    public GradientInterface gradientInterface;

    public interface GradientInterface {
        void OnClick(String str);
    }

    public GradientThemeAdapter(List<String> list, Context context2, String str, GradientInterface gradientInterface2) {
        this.categoryList = list;
        this.context = context2;
        this.folder = str;
        this.gradientInterface = gradientInterface2;
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        RelativeLayout addLay;
        CardView cardView;
        ImageView gradientIV;

        public ImageHolder(View view) {
            super(view);
            this.gradientIV = (ImageView) view.findViewById(R.id.gradientIV);
            this.cardView = (CardView) view.findViewById(R.id.cardView);
            this.addLay = (RelativeLayout) view.findViewById(R.id.addLay);
        }
    }

    @Override 
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gradient_list_row, viewGroup, false));
    }

    public void onBindViewHolder(ImageHolder imageHolder, int i) {
        RequestManager with = Glide.with(this.context);
        with.load(Uri.parse("file:///android_asset/" + this.folder + "/" + this.categoryList.get(i))).into(imageHolder.gradientIV);
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (string.equals("file:///android_asset/" + this.folder + "/" + this.categoryList.get(i))) {
            imageHolder.addLay.setVisibility(View.VISIBLE);
        } else {
            imageHolder.addLay.setVisibility(View.GONE);
        }
        imageHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GradientInterface gradientInterface2 = gradientInterface;
                gradientInterface2.OnClick("file:///android_asset/" + folder + "/" + categoryList.get(i));
            }
        });
    }


    @Override 
    public int getItemCount() {
        return this.categoryList.size();
    }
}

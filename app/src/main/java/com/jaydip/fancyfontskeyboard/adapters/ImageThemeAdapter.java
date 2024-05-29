package com.jaydip.fancyfontskeyboard.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.List;

public class ImageThemeAdapter extends RecyclerView.Adapter<ImageThemeAdapter.ImageHolder> {
    Context context;
    String folder;
    public ImageInterface imageInterface;
    List<String> imageList;

    public interface ImageInterface {
        void OnClick(String str);
    }

    public ImageThemeAdapter(List<String> list, Context context2, String str, ImageInterface imageInterface2) {
        this.imageList = list;
        this.context = context2;
        this.folder = str;
        this.imageInterface = imageInterface2;
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {
        RelativeLayout addLay;
        ImageView gradientIV;

        public ImageHolder(View view) {
            super(view);
            this.gradientIV = (ImageView) view.findViewById(R.id.gradientIV);
            this.addLay = (RelativeLayout) view.findViewById(R.id.addLay);
        }
    }

    @Override 
    public ImageHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_list_row, viewGroup, false));
    }

    public void onBindViewHolder(ImageHolder imageHolder, int i) {
        RequestManager with = Glide.with(this.context);
        with.load(Uri.parse("file:///android_asset/" + this.folder + "/" + this.imageList.get(i))).into(imageHolder.gradientIV);
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (string.equals("file:///android_asset/" + this.folder + "/" + this.imageList.get(i))) {
            imageHolder.addLay.setVisibility(View.VISIBLE);
        } else {
            imageHolder.addLay.setVisibility(View.GONE);
        }
        imageHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageInterface imageInterface2 = imageInterface;
                imageInterface2.OnClick("file:///android_asset/" + folder + "/" + imageList.get(i));
            }
        });
    }


    @Override 
    public int getItemCount() {
        return this.imageList.size();
    }
}

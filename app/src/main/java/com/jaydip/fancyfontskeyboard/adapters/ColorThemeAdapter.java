package com.jaydip.fancyfontskeyboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.util.FancyFontModel;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import java.util.List;

public class ColorThemeAdapter extends RecyclerView.Adapter<ColorThemeAdapter.MyViewHolder> {
    public ColorInterface colorInterface;
    private Context context;
    private List<FancyFontModel> themeList;

    public interface ColorInterface {
        void OnClick(FancyFontModel fancyFontModel);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout addLay;
        public FrameLayout backgroundColor;

        public MyViewHolder(View view) {
            super(view);
            this.backgroundColor = (FrameLayout) view.findViewById(R.id.background_color);
            this.addLay = (RelativeLayout) view.findViewById(R.id.addLay);
        }
    }

    public ColorThemeAdapter(Context context2, List<FancyFontModel> list, ColorInterface colorInterface2) {
        this.context = context2;
        this.themeList = list;
        this.colorInterface = colorInterface2;
    }

    @Override 
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.theme_list_row, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        FancyFontModel fancyFontModel = this.themeList.get(i);
        myViewHolder.backgroundColor.setBackgroundColor(this.context.getResources().getColor(fancyFontModel.getBackgroundColor()));
        if (PreferenceManager.getInstance().getString("THEME", "THEME1").equals(fancyFontModel.getThemeName())) {
            myViewHolder.addLay.setVisibility(View.VISIBLE);
        } else {
            myViewHolder.addLay.setVisibility(View.GONE);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorInterface.OnClick(fancyFontModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.themeList.size();
    }
}

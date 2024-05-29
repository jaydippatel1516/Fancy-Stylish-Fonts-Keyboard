package com.jaydip.fancyfontskeyboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;
import com.jaydip.fancyfontskeyboard.service.FancyFontManager;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji10;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji11;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji12;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji2;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji3;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji4;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji5;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji6;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji7;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji8;
import com.jaydip.fancyfontskeyboard.signmojibunch.SignMoji9;
import com.jaydip.fancyfontskeyboard.util.KeyDataHolder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SignMojiAdapter extends RecyclerView.Adapter<SignMojiAdapter.Holder> {
    List<FancyInterface> interfaceList;
    KeyDataHolder keyDataHolder;
    OnFontInstall onFontInstall;

    public interface OnFontInstall {
        void onFontInstall(String str);
    }

    public SignMojiAdapter(Context context, OnFontInstall onFontInstall2) {
        LinkedList linkedList = new LinkedList(Arrays.asList(FancyFontManager.INSTANCE.getFontOrder()));
        this.interfaceList = linkedList;
        Collections.shuffle(linkedList);
        this.onFontInstall = onFontInstall2;
        this.keyDataHolder = new KeyDataHolder(context);
        Iterator it = new LinkedList(Arrays.asList(FancyFontManager.INSTANCE.getFontOrder())).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!(next instanceof SignMoji) && !(next instanceof SignMoji4) && !(next instanceof SignMoji5) && !(next instanceof SignMoji6) && !(next instanceof SignMoji7) && !(next instanceof SignMoji8) && !(next instanceof SignMoji9) && !(next instanceof SignMoji2) && !(next instanceof SignMoji10) && !(next instanceof SignMoji11) && !(next instanceof SignMoji12) && !(next instanceof SignMoji3)) {
                this.interfaceList.remove(next);
            }
        }
    }

    @Override 
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item_fancy_fonts, viewGroup, false));
    }

    public void onBindViewHolder(Holder holder, int i) {
        holder.fontTV.setText(this.interfaceList.get(i).getTest());
        KeyDataHolder keyDataHolder2 = this.keyDataHolder;
        if (keyDataHolder2.getBoolean("font_" + this.interfaceList.get(i).getClass().getCanonicalName())) {
            holder.addLay.setVisibility(View.GONE);
            holder.doneIV.setVisibility(View.VISIBLE);
        } else {
            holder.addLay.setVisibility(View.VISIBLE);
            holder.doneIV.setVisibility(View.GONE);
        }
        holder.addLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFontInstall.onFontInstall(interfaceList.get(i).getClass().getCanonicalName());
            }
        });
    }


    @Override 
    public int getItemCount() {
        return this.interfaceList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public RelativeLayout addLay;
        public ImageView doneIV;
        public TextView fontTV;

        public Holder(View view) {
            super(view);
            this.fontTV = (TextView) view.findViewById(R.id.fontTV);
            this.doneIV = (ImageView) view.findViewById(R.id.doneIV);
            this.addLay = (RelativeLayout) view.findViewById(R.id.addLay);
        }
    }
}

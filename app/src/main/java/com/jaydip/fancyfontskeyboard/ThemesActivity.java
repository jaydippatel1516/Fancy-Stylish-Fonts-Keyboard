package com.jaydip.fancyfontskeyboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.jaydip.fancyfontskeyboard.themes.ColorThemeFrag;
import com.jaydip.fancyfontskeyboard.themes.GradientThemeFrag;
import com.jaydip.fancyfontskeyboard.themes.ImageThemeFrag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ThemesActivity extends AppCompatActivity {
    ImageView backIV;
    String[] fragNames = {"Colors", "Gradients", "Images"};
    TabLayout tabLayout;
    ViewPager viewPager;

    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_themes);
        backIV = (ImageView) findViewById(R.id.backIV);
        backIV.setOnClickListener(v -> onBackPressed());
        viewPager= (ViewPager) findViewById(R.id.pagerTheme);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.theme_tabLay);
        tabLayout.setupWithViewPager(this.viewPager);
        for (int i = 0; i < this.tabLayout.getTabCount(); i++) {
            this.tabLayout.getTabAt(i).setCustomView(getTabViewUn(i));
        }
        setupTabIcons();
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ThemesActivity.this.viewPager.setCurrentItem(tab.getPosition());
                TabLayout.Tab tabAt = ThemesActivity.this.tabLayout.getTabAt(tab.getPosition());
                tabAt.setCustomView((View) null);
                tabAt.setCustomView(ThemesActivity.this.getTabView(tab.getPosition()));
                if (tab.getPosition() == 0) {
                    FragmentManager supportFragmentManager = ThemesActivity.this.getSupportFragmentManager();
                    ColorThemeFrag colorThemeFrag = (ColorThemeFrag) supportFragmentManager.findFragmentByTag("android:switcher:" + ThemesActivity.this.viewPager.getId() + ":" + tab.getPosition());
                    Objects.requireNonNull(colorThemeFrag);
//                    new ColorThemeFrag.getThemeAsync().execute(new Void[0]);
                } else if (tab.getPosition() == 1) {
                    FragmentManager supportFragmentManager2 = ThemesActivity.this.getSupportFragmentManager();
                    GradientThemeFrag gradientThemeFrag = (GradientThemeFrag) supportFragmentManager2.findFragmentByTag("android:switcher:" + ThemesActivity.this.viewPager.getId() + ":" + tab.getPosition());
                    Objects.requireNonNull(gradientThemeFrag);
//                    new GradientThemeFrag.getThemeAsync().execute(new Void[0]);
                } else {
                    FragmentManager supportFragmentManager3 = ThemesActivity.this.getSupportFragmentManager();
                    ImageThemeFrag imageThemeFrag = (ImageThemeFrag) supportFragmentManager3.findFragmentByTag("android:switcher:" + ThemesActivity.this.viewPager.getId() + ":" + tab.getPosition());
                    Objects.requireNonNull(imageThemeFrag);
//                    new ImageThemeFrag.getThemeAsync().execute(new Void[0]);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TabLayout.Tab tabAt = ThemesActivity.this.tabLayout.getTabAt(tab.getPosition());
                tabAt.setCustomView((View) null);
                tabAt.setCustomView(ThemesActivity.this.getTabViewUn(tab.getPosition()));
            }
        });
    }


    private void setupTabIcons() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.custom_tab, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabTV)).setText(this.fragNames[0]);
        TabLayout.Tab tabAt = this.tabLayout.getTabAt(0);
        tabAt.setCustomView((View) null);
        tabAt.setCustomView(inflate);
    }

    public View getTabView(int i) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.custom_tab, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabTV)).setText(this.fragNames[i]);
        ((ImageView) inflate.findViewById(R.id.tabIV)).setVisibility(View.VISIBLE);
        return inflate;
    }

    public View getTabViewUn(int i) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.custom_tab, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabTV)).setText(this.fragNames[i]);
        ((ImageView) inflate.findViewById(R.id.tabIV)).setVisibility(4);
        return inflate;
    }

    private void setupViewPager(ViewPager viewPager2) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ColorThemeFrag(), "Color Themes");
        viewPagerAdapter.addFragment(new GradientThemeFrag(), "Categories");
        viewPagerAdapter.addFragment(new ImageThemeFrag(), "Download");
        viewPager2.setAdapter(viewPagerAdapter);
    }

    
    public static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }
}

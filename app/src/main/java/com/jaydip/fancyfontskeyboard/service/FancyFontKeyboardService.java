package com.jaydip.fancyfontskeyboard.service;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import com.bumptech.glide.Glide;
import com.jaydip.fancyfontskeyboard.R;
import com.jaydip.fancyfontskeyboard.SplashActivity;
import com.jaydip.fancyfontskeyboard.effect.Attention;
import com.jaydip.fancyfontskeyboard.effect.Renderr;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.DefaultStyle;
import com.jaydip.fancyfontskeyboard.fancyfontsbunch.FancyInterface;
import com.jaydip.fancyfontskeyboard.util.FancyFontsKeyboard;
import com.jaydip.fancyfontskeyboard.util.FancyFontsKeyboardView;
import com.jaydip.fancyfontskeyboard.util.KeyDataHolder;
import com.jaydip.fancyfontskeyboard.util.KeyboardSupport;
import com.jaydip.fancyfontskeyboard.util.PreferenceManager;
import com.jaydip.fancyfontskeyboard.util.SharedPreferenceProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public final class FancyFontKeyboardService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private Keyboard activeKeyboard;
    ImageView closeMenu;
    private ConstraintLayout constraintKeyboardLayout;
    public FancyFontsKeyboard defaultFontsKeyboardStylish;
    public FancyFontsKeyboard fancyFontsKeyboard;
    LinearLayout home;
    private ArrayList<Pair<FancyInterface, Button>> horiKeyFonts = new ArrayList<>();
    private HorizontalScrollView horizontalScrollView;
    private InputMethodManager inputMethodManager;
    private boolean isUpperCase;
    KeyDataHolder keyDataHolder;
    public FancyFontsKeyboardView keyboardView;
    RelativeLayout keyboard_menu;
    private long lastShiftTime;
    ImageView menuButton;
    LinearLayout rate;
    LinearLayout share;
    public SharedPreferenceProvider sharedPreferenceProvider;
    private Keyboard symbolsKeyboard;
    private Keyboard symbolsShiftedKeyboard;
    private String wordSeparators;

    public void onPress(int i) {
    }

    public void onRelease(int i) {
    }

    public void swipeDown() {
    }

    public void swipeLeft() {
    }

    public void swipeRight() {
    }

    public void swipeUp() {
    }

    public void onCreate() {
        super.onCreate();
        FancyFontManager.INSTANCE.setContext(this);
        this.wordSeparators = getResources().getString(R.string.word_separators);
        this.sharedPreferenceProvider = new SharedPreferenceProvider(this);
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            this.inputMethodManager = (InputMethodManager) systemService;
            super.onCreate();
            return;
        }
        throw new ClassCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public void onStartInputView(EditorInfo editorInfo, boolean z) {
        super.onStartInputView(editorInfo, z);
        Log.e("setActiveKeyboard: ", "keyboard open");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private final void initializeKeyboard() {
        View view;
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        if (!string.contains("THEME")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_bggrad, (ViewGroup) null);
        } else if (string.equals("THEME1")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_def, (ViewGroup) null);
        } else if (string.equals("THEME2")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_1, (ViewGroup) null);
        } else if (string.equals("THEME3")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_2, (ViewGroup) null);
        } else if (string.equals("THEME4")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_3, (ViewGroup) null);
        } else if (string.equals("THEME5")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_4, (ViewGroup) null);
        } else if (string.equals("THEME6")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_5, (ViewGroup) null);
        } else if (string.equals("THEME7")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_6, (ViewGroup) null);
        } else if (string.equals("THEME8")) {
            view = getLayoutInflater().inflate(R.layout.keyboard_lay_7, (ViewGroup) null);
        } else {
            view = getLayoutInflater().inflate(R.layout.keyboard_def, (ViewGroup) null);
        }
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            this.constraintKeyboardLayout = constraintLayout;
            Objects.requireNonNull(constraintLayout);
            final FancyFontsKeyboardView fancyFontsKeyboardView = (FancyFontsKeyboardView) constraintLayout.findViewById(R.id.keyboard_view);
            this.keyboardView = fancyFontsKeyboardView;
            if (fancyFontsKeyboardView != null) {
                fancyFontsKeyboardView.setOnKeyboardActionListener(this);
            }
            FancyFontsKeyboardView fancyFontsKeyboardView2 = this.keyboardView;
            if (fancyFontsKeyboardView2 != null) {
                fancyFontsKeyboardView2.setPreviewEnabled(false);
            }
            final RelativeLayout relativeLayout = (RelativeLayout) constraintLayout.findViewById(R.id.container_keyboard_linear_layout);
            ImageView imageView = (ImageView) constraintLayout.findViewById(R.id.keyboardBG);
            fancyFontsKeyboardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < 16) {
                        fancyFontsKeyboardView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        fancyFontsKeyboardView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    int measuredHeight = fancyFontsKeyboardView.getMeasuredHeight();
                    relativeLayout.getLayoutParams().height = measuredHeight + KeyboardSupport.dpToPx(70, FancyFontKeyboardService.this);
                }
            });
            ConstraintLayout constraintLayout2 = this.constraintKeyboardLayout;
            Objects.requireNonNull(constraintLayout2);
            LinearLayout linearLayout = (LinearLayout) constraintLayout2.findViewById(R.id.fonts_tabs_linear_layout);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout3 = this.constraintKeyboardLayout;
                Objects.requireNonNull(constraintLayout3);
                this.horizontalScrollView = (HorizontalScrollView) constraintLayout3.findViewById(R.id.horizontal_scroll_view);
                if (!string.contains("THEME")) {
                    Glide.with(this).load(Uri.parse(string)).into(imageView);
                    this.horizontalScrollView.setBackgroundColor(0);
                }
                this.keyDataHolder = new KeyDataHolder(this);
                ImageView imageView2 = new ImageView(this);
                this.menuButton = imageView2;
                imageView2.setImageResource(R.drawable.k_icon);
                this.menuButton.setAdjustViewBounds(true);
                this.menuButton.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (Build.VERSION.SDK_INT >= 21) {
                    this.menuButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorKeyBackground)));
                }
                this.keyboard_menu =  constraintLayout.findViewById(R.id.keyboard_menu);
                this.menuButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Attention.Bounce(FancyFontKeyboardService.this, menuButton);
                        if (keyboard_menu.getVisibility() == 8) {
                            keyboard_menu.setVisibility(View.VISIBLE);
                            Renderr renderr = new Renderr(FancyFontKeyboardService.this);
                            renderr.setAnimation(Attention.In(home));
                            renderr.start();
                            Renderr renderr2 = new Renderr(FancyFontKeyboardService.this);
                            renderr2.setAnimation(Attention.In(rate));
                            renderr2.start();
                            Renderr renderr3 = new Renderr(FancyFontKeyboardService.this);
                            renderr3.setAnimation(Attention.In(share));
                            renderr3.start();
                            Renderr renderr5 = new Renderr(FancyFontKeyboardService.this);
                            renderr5.setAnimation(Attention.In(closeMenu));
                            renderr5.start();
                        }
                    }
                });
                home= (LinearLayout) constraintLayout.findViewById(R.id.home);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FancyFontKeyboardService.this, SplashActivity.class);
                        intent.setFlags(268435456);
                        startActivity(intent);
                        if (keyboard_menu.getVisibility() == 0) {
                            keyboard_menu.setVisibility(View.GONE);
                        }
                    }
                });
                rate =  constraintLayout.findViewById(R.id.rate);
                rate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
                            intent.setFlags(268435456);
                            startActivity(intent);
                        } catch (ActivityNotFoundException unused) {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                            intent2.setFlags(268435456);
                            startActivity(intent2);
                        }
                        if (keyboard_menu.getVisibility() == 0) {
                            keyboard_menu.setVisibility(View.GONE);
                        }
                    }
                });
                share = (LinearLayout) constraintLayout.findViewById(R.id.share);
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        InputConnection currentInputConnection = getCurrentInputConnection();
                        currentInputConnection.commitText("Hey my friend check out this amazing fancy font keyboard app\n: https://play.google.com/store/apps/details?id=" + getPackageName(), 1);
                        if (keyboard_menu.getVisibility() == 0) {
                            keyboard_menu.setVisibility(View.GONE);
                        }
                    }
                });
                closeMenu=  constraintLayout.findViewById(R.id.closeMenu);
                closeMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (keyboard_menu.getVisibility() == 0) {
                            keyboard_menu.setVisibility(View.GONE);
                        }
                    }
                });
                linearLayout.addView(this.menuButton);
                new Button(this).getTextSize();
                FancyInterface[] fontOrder = FancyFontManager.INSTANCE.getFontOrder();
                for (FancyInterface fancyInterface : fontOrder) {
                    if (this.keyDataHolder.getBoolean("font_" + fancyInterface.getClass().getCanonicalName())) {
                        View inflate = LayoutInflater.from(this).inflate(R.layout.lay_button, (ViewGroup) null);
                        Button button = (Button) inflate.findViewById(R.id.btn_font);
                        button.setAllCaps(false);
                        int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
                        button.setPadding(applyDimension, 0, applyDimension, (int) (((float) applyDimension) * fancyInterface.getExtraPaddingDownFactor()));
                        button.setTextSize(2, fancyInterface.getSizeFactorButton() * 16.0f);
                        button.setText(fancyInterface.getName());
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                view.setSelected(true);
                                if (fancyInterface instanceof DefaultStyle) {
                                    setActiveKeyboard(fancyFontsKeyboard);
                                } else if (sharedPreferenceProvider.getLanguage().equals("eng")) {
                                    setActiveKeyboard(fancyFontsKeyboard);
                                } else {
                                    setActiveKeyboard(defaultFontsKeyboardStylish);
                                }
                                setHorizontalKeyTheme(fancyInterface, true);
                                if (keyboardView != null) {
                                    keyboardView.invalidateAllKeys();
                                }
                            }
                        });
                        this.horiKeyFonts.add(new Pair<>(fancyInterface, button));
                        linearLayout.addView(inflate);
                    }
                }
                if (FancyFontManager.INSTANCE.getInitialFont() instanceof DefaultStyle) {
                    setActiveKeyboard(this.fancyFontsKeyboard);
                } else if (this.sharedPreferenceProvider.getLanguage().equals("eng")) {
                    setActiveKeyboard(this.fancyFontsKeyboard);
                } else {
                    setActiveKeyboard(this.defaultFontsKeyboardStylish);
                }
                setHorizontalKeyTheme(FancyFontManager.INSTANCE.getInitialFont(), false);
                return;
            }
            throw new ClassCastException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new ClassCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }


    public void onInitializeInterface() {
        super.onInitializeInterface();
        if (PreferenceManager.getInstance().getString("THEME", "THEME1").equals("THEME1")) {
            this.symbolsKeyboard = new Keyboard(this, R.xml.symbols);
            this.symbolsShiftedKeyboard = new Keyboard(this, R.xml.symbols_shift);
            return;
        }
        this.symbolsKeyboard = new Keyboard(this, R.xml.symbols_2);
        this.symbolsShiftedKeyboard = new Keyboard(this, R.xml.symbols_shift_2);
    }

    public View onCreateInputView() {
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        String language = this.sharedPreferenceProvider.getLanguage();
        if (((language.hashCode() != 100574 || !language.equals("eng")) ? 65535 : 0) == 0) {
            if (string.equals("THEME1")) {
                this.fancyFontsKeyboard = new FancyFontsKeyboard(this, R.xml.keyboard_layout);
                this.defaultFontsKeyboardStylish = new FancyFontsKeyboard(this, R.xml.keyboard_layout);
            } else {
                this.fancyFontsKeyboard = new FancyFontsKeyboard(this, R.xml.keyboard_layout_2);
                this.defaultFontsKeyboardStylish = new FancyFontsKeyboard(this, R.xml.keyboard_layout_2);
            }
        }
        initializeKeyboard();
        ConstraintLayout constraintLayout = this.constraintKeyboardLayout;
        Objects.requireNonNull(constraintLayout);
        return constraintLayout;
    }

    public final void setHorizontalKeyTheme(FancyInterface fancyInterface, boolean z) {
        Iterator<Pair<FancyInterface, Button>> it = this.horiKeyFonts.iterator();
        String string = PreferenceManager.getInstance().getString("THEME", "THEME1");
        while (it.hasNext()) {
            Pair<FancyInterface, Button> next = it.next();
            if (next.first.equals(fancyInterface)) {
                if (!string.contains("THEME")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.btn_black_hori_trans1));
                    next.second.setTextColor(getResources().getColor(R.color.white));
                } else if (string.equals("THEME1")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed1));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyText));
                } else if (string.equals("THEME2")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed2));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME3")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed3));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME4")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed4));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME5")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed5));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME6")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed6));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME7")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed7));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else if (string.equals("THEME8")) {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed8));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                } else {
                    next.second.setBackground(getResources().getDrawable(R.drawable.unpressed1));
                    next.second.setTextColor(getResources().getColor(R.color.colorKeyText));
                }
                HorizontalScrollView horizontalScrollView2 = this.horizontalScrollView;
                if (horizontalScrollView2 == null) {
                    throw new ExceptionInInitializerError("horizontalScrollView");
                } else if (horizontalScrollView2.getScrollX() <= next.second.getLeft() && this.horizontalScrollView.getScrollX() + this.horizontalScrollView.getWidth() < next.second.getRight()) {
                    if (z) {
                        next.second.getRight();
                    } else {
                        next.second.getRight();
                    }
                }
            } else if (!string.contains("THEME")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.btn_black_hori_trans));
                next.second.setTextColor(getResources().getColor(R.color.white));
            } else if (string.equals("THEME1")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected1));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyText));
            } else if (string.equals("THEME2")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected2));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME3")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected3));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME4")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected4));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME5")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected5));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME6")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected6));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME7")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected7));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else if (string.equals("THEME8")) {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected8));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
            } else {
                next.second.setBackground(getResources().getDrawable(R.drawable.selected1));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyText));
            }
        }
        FancyFontManager.INSTANCE.setCurrentFont(fancyInterface);
    }

    public void onKey(int i, int[] iArr) {
        FancyFontsKeyboard fancyFontsKeyboard2;
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            Log.d("test", "onKey " + i);
            if (i == -5) {
                handleBackspace();
            } else if (i == -1) {
                handleShift();
            } else if (i == -4) {
                currentInputConnection.sendKeyEvent(new KeyEvent(0, 66));
            } else if (i == -2) {
                FancyFontsKeyboardView fancyFontsKeyboardView = this.keyboardView;
                Keyboard keyboard = fancyFontsKeyboardView != null ? fancyFontsKeyboardView.getKeyboard() : null;
                if (keyboard == null || (!(keyboard == this.symbolsKeyboard || keyboard == this.symbolsShiftedKeyboard) || (fancyFontsKeyboard2 = this.fancyFontsKeyboard) == null)) {
                    Keyboard keyboard2 = this.symbolsKeyboard;
                    if (keyboard2 != null) {
                        keyboard2.setShifted(false);
                        setActiveKeyboard(this.symbolsKeyboard);
                        return;
                    }
                    return;
                }
                Objects.requireNonNull(fancyFontsKeyboard2);
                setActiveKeyboard(fancyFontsKeyboard2);
            } else if (i == 10) {
                keyDownUp(66);
            } else {
                if (this.isUpperCase || this.keyboardView.getKeyboard().isShifted()) {
                    currentInputConnection.commitText(String.valueOf((char) i).toUpperCase(), 1);
                } else {
                    currentInputConnection.commitText(String.valueOf((char) i), 1);
                }
                if (this.keyboardView.getKeyboard() == this.fancyFontsKeyboard) {
                    updateShiftKeyState(getCurrentInputEditorInfo());
                    this.keyboardView.invalidateAllKeys();
                }
                if (FancyFontManager.INSTANCE.getCurrentFont().isUpsideDown()) {
                    currentInputConnection.sendKeyEvent(new KeyEvent(0, 21));
                    currentInputConnection.sendKeyEvent(new KeyEvent(1, 21));
                }
                if (isWordSeparator(i)) {
                    updateShiftKeyState(getCurrentInputEditorInfo());
                }
            }
        }
    }

    public void onText(CharSequence charSequence) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.commitText(charSequence, 1);
            if (FancyFontManager.INSTANCE.getCurrentFont().isUpsideDown()) {
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, 21));
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, 21));
            }
            updateShiftKeyState(getCurrentInputEditorInfo());
        }
    }

    public final void setActiveKeyboard(Keyboard keyboard) {
        this.activeKeyboard = keyboard;
        FancyFontsKeyboardView fancyFontsKeyboardView = this.keyboardView;
        if (fancyFontsKeyboardView != null) {
            fancyFontsKeyboardView.setKeyboard(keyboard);
        }
    }

    private final void handleLanguageSwitch() {
        if (Build.VERSION.SDK_INT < 28 || !shouldOfferSwitchingToNextInputMethod()) {
            Log.e("handleLanguageSwitch: ", "28");
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            if (inputMethodManager2 == null) {
                throw new ExceptionInInitializerError("inputMethodManager");
            } else if (inputMethodManager2.shouldOfferSwitchingToNextInputMethod(getToken())) {
                this.inputMethodManager.switchToNextInputMethod(getToken(), false);
            }
        } else {
            Log.e("handleLanguageSwitch: ", "13");
        }
    }

    private final IBinder getToken() {
        Window window;
        Dialog window2 = getWindow();
        if (window2 == null || (window = window2.getWindow()) == null) {
            return null;
        }
        return window.getAttributes().token;
    }

    private final void handleBackspace() {
        if (FancyFontManager.INSTANCE.getCurrentFont().isUpsideDown()) {
            getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, 22));
            getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, 22));
        }
        keyDownUp(67);
        updateShiftKeyState(getCurrentInputEditorInfo());
    }

    private final void keyDownUp(int i) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, i));
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, i));
    }

    public final boolean isWordSeparator(int i) {
        String str = this.wordSeparators;
        if (str != null) {
            return str.contains(String.valueOf((char) i));
        }
        throw new ExceptionInInitializerError("wordSeparators");
    }

    private final void updateShiftKeyState(EditorInfo editorInfo) {
        FancyFontsKeyboard fancyFontsKeyboard2;
        FancyFontsKeyboardView fancyFontsKeyboardView;
        if (editorInfo != null && (fancyFontsKeyboard2 = this.defaultFontsKeyboardStylish) != null && (fancyFontsKeyboardView = this.keyboardView) != null) {
            boolean z = true;
            if (fancyFontsKeyboard2 == (fancyFontsKeyboardView != null ? fancyFontsKeyboardView.getKeyboard() : null)) {
                int cursorCapsMode = (getCurrentInputEditorInfo() == null || getCurrentInputEditorInfo().inputType == 0) ? 0 : getCurrentInputConnection().getCursorCapsMode(editorInfo.inputType);
                FancyFontsKeyboard fancyFontsKeyboard3 = this.defaultFontsKeyboardStylish;
                if (fancyFontsKeyboard3 != null) {
                    if (!this.isUpperCase && cursorCapsMode == 0) {
                        z = false;
                    }
                    fancyFontsKeyboard3.setShifted(z);
                }
            } else if (this.keyboardView.getKeyboard() == this.fancyFontsKeyboard) {
                int cursorCapsMode2 = (getCurrentInputEditorInfo() == null || getCurrentInputEditorInfo().inputType == 0) ? 0 : getCurrentInputConnection().getCursorCapsMode(editorInfo.inputType);
                FancyFontsKeyboard fancyFontsKeyboard4 = this.fancyFontsKeyboard;
                if (fancyFontsKeyboard4 != null) {
                    if (!this.isUpperCase && cursorCapsMode2 == 0) {
                        z = false;
                    }
                    fancyFontsKeyboard4.setShifted(z);
                }
            }
        }
    }

    private final void handleShift() {
        if (this.defaultFontsKeyboardStylish != null && this.symbolsKeyboard != null && this.symbolsShiftedKeyboard != null) {
            FancyFontsKeyboardView fancyFontsKeyboardView = this.keyboardView;
            Keyboard keyboard = null;
            boolean z = false;
            if ((fancyFontsKeyboardView != null ? fancyFontsKeyboardView.getKeyboard() : null) == this.defaultFontsKeyboardStylish) {
                checkToggleCapsLock();
                FancyFontsKeyboardView fancyFontsKeyboardView2 = this.keyboardView;
                if (fancyFontsKeyboardView2 != null) {
                    if (this.isUpperCase || fancyFontsKeyboardView2 == null || !fancyFontsKeyboardView2.isShifted()) {
                        z = true;
                    }
                    this.keyboardView.setShifted(z);
                    return;
                }
                return;
            }
            FancyFontsKeyboardView fancyFontsKeyboardView3 = this.keyboardView;
            if (fancyFontsKeyboardView3 != null) {
                keyboard = fancyFontsKeyboardView3.getKeyboard();
            }
            if (keyboard == this.fancyFontsKeyboard) {
                checkToggleCapsLock();
                FancyFontsKeyboardView fancyFontsKeyboardView4 = this.keyboardView;
                if (fancyFontsKeyboardView4 != null) {
                    if (this.isUpperCase || fancyFontsKeyboardView4 == null || !fancyFontsKeyboardView4.isShifted()) {
                        z = true;
                    }
                    this.keyboardView.setShifted(z);
                    return;
                }
                return;
            }
            Keyboard keyboard2 = this.activeKeyboard;
            Keyboard keyboard3 = this.symbolsKeyboard;
            if (keyboard2 == keyboard3) {
                if (keyboard3 != null) {
                    keyboard3.setShifted(true);
                }
                Keyboard keyboard4 = this.symbolsShiftedKeyboard;
                Objects.requireNonNull(keyboard4);
                setActiveKeyboard(keyboard4);
                Keyboard keyboard5 = this.symbolsShiftedKeyboard;
                if (keyboard5 != null) {
                    keyboard5.setShifted(true);
                }
            } else if (keyboard2 == this.symbolsShiftedKeyboard) {
                if (keyboard3 != null) {
                    keyboard3.setShifted(false);
                }
                Keyboard keyboard6 = this.symbolsKeyboard;
                Objects.requireNonNull(keyboard6);
                setActiveKeyboard(keyboard6);
                Keyboard keyboard7 = this.symbolsShiftedKeyboard;
                if (keyboard7 != null) {
                    keyboard7.setShifted(false);
                }
            }
        }
    }

    private final void checkToggleCapsLock() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lastShiftTime + 400 > currentTimeMillis || this.isUpperCase) {
            this.isUpperCase = !this.isUpperCase;
            this.lastShiftTime = 0;
            return;
        }
        this.lastShiftTime = currentTimeMillis;
    }
}

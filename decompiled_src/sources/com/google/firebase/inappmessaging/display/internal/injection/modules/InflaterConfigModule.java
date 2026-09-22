package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.dagger.multibindings.IntoMap;
import com.google.firebase.inappmessaging.display.dagger.multibindings.StringKey;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.keys.LayoutConfigKey;
import com.google.firebase.inappmessaging.model.MessageType;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class InflaterConfigModule {
    public static int DISABLED_BG_FLAG = 327938;
    public static int DISMISSIBLE_DIALOG_FLAG = 327970;
    private int ENABLED_BG_FLAG = 65824;

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String configFor(MessageType messageType, int i) {
        if (i == 1) {
            int i2 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[messageType.ordinal()];
            if (i2 == 1) {
                return LayoutConfigKey.MODAL_PORTRAIT;
            }
            if (i2 == 2) {
                return LayoutConfigKey.CARD_PORTRAIT;
            }
            if (i2 == 3) {
                return LayoutConfigKey.IMAGE_ONLY_PORTRAIT;
            }
            if (i2 != 4) {
                return null;
            }
            return LayoutConfigKey.BANNER_PORTRAIT;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[messageType.ordinal()];
        if (i3 == 1) {
            return LayoutConfigKey.MODAL_LANDSCAPE;
        }
        if (i3 == 2) {
            return LayoutConfigKey.CARD_LANDSCAPE;
        }
        if (i3 == 3) {
            return LayoutConfigKey.IMAGE_ONLY_LANDSCAPE;
        }
        if (i3 != 4) {
            return null;
        }
        return LayoutConfigKey.BANNER_LANDSCAPE;
    }

    @Provides
    DisplayMetrics providesDisplayMetrics(Application application) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) application.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.IMAGE_ONLY_PORTRAIT)
    public InAppMessageLayoutConfig providesPortraitImageLayoutConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder maxDialogWidthPx = InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        return maxDialogWidthPx.setMaxImageWidthWeight(fValueOf).setMaxImageHeightWeight(fValueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISABLED_BG_FLAG)).setWindowWidth(-2).setWindowHeight(-2).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.IMAGE_ONLY_LANDSCAPE)
    public InAppMessageLayoutConfig providesLandscapeImageLayoutConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder maxDialogWidthPx = InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (displayMetrics.heightPixels * 0.9f))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f)));
        Float fValueOf = Float.valueOf(0.8f);
        return maxDialogWidthPx.setMaxImageWidthWeight(fValueOf).setMaxImageHeightWeight(fValueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISABLED_BG_FLAG)).setWindowWidth(-2).setWindowHeight(-2).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.MODAL_LANDSCAPE)
    public InAppMessageLayoutConfig providesModalLandscapeConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder maxImageHeightWeight = InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).setMaxDialogWidthPx(Integer.valueOf(displayMetrics.widthPixels)).setMaxImageHeightWeight(Float.valueOf(1.0f));
        Float fValueOf = Float.valueOf(0.4f);
        return maxImageHeightWeight.setMaxImageWidthWeight(fValueOf).setMaxBodyHeightWeight(Float.valueOf(0.6f)).setMaxBodyWidthWeight(fValueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-1).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.MODAL_PORTRAIT)
    public InAppMessageLayoutConfig providesModalPortraitConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder maxBodyHeightWeight = InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).setMaxImageHeightWeight(Float.valueOf(0.6f)).setMaxBodyHeightWeight(Float.valueOf(0.1f));
        Float fValueOf = Float.valueOf(0.9f);
        return maxBodyHeightWeight.setMaxImageWidthWeight(fValueOf).setMaxBodyWidthWeight(fValueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.CARD_LANDSCAPE)
    public InAppMessageLayoutConfig providesCardLandscapeConfig(DisplayMetrics displayMetrics) {
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).setMaxDialogWidthPx(Integer.valueOf(displayMetrics.widthPixels)).setMaxImageHeightWeight(Float.valueOf(1.0f)).setMaxImageWidthWeight(Float.valueOf(0.5f)).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISMISSIBLE_DIALOG_FLAG)).setWindowWidth(-2).setWindowHeight(-2).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.CARD_PORTRAIT)
    public InAppMessageLayoutConfig providesCardPortraitConfig(DisplayMetrics displayMetrics) {
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int) (((double) displayMetrics.heightPixels) * 0.8d))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.7f))).setMaxImageHeightWeight(Float.valueOf(0.6f)).setMaxImageWidthWeight(Float.valueOf(1.0f)).setMaxBodyHeightWeight(Float.valueOf(0.1f)).setMaxBodyWidthWeight(Float.valueOf(0.9f)).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(DISMISSIBLE_DIALOG_FLAG)).setWindowWidth(-2).setWindowHeight(-2).setBackgroundEnabled(false).setAnimate(false).setAutoDismiss(false).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.BANNER_PORTRAIT)
    public InAppMessageLayoutConfig providesBannerPortraitLayoutConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder builder = InAppMessageLayoutConfig.builder();
        Float fValueOf = Float.valueOf(0.3f);
        return builder.setMaxImageHeightWeight(fValueOf).setMaxImageWidthWeight(fValueOf).setMaxDialogHeightPx(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).setViewWindowGravity(48).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(true).setAnimate(true).setAutoDismiss(true).build();
    }

    @IntoMap
    @Provides
    @StringKey(LayoutConfigKey.BANNER_LANDSCAPE)
    public InAppMessageLayoutConfig providesBannerLandscapeLayoutConfig(DisplayMetrics displayMetrics) {
        InAppMessageLayoutConfig.Builder builder = InAppMessageLayoutConfig.builder();
        Float fValueOf = Float.valueOf(0.3f);
        return builder.setMaxImageHeightWeight(fValueOf).setMaxImageWidthWeight(fValueOf).setMaxDialogHeightPx(Integer.valueOf((int) (displayMetrics.heightPixels * 0.5f))).setMaxDialogWidthPx(Integer.valueOf((int) (displayMetrics.widthPixels * 0.9f))).setViewWindowGravity(48).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(true).setAnimate(true).setAutoDismiss(true).build();
    }
}

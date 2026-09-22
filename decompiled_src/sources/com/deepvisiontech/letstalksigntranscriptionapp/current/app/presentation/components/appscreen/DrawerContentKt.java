package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.BookKt;
import androidx.compose.material.icons.filled.FolderKt;
import androidx.compose.material.icons.filled.HistoryKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.NotificationsKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationDrawerItemColors;
import androidx.compose.material3.NavigationDrawerItemDefaults;
import androidx.compose.material3.NavigationDrawerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavDestination;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: DrawerContent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t\u001aM\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0017\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0018"}, d2 = {"appDrawerItems", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/components/appscreen/DrawerItem;", "getAppDrawerItems", "()Ljava/util/List;", "isDestinationInHierarchy", "", "Landroidx/navigation/NavDestination;", "route", "", "DrawerContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "currentDestination", "activeUserPersonaId", "", "onNavigate", "Lkotlin/Function1;", "onLogOutClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavDestination;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DrawerHeader", "(Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DrawerContentKt {
    private static final List<DrawerItem> appDrawerItems = CollectionsKt.listOf(new DrawerItem[]{new DrawerItem(R.string.conversation_drawer_label_home, HomeKt.getHome(Icons.INSTANCE.getDefault()), ConversationNavigationRoute.ConversationRoute.INSTANCE), new DrawerItem(R.string.conversation_drawer_label_sessions, FolderKt.getFolder(Icons.INSTANCE.getDefault()), ConversationNavigationRoute.ConversationListRoute.INSTANCE), new DrawerItem(R.string.sign_practice_drawer_label_list, BookKt.getBook(Icons.INSTANCE.getDefault()), SignPracticeRoute.SignPracticeListScreen.INSTANCE), new DrawerItem(R.string.env_sound_drawer_label_history, HistoryKt.getHistory(Icons.INSTANCE.getDefault()), EnvironmentSoundRoute.EnvironmentSoundHistoryScreen.INSTANCE), new DrawerItem(R.string.notification_drawer_label_list, NotificationsKt.getNotifications(Icons.INSTANCE.getDefault()), NotificationRoute.NotificationListScreen.INSTANCE), new DrawerItem(R.string.conversation_drawer_label_settings, SettingsKt.getSettings(Icons.INSTANCE.getDefault()), ConversationNavigationRoute.ConversationSettingsRoute.INSTANCE)});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerContent$lambda$9(Modifier modifier, NavDestination navDestination, String str, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        DrawerContent(modifier, navDestination, str, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerHeader$lambda$11(int i, Composer composer, int i2) {
        DrawerHeader(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final List<DrawerItem> getAppDrawerItems() {
        return appDrawerItems;
    }

    public static final boolean isDestinationInHierarchy(NavDestination navDestination, Object obj) {
        Sequence hierarchy;
        Intrinsics.checkNotNullParameter(obj, "route");
        if (navDestination != null && (hierarchy = NavDestination.Companion.getHierarchy(navDestination)) != null) {
            Iterator it = hierarchy.iterator();
            while (it.hasNext()) {
                if (NavDestination.Companion.hasRoute((NavDestination) it.next(), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void DrawerContent(Modifier modifier, final NavDestination navDestination, final String str, final Function1<Object, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavDestination navDestination2;
        String str2;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(function1, "onNavigate");
        Intrinsics.checkNotNullParameter(function0, "onLogOutClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-785480566);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerContent)P(2,1!1,4)68@3519L3085,68@3502L3102:DrawerContent.kt#q85fds");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            navDestination2 = navDestination;
            i3 |= composerStartRestartGroup.changedInstance(navDestination2) ? 32 : 16;
        } else {
            navDestination2 = navDestination;
        }
        if ((i & 384) == 0) {
            str2 = str;
            i3 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        } else {
            str2 = str;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-785480566, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContent (DrawerContent.kt:67)");
            }
            final NavDestination navDestination3 = navDestination2;
            final String str3 = str2;
            composer2 = composerStartRestartGroup;
            NavigationDrawerKt.ModalDrawerSheet-afqeVBk((Modifier) null, (Shape) null, 0L, 0L, 0.0f, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1647224878, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DrawerContentKt.DrawerContent$lambda$8(modifier3, function0, str3, navDestination3, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1572864, 63);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerContentKt.DrawerContent$lambda$9(modifier3, navDestination, str, function1, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerContent$lambda$8(Modifier modifier, Function0 function0, String str, NavDestination navDestination, final Function1 function1, ColumnScope columnScope, Composer composer, int i) {
        float f;
        Intrinsics.checkNotNullParameter(columnScope, "$this$ModalDrawerSheet");
        ComposerKt.sourceInformation(composer, "C72@3634L21,69@3529L3069:DrawerContent.kt#q85fds");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1647224878, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContent.<anonymous> (DrawerContent.kt:69)");
            }
            float f2 = 0.0f;
            Object obj = null;
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1582254756, "C74@3681L14,76@3709L113,80@3836L1822,119@5672L114,137@6464L11,138@6539L11,136@6400L174,123@5800L788:DrawerContent.kt#q85fds");
            DrawerHeader(composer, 0);
            float f3 = 4;
            float f4 = 16;
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(f4), Dp.constructor-impl(f3)), 0.0f, 0L, composer, 0, 6);
            Composer composer3 = composer;
            float f5 = 12;
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(ColumnScope.weight$default(columnScope2, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(f5), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifier2);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer3);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 97190998, "C:DrawerContent.kt#q85fds");
            composer3.startReplaceGroup(-412506338);
            ComposerKt.sourceInformation(composer3, "*109@5168L11,110@5262L11,111@5358L11,112@5456L11,113@5550L11,108@5093L511,93@4373L238,106@4933L26,99@4644L206,92@4319L1307");
            for (final DrawerItem drawerItem : appDrawerItems) {
                if (Intrinsics.areEqual(str, "dhh") && drawerItem.getLabelRes() == R.string.sign_practice_drawer_label_list) {
                    f = f5;
                } else {
                    boolean zIsDestinationInHierarchy = isDestinationInHierarchy(navDestination, drawerItem.getRoute());
                    Modifier modifier3 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f2, Dp.constructor-impl(f3), 1, obj);
                    f = f5;
                    NavigationDrawerItemColors navigationDrawerItemColors = NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), 0L, 0L, composer, NavigationDrawerItemDefaults.$stable << 24, 194);
                    Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2033832952, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2, Object obj3) {
                            return DrawerContentKt.DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$1(drawerItem, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer, 54);
                    ComposerKt.sourceInformationMarkerStart(composer, 287152375, "CC(remember):DrawerContent.kt#9igjgp");
                    boolean zChanged = composer.changed(function1) | composer.changedInstance(drawerItem);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                return DrawerContentKt.DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$3$lambda$2(function1, drawerItem);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    NavigationDrawerKt.NavigationDrawerItem(function2RememberComposableLambda, zIsDestinationInHierarchy, (Function0) objRememberedValue, modifier3, ComposableLambdaKt.rememberComposableLambda(-1170436492, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj2, Object obj3) {
                            return DrawerContentKt.DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(drawerItem, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer, 54), (Function2) null, (Shape) null, navigationDrawerItemColors, (MutableInteractionSource) null, composer, 27654, 352);
                }
                composer3 = composer;
                f5 = f;
                f2 = 0.0f;
                obj = null;
            }
            float f6 = f5;
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(f4), Dp.constructor-impl(f6)), 0.0f, 0L, composer, 0, 6);
            NavigationDrawerKt.NavigationDrawerItem(ComposableSingletons$DrawerContentKt.INSTANCE.m1335getLambda$1145551095$app_release(), false, function0, PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(f6), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(24), 7, (Object) null), ComposableSingletons$DrawerContentKt.INSTANCE.getLambda$1999851533$app_release(), (Function2) null, (Shape) null, NavigationDrawerItemDefaults.INSTANCE.colors-oq7We08(0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError-0d7_KjU(), 0L, 0L, composer, NavigationDrawerItemDefaults.$stable << 24, 215), (MutableInteractionSource) null, composer, 27702, 352);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$1(DrawerItem drawerItem, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@4448L29,96@4533L10,94@4403L182:DrawerContent.kt#q85fds");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2033832952, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DrawerContent.kt:94)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(drawerItem.getLabelRes(), composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(DrawerItem drawerItem, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C100@4674L150:DrawerContent.kt#q85fds");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1170436492, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DrawerContent.kt:100)");
            }
            IconKt.Icon-ww6aTOc(drawerItem.getIcon(), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerContent$lambda$8$lambda$7$lambda$6$lambda$5$lambda$3$lambda$2(Function1 function1, DrawerItem drawerItem) {
        function1.invoke(drawerItem.getRoute());
        return Unit.INSTANCE;
    }

    private static final void DrawerHeader(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(620465490);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerHeader)147@6653L409:DrawerContent.kt#q85fds");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(620465490, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerHeader (DrawerContent.kt:146)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(28), Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -597848161, "C153@6817L44,154@6897L10,156@7013L11,152@6792L264:DrawerContent.kt#q85fds");
            composer2 = composerStartRestartGroup;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_drawer_title, composerStartRestartGroup, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777210, (Object) null), composer2, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return DrawerContentKt.DrawerHeader$lambda$11(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

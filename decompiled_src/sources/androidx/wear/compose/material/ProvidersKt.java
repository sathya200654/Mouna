package androidx.wear.compose.material;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Providers.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\u0000¢\u0006\u0002\u0010\b\u001aO\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u000e\u001aY\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u000e\u001aa\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u000e\u001a]\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\f\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"provideContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "contentColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "content", "(Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "provideIcon", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ExtensionFunctionType;", "iconColor", "(Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "provideNullableScopeContent", "T", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "provideScopeContent", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProvidersKt {
    public static final <T> Function3<T, Composer, Integer, Unit> provideScopeContent(final State<Color> state, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(1271190349, true, new Function3<T, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideScopeContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final T t, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C33@1236L25,30@1114L147:Providers.kt#gj9v0t");
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(t) : composer.changedInstance(t) ? 4 : 2;
                }
                if ((i & 19) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1271190349, i, -1, "androidx.wear.compose.material.provideScopeContent.<anonymous> (Providers.kt:29)");
                    }
                    long j = ((Color) state.getValue()).unbox-impl();
                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j)))};
                    final Function3<T, Composer, Integer, Unit> function4 = function3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1834035571, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideScopeContent.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C34@1246L9:Providers.kt#gj9v0t");
                            if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1834035571, i2, -1, "androidx.wear.compose.material.provideScopeContent.<anonymous>.<anonymous> (Providers.kt:34)");
                            }
                            function4.invoke(t, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }

    public static final <T> Function3<T, Composer, Integer, Unit> provideScopeContent(final State<Color> state, final TextStyle textStyle, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(-778870507, true, new Function3<T, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideScopeContent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final T t, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C48@1639L25,44@1474L190:Providers.kt#gj9v0t");
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(t) : composer.changedInstance(t) ? 4 : 2;
                }
                if ((i & 19) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-778870507, i, -1, "androidx.wear.compose.material.provideScopeContent.<anonymous> (Providers.kt:43)");
                    }
                    long j = ((Color) state.getValue()).unbox-impl();
                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j))), TextKt.getLocalTextStyle().provides(textStyle)};
                    final Function3<T, Composer, Integer, Unit> function4 = function3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-482192299, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideScopeContent.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C49@1649L9:Providers.kt#gj9v0t");
                            if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-482192299, i2, -1, "androidx.wear.compose.material.provideScopeContent.<anonymous>.<anonymous> (Providers.kt:49)");
                            }
                            function4.invoke(t, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }

    public static final Function2<Composer, Integer, Unit> provideContent(final State<Color> state, final Function2<? super Composer, ? super Integer, Unit> function2) {
        return ComposableLambdaKt.composableLambdaInstance(1255923885, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C58@1838L147:Providers.kt#gj9v0t");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1255923885, i, -1, "androidx.wear.compose.material.provideContent.<anonymous> (Providers.kt:57)");
                    }
                    long j = ((Color) state.getValue()).unbox-impl();
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j)))}, function2, composer, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> provideIcon(final State<Color> state, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(-1564059768, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideIcon.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final BoxScope boxScope, Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C73@2290L25,70@2168L147:Providers.kt#gj9v0t");
                if ((i & 6) == 0) {
                    i |= composer.changed(boxScope) ? 4 : 2;
                }
                if ((i & 19) != 18 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1564059768, i, -1, "androidx.wear.compose.material.provideIcon.<anonymous> (Providers.kt:69)");
                    }
                    long j = ((Color) state.getValue()).unbox-impl();
                    ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j)))};
                    final Function3<BoxScope, Composer, Integer, Unit> function4 = function3;
                    CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(552528968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt.provideIcon.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i2) {
                            ComposerKt.sourceInformation(composer2, "C74@2300L9:Providers.kt#gj9v0t");
                            if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(552528968, i2, -1, "androidx.wear.compose.material.provideIcon.<anonymous>.<anonymous> (Providers.kt:74)");
                            }
                            function4.invoke(boxScope, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        });
    }

    public static final <T> Function3<T, Composer, Integer, Unit> provideNullableScopeContent(final State<Color> state, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        if (function3 != null) {
            return ComposableLambdaKt.composableLambdaInstance(670598729, true, new Function3<T, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt$provideNullableScopeContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final T t, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C87@2672L33,84@2539L166:Providers.kt#gj9v0t");
                    if ((i & 6) == 0) {
                        i |= (i & 8) == 0 ? composer.changed(t) : composer.changedInstance(t) ? 4 : 2;
                    }
                    if ((i & 19) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670598729, i, -1, "androidx.wear.compose.material.provideNullableScopeContent.<anonymous>.<anonymous> (Providers.kt:83)");
                        }
                        long j = ((Color) state.getValue()).unbox-impl();
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j)))};
                        final Function3<T, Composer, Integer, Unit> function4 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(-863466743, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt$provideNullableScopeContent$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i2) {
                                ComposerKt.sourceInformation(composer2, "C88@2686L9:Providers.kt#gj9v0t");
                                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-863466743, i2, -1, "androidx.wear.compose.material.provideNullableScopeContent.<anonymous>.<anonymous>.<anonymous> (Providers.kt:88)");
                                }
                                function4.invoke(t, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer, 54), composer, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
        }
        return null;
    }

    public static final <T> Function3<T, Composer, Integer, Unit> provideNullableScopeContent(final State<Color> state, final TextStyle textStyle, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        if (function3 != null) {
            return ComposableLambdaKt.composableLambdaInstance(-546273007, true, new Function3<T, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt$provideNullableScopeContent$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final T t, Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C104@3141L33,100@2961L213:Providers.kt#gj9v0t");
                    if ((i & 6) == 0) {
                        i |= (i & 8) == 0 ? composer.changed(t) : composer.changedInstance(t) ? 4 : 2;
                    }
                    if ((i & 19) != 18 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-546273007, i, -1, "androidx.wear.compose.material.provideNullableScopeContent.<anonymous>.<anonymous> (Providers.kt:99)");
                        }
                        long j = ((Color) state.getValue()).unbox-impl();
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.box-impl(j)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(j))), TextKt.getLocalTextStyle().provides(textStyle)};
                        final Function3<T, Composer, Integer, Unit> function4 = function3;
                        CompositionLocalKt.CompositionLocalProvider(providedValueArr, ComposableLambdaKt.rememberComposableLambda(1313971665, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProvidersKt$provideNullableScopeContent$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i2) {
                                ComposerKt.sourceInformation(composer2, "C105@3155L9:Providers.kt#gj9v0t");
                                if ((i2 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1313971665, i2, -1, "androidx.wear.compose.material.provideNullableScopeContent.<anonymous>.<anonymous>.<anonymous> (Providers.kt:105)");
                                }
                                function4.invoke(t, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer, 54), composer, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
        }
        return null;
    }
}

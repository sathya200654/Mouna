package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.azure.core.util.tracing.Tracer;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ScalingLazyColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ5\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u0013Jm\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001021\u0010\u0019\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f0\u001a¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0016¢\u0006\u0002\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListScopeImpl;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", Tracer.SCOPE_KEY, "Landroidx/compose/foundation/lazy/LazyListScope;", "itemScope", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemScope;", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;Landroidx/compose/foundation/lazy/LazyListScope;Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemScope;)V", "currentStartIndex", "", "item", "", "key", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScalingLazyListScopeImpl implements ScalingLazyListScope {
    private int currentStartIndex;
    private final ScalingLazyListItemScope itemScope;
    private final LazyListScope scope;
    private final ScalingLazyListState state;

    public ScalingLazyListScopeImpl(ScalingLazyListState scalingLazyListState, LazyListScope lazyListScope, ScalingLazyListItemScope scalingLazyListItemScope) {
        this.state = scalingLazyListState;
        this.scope = lazyListScope;
        this.itemScope = scalingLazyListItemScope;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListScope
    public void item(Object key, final Function3<? super ScalingLazyListItemScope, ? super Composer, ? super Integer, Unit> content) {
        final int i = this.currentStartIndex;
        LazyListScope.item$default(this.scope, key, (Object) null, ComposableLambdaKt.composableLambdaInstance(1352637732, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.item.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i2) {
                ComposerKt.sourceInformation(composer, "C767@39974L145:ScalingLazyColumn.kt#n8g2qx");
                if ((i2 & 17) != 16 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1352637732, i2, -1, "androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.item.<anonymous> (ScalingLazyColumn.kt:767)");
                    }
                    ScalingLazyColumnKt.ScalingLazyColumnItemWrapper(i, this.state, this.itemScope, content, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 2, (Object) null);
        this.currentStartIndex++;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListScope
    public void items(int count, Function1<? super Integer, ? extends Object> key, final Function4<? super ScalingLazyListItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        final int i = this.currentStartIndex;
        LazyListScope.items$default(this.scope, count, key, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1224322353, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.items.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, final int i2, Composer composer, int i3) {
                ComposerKt.sourceInformation(composer, "C788@40584L47,784@40438L193:ScalingLazyColumn.kt#n8g2qx");
                if ((i3 & 48) == 0) {
                    i3 |= composer.changed(i2) ? 32 : 16;
                }
                if ((i3 & 145) != 144 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1224322353, i3, -1, "androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.items.<anonymous> (ScalingLazyColumn.kt:784)");
                    }
                    int i4 = i + i2;
                    ScalingLazyListState scalingLazyListState = this.state;
                    ScalingLazyListItemScope scalingLazyListItemScope = this.itemScope;
                    final Function4<ScalingLazyListItemScope, Integer, Composer, Integer, Unit> function4 = itemContent;
                    ScalingLazyColumnKt.ScalingLazyColumnItemWrapper(i4, scalingLazyListState, scalingLazyListItemScope, ComposableLambdaKt.rememberComposableLambda(-555812122, true, new Function3<ScalingLazyListItemScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.items.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((ScalingLazyListItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ScalingLazyListItemScope scalingLazyListItemScope2, Composer composer2, int i5) {
                            ComposerKt.sourceInformation(composer2, "C789@40602L15:ScalingLazyColumn.kt#n8g2qx");
                            if ((i5 & 6) == 0) {
                                i5 |= composer2.changed(scalingLazyListItemScope2) ? 4 : 2;
                            }
                            if ((i5 & 19) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-555812122, i5, -1, "androidx.wear.compose.foundation.lazy.ScalingLazyListScopeImpl.items.<anonymous>.<anonymous> (ScalingLazyColumn.kt:789)");
                            }
                            function4.invoke(scalingLazyListItemScope2, Integer.valueOf(i2), composer2, Integer.valueOf(i5 & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 3072);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 4, (Object) null);
        this.currentStartIndex += count;
    }
}

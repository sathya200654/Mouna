package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Module
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }

    @Provides
    @Singleton
    @ProgrammaticTrigger
    public ConnectableFlowable<String> providesProgramaticContextualTriggerStream() {
        ConnectableFlowable<String> connectableFlowablePublish = Flowable.create(new FlowableOnSubscribe() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule$$ExternalSyntheticLambda0
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws Exception {
                this.f$0.m2087x96ce398e(flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER).publish();
        connectableFlowablePublish.connect();
        return connectableFlowablePublish;
    }

    /* JADX INFO: renamed from: lambda$providesProgramaticContextualTriggerStream$1$com-google-firebase-inappmessaging-internal-injection-modules-ProgrammaticContextualTriggerFlowableModule, reason: not valid java name */
    /* synthetic */ void m2087x96ce398e(final FlowableEmitter flowableEmitter) throws Exception {
        this.triggers.setListener(new ProgramaticContextualTriggers.Listener() { // from class: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule$$ExternalSyntheticLambda1
            @Override // com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener
            public final void onEventTrigger(String str) {
                flowableEmitter.onNext(str);
            }
        });
    }
}

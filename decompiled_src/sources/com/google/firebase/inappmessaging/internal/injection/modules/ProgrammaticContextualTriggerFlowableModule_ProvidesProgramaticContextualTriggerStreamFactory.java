package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.reactivex.flowables.ConnectableFlowable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory implements Factory<ConnectableFlowable<String>> {
    private final ProgrammaticContextualTriggerFlowableModule module;

    public ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.module = programmaticContextualTriggerFlowableModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConnectableFlowable<String> m2088get() {
        return providesProgramaticContextualTriggerStream(this.module);
    }

    public static ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory create(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory(programmaticContextualTriggerFlowableModule);
    }

    public static ConnectableFlowable<String> providesProgramaticContextualTriggerStream(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ConnectableFlowable) Preconditions.checkNotNullFromProvides(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggerStream());
    }
}

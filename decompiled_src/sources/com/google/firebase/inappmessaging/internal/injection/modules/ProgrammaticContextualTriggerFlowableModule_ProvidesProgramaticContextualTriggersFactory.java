package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory implements Factory<ProgramaticContextualTriggers> {
    private final ProgrammaticContextualTriggerFlowableModule module;

    public ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.module = programmaticContextualTriggerFlowableModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ProgramaticContextualTriggers m2089get() {
        return providesProgramaticContextualTriggers(this.module);
    }

    public static ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory create(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(programmaticContextualTriggerFlowableModule);
    }

    public static ProgramaticContextualTriggers providesProgramaticContextualTriggers(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ProgramaticContextualTriggers) Preconditions.checkNotNullFromProvides(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggers());
    }
}

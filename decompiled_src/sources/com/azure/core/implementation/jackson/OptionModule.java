package com.azure.core.implementation.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class OptionModule extends Module {
    OptionModule() {
    }

    public void setupModule(Module.SetupContext setupContext) {
        setupContext.addSerializers(new OptionSerializerProvider());
        setupContext.addTypeModifier(new OptionTypeModifier());
        setupContext.addBeanSerializerModifier(new OptionPropertiesModifier());
    }

    public String getModuleName() {
        return "OptionModule";
    }

    public Version version() {
        return Version.unknownVersion();
    }
}

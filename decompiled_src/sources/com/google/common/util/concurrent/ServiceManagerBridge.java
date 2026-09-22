package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableMultimap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
interface ServiceManagerBridge {
    ImmutableMultimap<Service.State, Service> servicesByState();
}

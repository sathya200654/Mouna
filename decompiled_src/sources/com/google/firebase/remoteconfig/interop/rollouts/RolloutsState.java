package com.google.firebase.remoteconfig.interop.rollouts;

import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class RolloutsState {
    public abstract Set<RolloutAssignment> getRolloutAssignments();

    public static RolloutsState create(Set<RolloutAssignment> set) {
        return new AutoValue_RolloutsState(set);
    }
}

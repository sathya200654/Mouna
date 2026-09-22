package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MeetingRoomKt;
import androidx.compose.material.icons.filled.TranscribeKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ConversationMode.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "", "displayNameRes", "", "displayIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Ljava/lang/String;IILandroidx/compose/ui/graphics/vector/ImageVector;)V", "getDisplayNameRes", "()I", "getDisplayIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "ONE_TO_ONE", "MEETING", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ConversationMode {
    ONE_TO_ONE(R.string.conversation_mode_text_one_to_one, TranscribeKt.getTranscribe(Icons.INSTANCE.getDefault())),
    MEETING(R.string.conversation_mode_text_meeting, MeetingRoomKt.getMeetingRoom(Icons.INSTANCE.getDefault()));

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final ImageVector displayIcon;
    private final int displayNameRes;

    public static EnumEntries<ConversationMode> getEntries() {
        return $ENTRIES;
    }

    ConversationMode(int i, ImageVector imageVector) {
        this.displayNameRes = i;
        this.displayIcon = imageVector;
    }

    public final int getDisplayNameRes() {
        return this.displayNameRes;
    }

    public final ImageVector getDisplayIcon() {
        return this.displayIcon;
    }
}

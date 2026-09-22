package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.local.stores;

import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: PersonaSurveyLocalDataStore.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/local/stores/PersonaSurveyLocalDataStore;", "", "<init>", "()V", "getPersonaSurveyData", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PersonaSurveyLocalDataStore {
    public static final int $stable = 0;
    public static final PersonaSurveyLocalDataStore INSTANCE = new PersonaSurveyLocalDataStore();

    private PersonaSurveyLocalDataStore() {
    }

    public final List<Persona> getPersonaSurveyData() {
        return CollectionsKt.listOf(new Persona[]{new Persona("dhh", "Deaf / Hard-of-Hearing / Speech Impaired", CollectionsKt.listOf(new Role[]{new Role("dhh_connect", "Connect with Deaf Community", false, 4, null), new Role("dhh_advocate", "Advocate & Spread Awareness", false, 4, null), new Role("dhh_entertainment", "Enjoy Accessible Entertainment (movies, events, media)", false, 4, null), new Role("dhh_communicate", "Communicate with Hearing People", false, 4, null), new Role("dhh_services", "Access Government Services", false, 4, null)}), false, 8, null), new Persona("hearing", "Hearing Person", CollectionsKt.listOf(new Role[]{new Role("hearing_learn", "Learn Basic Sign for Everyday Use", false, 4, null), new Role("hearing_communicate_friend", "Communicate with a Deaf Friends / Colleagues", false, 4, null), new Role("hearing_volunteer", "Volunteer & Promote Inclusion", false, 4, null), new Role("hearing_advocate", "Advocate & Spread Awareness", false, 4, null)}), false, 8, null), new Persona("interpreter", "Interpreter", CollectionsKt.listOf(new Role[]{new Role("interpreter_practice", "Practice & Improve Interpreting Skills", false, 4, null), new Role("interpreter_work", "Find & Manage Interpretation Work (clients / agencies)", false, 4, null), new Role("interpreter_network_deaf", "Network with Deaf Communities", false, 4, null), new Role("interpreter_network_interpreters", "Network with Interpreters Communities", false, 4, null), new Role("interpreter_resources", "Access Learning Resources / Updates in the Field", false, 4, null)}), false, 8, null), new Persona("teacher", "Teacher of Deaf / HoH Students", CollectionsKt.listOf(new Role[]{new Role("teacher_accessible_content", "Make Education Content Accessible", false, 4, null), new Role("teacher_share_materials", "Share & Create Learning Materials", false, 4, null), new Role("teacher_engage_parents", "Engage with Parents & Families", false, 4, null), new Role("teacher_train", "Train Yourself in Sign & Inclusive Teaching", false, 4, null), new Role("teacher_collaborate", "Collaborate with Other Teachers", false, 4, null)}), false, 8, null), new Persona("family", "Family of Deaf / HoH Person (CODA, SODA, Parent, etc.)", CollectionsKt.listOf(new Role[]{new Role("family_communicate_home", "Communicate Easily at Home", false, 4, null), new Role("family_bridge", "Bridge Between Hearing & Deaf Worlds", false, 4, null), new Role("family_support", "Support Family Needs (services, appointments, etc.)", false, 4, null), new Role("family_learn_sign", "Learn & Practice Sign Together", false, 4, null), new Role("family_share_stories", "Share Family Stories & Memories in Accessible Way", false, 4, null), new Role("family_connect", "Connect with other families", false, 4, null)}), false, 8, null)});
    }
}

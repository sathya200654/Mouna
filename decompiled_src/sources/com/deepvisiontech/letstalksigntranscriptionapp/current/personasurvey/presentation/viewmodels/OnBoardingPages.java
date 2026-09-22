package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnBoardingViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "", "ConsentPage", "PersonaPage", "RolePage", "ThankYouPage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$ConsentPage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$PersonaPage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$RolePage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$ThankYouPage;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnBoardingPages {

    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$ConsentPage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConsentPage implements OnBoardingPages {
        public static final int $stable = 0;
        public static final ConsentPage INSTANCE = new ConsentPage();

        private ConsentPage() {
        }
    }

    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$PersonaPage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "personas", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "<init>", "(Ljava/util/List;)V", "getPersonas", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PersonaPage implements OnBoardingPages {
        public static final int $stable = 8;
        private final List<Persona> personas;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PersonaPage copy$default(PersonaPage personaPage, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = personaPage.personas;
            }
            return personaPage.copy(list);
        }

        public final List<Persona> component1() {
            return this.personas;
        }

        public final PersonaPage copy(List<Persona> personas) {
            Intrinsics.checkNotNullParameter(personas, "personas");
            return new PersonaPage(personas);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PersonaPage) && Intrinsics.areEqual(this.personas, ((PersonaPage) other).personas);
        }

        public int hashCode() {
            return this.personas.hashCode();
        }

        public String toString() {
            return "PersonaPage(personas=" + this.personas + ")";
        }

        public PersonaPage(List<Persona> list) {
            Intrinsics.checkNotNullParameter(list, "personas");
            this.personas = list;
        }

        public final List<Persona> getPersonas() {
            return this.personas;
        }
    }

    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$RolePage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "persona", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "selectedRoleCount", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;I)V", "getPersona", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "getSelectedRoleCount", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RolePage implements OnBoardingPages {
        public static final int $stable = Persona.$stable;
        private final Persona persona;
        private final int selectedRoleCount;

        public static /* synthetic */ RolePage copy$default(RolePage rolePage, Persona persona, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                persona = rolePage.persona;
            }
            if ((i2 & 2) != 0) {
                i = rolePage.selectedRoleCount;
            }
            return rolePage.copy(persona, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Persona getPersona() {
            return this.persona;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSelectedRoleCount() {
            return this.selectedRoleCount;
        }

        public final RolePage copy(Persona persona, int selectedRoleCount) {
            Intrinsics.checkNotNullParameter(persona, "persona");
            return new RolePage(persona, selectedRoleCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RolePage)) {
                return false;
            }
            RolePage rolePage = (RolePage) other;
            return Intrinsics.areEqual(this.persona, rolePage.persona) && this.selectedRoleCount == rolePage.selectedRoleCount;
        }

        public int hashCode() {
            return (this.persona.hashCode() * 31) + Integer.hashCode(this.selectedRoleCount);
        }

        public String toString() {
            return "RolePage(persona=" + this.persona + ", selectedRoleCount=" + this.selectedRoleCount + ")";
        }

        public RolePage(Persona persona, int i) {
            Intrinsics.checkNotNullParameter(persona, "persona");
            this.persona = persona;
            this.selectedRoleCount = i;
        }

        public final Persona getPersona() {
            return this.persona;
        }

        public final int getSelectedRoleCount() {
            return this.selectedRoleCount;
        }
    }

    /* JADX INFO: compiled from: OnBoardingViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages$ThankYouPage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingPages;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ThankYouPage implements OnBoardingPages {
        public static final int $stable = 0;
        public static final ThankYouPage INSTANCE = new ThankYouPage();

        private ThankYouPage() {
        }
    }
}

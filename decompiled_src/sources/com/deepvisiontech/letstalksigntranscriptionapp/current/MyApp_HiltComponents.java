package com.deepvisiontech.letstalksigntranscriptionapp.current;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di.AnalyticsModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.NavigationViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di.AuthModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di.CredentialModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di.SessionModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.di.AppModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.ConversationSharedViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di.ConversationModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.DocumentScannerViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.HomeViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.SoundRecognizerModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.di.EnvSoundModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.viewmodel.EnvironmentSoundHistoryViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.di.NetworkDiModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.di.ManagerModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.di.ShareIntentModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.di.SpeechToTextModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.WebViewModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.di.EngagementModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.NetworkUnavailableViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService_GeneratedInjector;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di.NotificationModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.di.UserPersonaModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.di.SignPracticeModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel_HiltModules;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.di.VideoAnnotationModule;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels.VideoUploadViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import javax.inject.Singleton;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MyApp_HiltComponents {

    @Subcomponent(modules = {HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class, FragmentCBuilderModule.class, ViewCBuilderModule.class})
    public static abstract class ActivityC implements MainActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityC.class})
    interface ActivityCBuilderModule {
        @Binds
        ActivityComponentBuilder bind(ActivityC.Builder builder);
    }

    @Subcomponent(modules = {AppViewModel_HiltModules.KeyModule.class, ConversationListViewModel_HiltModules.KeyModule.class, ConversationSettingsViewModel_HiltModules.KeyModule.class, ConversationSharedViewModel_HiltModules.KeyModule.class, ConversationViewModel_HiltModules.KeyModule.class, CredentialViewModel_HiltModules.KeyModule.class, DocumentScannerViewModel_HiltModules.KeyModule.class, EnvironmentSoundHistoryViewModel_HiltModules.KeyModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, HiltWrapper_SavedStateHandleModule.class, HomeViewModel_HiltModules.KeyModule.class, MainViewModelCurrent_HiltModules.KeyModule.class, ActivityCBuilderModule.class, ViewModelCBuilderModule.class, NavigationViewModel_HiltModules.KeyModule.class, NetworkUnavailableViewModel_HiltModules.KeyModule.class, NotificationListViewModel_HiltModules.KeyModule.class, NotificationViewModel_HiltModules.KeyModule.class, OnBoardingViewModel_HiltModules.KeyModule.class, SetUpViewModel_HiltModules.KeyModule.class, SignPracticeCreationViewModel_HiltModules.KeyModule.class, SignPracticeListViewModel_HiltModules.KeyModule.class, SignPracticeSessionViewModel_HiltModules.KeyModule.class, SplashScreenViewModel_HiltModules.KeyModule.class, VideoUploadViewModel_HiltModules.KeyModule.class})
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityRetainedC.class})
    interface ActivityRetainedCBuilderModule {
        @Binds
        ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
    }

    @Subcomponent(modules = {ViewWithFragmentCBuilderModule.class})
    public static abstract class FragmentC implements FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends FragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {FragmentC.class})
    interface FragmentCBuilderModule {
        @Binds
        FragmentComponentBuilder bind(FragmentC.Builder builder);
    }

    @Subcomponent
    public static abstract class ServiceC implements PushNotificationService_GeneratedInjector, ServiceComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ServiceComponentBuilder {
        }
    }

    @Module(subcomponents = {ServiceC.class})
    interface ServiceCBuilderModule {
        @Binds
        ServiceComponentBuilder bind(ServiceC.Builder builder);
    }

    @Component(modules = {AnalyticsModule.class, AppModule.class, ApplicationContextModule.class, AuthModule.class, ConversationModule.class, CredentialModule.class, EngagementModule.class, EnvSoundModule.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, ManagerModule.class, ActivityRetainedCBuilderModule.class, ServiceCBuilderModule.class, NetworkDiModule.class, NotificationModule.class, SessionModule.class, ShareIntentModule.class, SignPracticeModule.class, SoundRecognizerModule.class, SpeechToTextModule.class, UserPersonaModule.class, VideoAnnotationModule.class, WebViewModule.class})
    @Singleton
    public static abstract class SingletonC implements MyApp_GeneratedInjector, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent {
    }

    @Subcomponent
    public static abstract class ViewC implements ViewComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewC.class})
    interface ViewCBuilderModule {
        @Binds
        ViewComponentBuilder bind(ViewC.Builder builder);
    }

    @Subcomponent(modules = {AppViewModel_HiltModules.BindsModule.class, ConversationListViewModel_HiltModules.BindsModule.class, ConversationSettingsViewModel_HiltModules.BindsModule.class, ConversationSharedViewModel_HiltModules.BindsModule.class, ConversationViewModel_HiltModules.BindsModule.class, CredentialViewModel_HiltModules.BindsModule.class, DocumentScannerViewModel_HiltModules.BindsModule.class, EnvironmentSoundHistoryViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, HomeViewModel_HiltModules.BindsModule.class, MainViewModelCurrent_HiltModules.BindsModule.class, NavigationViewModel_HiltModules.BindsModule.class, NetworkUnavailableViewModel_HiltModules.BindsModule.class, NotificationListViewModel_HiltModules.BindsModule.class, NotificationViewModel_HiltModules.BindsModule.class, OnBoardingViewModel_HiltModules.BindsModule.class, SetUpViewModel_HiltModules.BindsModule.class, SignPracticeCreationViewModel_HiltModules.BindsModule.class, SignPracticeListViewModel_HiltModules.BindsModule.class, SignPracticeSessionViewModel_HiltModules.BindsModule.class, SplashScreenViewModel_HiltModules.BindsModule.class, VideoUploadViewModel_HiltModules.BindsModule.class})
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewModelComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewModelC.class})
    interface ViewModelCBuilderModule {
        @Binds
        ViewModelComponentBuilder bind(ViewModelC.Builder builder);
    }

    @Subcomponent
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewWithFragmentC.class})
    interface ViewWithFragmentCBuilderModule {
        @Binds
        ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
    }

    private MyApp_HiltComponents() {
    }
}

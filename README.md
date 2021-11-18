# Repro case for Gradle Configuration Cache failure with Gradle Enterprise plugin

## Repro steps

1. `./gradlew jar`
2. `./gradlew jar`

## Expected

Success

## Actual

Crash

```
FAILURE: Build failed with an exception.

* What went wrong:
Could not load the value of field `b` of `com.gradle.scan.plugin.internal.p.c.b` bean found in field `b` of `com.gradle.scan.plugin.internal.p.c.e$a` bean found in field `h` of `com.gradle.scan.plugin.internal.o.a.d` bean found in field `l` of `com.gradle.scan.plugin.internal.o.l` bean found in field `b` of `com.gradle.scan.plugin.internal.o.n` bean found in field `a` of `com.gradle.scan.plugin.internal.o.c` bean found in field `pluginServiceFactory` of `org.gradle.internal.enterprise.impl.DefaultGradleEnterprisePluginAdapter` bean found in Gradle runtime.
> androidx.playground.GradleEnterpriseConventionsPlugin$apply$1$$Lambda$2818/0x000000080235e040

* Try:
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Exception is:
org.gradle.api.GradleException: Could not load the value of field `b` of `com.gradle.scan.plugin.internal.p.c.b` bean found in field `b` of `com.gradle.scan.plugin.internal.p.c.e$a` bean found in field `h` of `com.gradle.scan.plugin.internal.o.a.d` bean found in field `l` of `com.gradle.scan.plugin.internal.o.l` bean found in field `b` of `com.gradle.scan.plugin.internal.o.n` bean found in field `a` of `com.gradle.scan.plugin.internal.o.c` bean found in field `pluginServiceFactory` of `org.gradle.internal.enterprise.impl.DefaultGradleEnterprisePluginAdapter` bean found in Gradle runtime.
	at org.gradle.configurationcache.serialization.beans.BeanPropertyReaderKt.readPropertyValue(BeanPropertyReader.kt:108)
	at org.gradle.configurationcache.serialization.beans.BeanPropertyReaderKt$readPropertyValue$1.invokeSuspend(BeanPropertyReader.kt)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlin.coroutines.SafeContinuation.resumeWith(SafeContinuationJvm.kt:41)
	at org.gradle.configurationcache.serialization.CombinatorsKt$reentrant$1$decodeLoop$$inlined$Continuation$1.resumeWith(Continuation.kt:167)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:46)
	at kotlin.coroutines.ContinuationKt.startCoroutine(Continuation.kt:115)
	at org.gradle.configurationcache.serialization.CombinatorsKt$reentrant$1.decodeLoop(Combinators.kt:163)
	at org.gradle.configurationcache.serialization.CombinatorsKt$reentrant$1.decode(Combinators.kt:127)
	at org.gradle.configurationcache.serialization.codecs.BindingsBackedCodec.decode(BindingsBackedCodec.kt:64)
	at org.gradle.configurationcache.serialization.DefaultReadContext.read(Contexts.kt:247)
	at org.gradle.configurationcache.ConfigurationCacheState.readGradleEnterprisePluginManager(ConfigurationCacheState.kt:560)
	at org.gradle.configurationcache.ConfigurationCacheState.readBuildTreeState(ConfigurationCacheState.kt:308)
	at org.gradle.configurationcache.ConfigurationCacheState.readRootBuild(ConfigurationCacheState.kt:183)
	at org.gradle.configurationcache.ConfigurationCacheState.readRootBuildState(ConfigurationCacheState.kt:113)
	at org.gradle.configurationcache.ConfigurationCacheIO$readRootBuildStateFrom$1.invokeSuspend(ConfigurationCacheIO.kt:71)
	at org.gradle.configurationcache.ConfigurationCacheIO$readRootBuildStateFrom$1.invoke(ConfigurationCacheIO.kt)
	at org.gradle.configurationcache.ConfigurationCacheIO$readConfigurationCacheState$1.invokeSuspend(ConfigurationCacheIO.kt:100)
	at org.gradle.configurationcache.ConfigurationCacheIO$readConfigurationCacheState$1.invoke(ConfigurationCacheIO.kt)
	at org.gradle.configurationcache.ConfigurationCacheIO$withReadContextFor$$inlined$let$lambda$1.invokeSuspend(ConfigurationCacheIO.kt:160)
	at org.gradle.configurationcache.ConfigurationCacheIO$withReadContextFor$$inlined$let$lambda$1.invoke(ConfigurationCacheIO.kt)
	at org.gradle.configurationcache.serialization.RunningKt$runReadOperation$2.invokeSuspend(Running.kt:34)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlin.coroutines.ContinuationKt.startCoroutine(Continuation.kt:115)
	at org.gradle.configurationcache.serialization.RunningKt.runToCompletion(Running.kt:56)
	at org.gradle.configurationcache.serialization.RunningKt.runReadOperation(Running.kt:33)
	at org.gradle.configurationcache.ConfigurationCacheIO.withReadContextFor$configuration_cache(ConfigurationCacheIO.kt:159)
	at org.gradle.configurationcache.ConfigurationCacheIO.readConfigurationCacheState(ConfigurationCacheIO.kt:98)
	at org.gradle.configurationcache.ConfigurationCacheIO.readRootBuildStateFrom$configuration_cache(ConfigurationCacheIO.kt:69)
	at org.gradle.configurationcache.DefaultConfigurationCache$loadWorkGraph$1.invoke(DefaultConfigurationCache.kt:292)
	at org.gradle.configurationcache.DefaultConfigurationCache$loadWorkGraph$1.invoke(DefaultConfigurationCache.kt:47)
	at org.gradle.configurationcache.ConfigurationCacheRepository$useForStateLoad$1.invoke(ConfigurationCacheRepository.kt:76)
	at org.gradle.configurationcache.ConfigurationCacheRepository$useForStateLoad$1.invoke(ConfigurationCacheRepository.kt:43)
	at org.gradle.configurationcache.ConfigurationCacheRepository$withBaseCacheDirFor$1.create(ConfigurationCacheRepository.kt:202)
	at org.gradle.cache.internal.LockOnDemandCrossProcessCacheAccess.withFileLock(LockOnDemandCrossProcessCacheAccess.java:90)
	at org.gradle.cache.internal.DefaultCacheAccess.withFileLock(DefaultCacheAccess.java:191)
	at org.gradle.cache.internal.DefaultPersistentDirectoryStore.withFileLock(DefaultPersistentDirectoryStore.java:188)
	at org.gradle.cache.internal.DefaultCacheFactory$ReferenceTrackingCache.withFileLock(DefaultCacheFactory.java:209)
	at org.gradle.configurationcache.ConfigurationCacheRepository.withBaseCacheDirFor(ConfigurationCacheRepository.kt:200)
	at org.gradle.configurationcache.ConfigurationCacheRepository.useForStateLoad(ConfigurationCacheRepository.kt:74)
	at org.gradle.configurationcache.DefaultConfigurationCache$loadFromCache$result$1.invoke(DefaultConfigurationCache.kt:306)
	at org.gradle.configurationcache.ConfigurationCacheBuildOperationsKt$withOperation$1.call(ConfigurationCacheBuildOperations.kt:43)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
	at org.gradle.configurationcache.ConfigurationCacheBuildOperationsKt.withOperation(ConfigurationCacheBuildOperations.kt:37)
	at org.gradle.configurationcache.ConfigurationCacheBuildOperationsKt.withLoadOperation(ConfigurationCacheBuildOperations.kt:27)
	at org.gradle.configurationcache.DefaultConfigurationCache.loadFromCache(DefaultConfigurationCache.kt:305)
	at org.gradle.configurationcache.DefaultConfigurationCache.loadWorkGraph(DefaultConfigurationCache.kt:291)
	at org.gradle.configurationcache.DefaultConfigurationCache.loadOrScheduleRequestedTasks(DefaultConfigurationCache.kt:115)
	at org.gradle.configurationcache.ConfigurationCacheAwareBuildTreeWorkPreparer.scheduleRequestedTasks(ConfigurationCacheAwareBuildTreeWorkPreparer.kt:27)
	at org.gradle.internal.buildtree.DefaultBuildTreeLifecycleController.lambda$doScheduleAndRunTasks$2(DefaultBuildTreeLifecycleController.java:86)
	at org.gradle.composite.internal.DefaultIncludedBuildTaskGraph.withNewTaskGraph(DefaultIncludedBuildTaskGraph.java:94)
	at org.gradle.internal.buildtree.DefaultBuildTreeLifecycleController.doScheduleAndRunTasks(DefaultBuildTreeLifecycleController.java:85)
	at org.gradle.internal.buildtree.DefaultBuildTreeLifecycleController.lambda$runBuild$4(DefaultBuildTreeLifecycleController.java:103)
	at org.gradle.internal.build.StateTransitionController.lambda$transition$0(StateTransitionController.java:145)
	at org.gradle.internal.build.StateTransitionController.doTransition(StateTransitionController.java:243)
	at org.gradle.internal.build.StateTransitionController.transition(StateTransitionController.java:145)
	at org.gradle.internal.buildtree.DefaultBuildTreeLifecycleController.runBuild(DefaultBuildTreeLifecycleController.java:100)
	at org.gradle.internal.buildtree.DefaultBuildTreeLifecycleController.scheduleAndRunTasks(DefaultBuildTreeLifecycleController.java:66)
	at org.gradle.tooling.internal.provider.ExecuteBuildActionRunner.run(ExecuteBuildActionRunner.java:31)
	at org.gradle.launcher.exec.ChainingBuildActionRunner.run(ChainingBuildActionRunner.java:35)
	at org.gradle.internal.buildtree.ProblemReportingBuildActionRunner.run(ProblemReportingBuildActionRunner.java:49)
	at org.gradle.launcher.exec.BuildOutcomeReportingBuildActionRunner.run(BuildOutcomeReportingBuildActionRunner.java:69)
	at org.gradle.tooling.internal.provider.FileSystemWatchingBuildActionRunner.run(FileSystemWatchingBuildActionRunner.java:114)
	at org.gradle.launcher.exec.BuildCompletionNotifyingBuildActionRunner.run(BuildCompletionNotifyingBuildActionRunner.java:41)
	at org.gradle.launcher.exec.RootBuildLifecycleBuildActionExecutor.lambda$execute$0(RootBuildLifecycleBuildActionExecutor.java:40)
	at org.gradle.composite.internal.DefaultRootBuildState.run(DefaultRootBuildState.java:155)
	at org.gradle.launcher.exec.RootBuildLifecycleBuildActionExecutor.execute(RootBuildLifecycleBuildActionExecutor.java:40)
	at org.gradle.internal.buildtree.DefaultBuildTreeContext.execute(DefaultBuildTreeContext.java:40)
	at org.gradle.launcher.exec.BuildTreeLifecycleBuildActionExecutor.lambda$execute$0(BuildTreeLifecycleBuildActionExecutor.java:65)
	at org.gradle.internal.buildtree.BuildTreeState.run(BuildTreeState.java:53)
	at org.gradle.launcher.exec.BuildTreeLifecycleBuildActionExecutor.execute(BuildTreeLifecycleBuildActionExecutor.java:65)
	at org.gradle.launcher.exec.RunAsBuildOperationBuildActionExecutor$3.call(RunAsBuildOperationBuildActionExecutor.java:61)
	at org.gradle.launcher.exec.RunAsBuildOperationBuildActionExecutor$3.call(RunAsBuildOperationBuildActionExecutor.java:57)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:204)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:199)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:66)
	at org.gradle.internal.operations.DefaultBuildOperationRunner$2.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:157)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:59)
	at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:53)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:73)
	at org.gradle.launcher.exec.RunAsBuildOperationBuildActionExecutor.execute(RunAsBuildOperationBuildActionExecutor.java:57)
	at org.gradle.launcher.exec.RunAsWorkerThreadBuildActionExecutor.lambda$execute$0(RunAsWorkerThreadBuildActionExecutor.java:38)
	at org.gradle.internal.work.DefaultWorkerLeaseService.withLocks(DefaultWorkerLeaseService.java:211)
	at org.gradle.launcher.exec.RunAsWorkerThreadBuildActionExecutor.execute(RunAsWorkerThreadBuildActionExecutor.java:38)
	at org.gradle.tooling.internal.provider.ContinuousBuildActionExecutor.execute(ContinuousBuildActionExecutor.java:103)
	at org.gradle.tooling.internal.provider.SubscribableBuildActionExecutor.execute(SubscribableBuildActionExecutor.java:64)
	at org.gradle.internal.session.DefaultBuildSessionContext.execute(DefaultBuildSessionContext.java:46)
	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter$ActionImpl.apply(BuildSessionLifecycleBuildActionExecuter.java:100)
	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter$ActionImpl.apply(BuildSessionLifecycleBuildActionExecuter.java:88)
	at org.gradle.internal.session.BuildSessionState.run(BuildSessionState.java:69)
	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:62)
	at org.gradle.tooling.internal.provider.BuildSessionLifecycleBuildActionExecuter.execute(BuildSessionLifecycleBuildActionExecuter.java:41)
	at org.gradle.tooling.internal.provider.GradleThreadBuildActionExecuter.execute(GradleThreadBuildActionExecuter.java:36)
	at org.gradle.tooling.internal.provider.GradleThreadBuildActionExecuter.execute(GradleThreadBuildActionExecuter.java:25)
	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:63)
	at org.gradle.tooling.internal.provider.StartParamsValidatingActionExecuter.execute(StartParamsValidatingActionExecuter.java:31)
	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:58)
	at org.gradle.tooling.internal.provider.SessionFailureReportingActionExecuter.execute(SessionFailureReportingActionExecuter.java:42)
	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:47)
	at org.gradle.tooling.internal.provider.SetupLoggingActionExecuter.execute(SetupLoggingActionExecuter.java:31)
	at org.gradle.launcher.daemon.server.exec.ExecuteBuild.doBuild(ExecuteBuild.java:65)
	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.WatchForDisconnection.execute(WatchForDisconnection.java:39)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.ResetDeprecationLogger.execute(ResetDeprecationLogger.java:29)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.RequestStopIfSingleUsedDaemon.execute(RequestStopIfSingleUsedDaemon.java:35)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.ForwardClientInput$2.create(ForwardClientInput.java:78)
	at org.gradle.launcher.daemon.server.exec.ForwardClientInput$2.create(ForwardClientInput.java:75)
	at org.gradle.util.internal.Swapper.swap(Swapper.java:38)
	at org.gradle.launcher.daemon.server.exec.ForwardClientInput.execute(ForwardClientInput.java:75)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.LogAndCheckHealth.execute(LogAndCheckHealth.java:55)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.LogToClient.doBuild(LogToClient.java:63)
	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.EstablishBuildEnvironment.doBuild(EstablishBuildEnvironment.java:84)
	at org.gradle.launcher.daemon.server.exec.BuildCommandOnly.execute(BuildCommandOnly.java:37)
	at org.gradle.launcher.daemon.server.api.DaemonCommandExecution.proceed(DaemonCommandExecution.java:104)
	at org.gradle.launcher.daemon.server.exec.StartBuildOrRespondWithBusy$1.run(StartBuildOrRespondWithBusy.java:52)
	at org.gradle.launcher.daemon.server.DaemonStateCoordinator$1.run(DaemonStateCoordinator.java:297)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:61)
Caused by: java.lang.ClassNotFoundException: androidx.playground.GradleEnterpriseConventionsPlugin$apply$1$$Lambda$2818/0x000000080235e040
	at org.gradle.configurationcache.serialization.DefaultReadContext.readClass(Contexts.kt:273)
	at org.gradle.configurationcache.serialization.codecs.BeanCodec.decode(BeanCodec.kt:44)
	at org.gradle.configurationcache.serialization.CombinatorsKt$reentrant$1$decodeLoop$1.invokeSuspend(Combinators.kt:162)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	... 129 more


* Get more help at https://help.gradle.org

```
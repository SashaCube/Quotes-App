plugins {
    id(Android.application)
    id(Kotlin.android)
    id(Kotlin.extensions)
    id(Koin.plugin)
}

androidApplicationConfig({
    composeAndroidConfigs()
})

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    kotlinStdLibDependencies()
    commonUiDependencies()
    composeDependencies()
    koinDependencies()
    ktorClientDependencies()

    unitTestDependencies()
    androidTestDependencies()
}
plugins {
    id(Android.application)
    id(Kotlin.android)
    id(Kotlin.extensions)
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

    unitTestDependencies()
    androidTestDependencies()
}
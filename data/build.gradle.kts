plugins {
    id(Android.library)
    id(Kotlin.android)
    id(Kotlin.extensions)
    id(Kotlin.kapt)
}

androidLibraryConfig()

dependencies {
    implementation(project(Modules.domain))

    kotlinStdLibDependencies()
    ktorClientDependencies()
    roomDependencies()

    unitTestDependencies()
    androidTestDependencies()
}
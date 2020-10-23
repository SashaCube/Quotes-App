plugins {
    id(Android.library)
    id(Kotlin.android)
    id(Kotlin.extensions)
}

androidLibraryConfig()

dependencies {
    implementation(project(Modules.domain))

    kotlinStdLibDependencies()
    ktorClientDependencies()

    unitTestDependencies()
    androidTestDependencies()
}
plugins {
    id(Android.library)
    id(Kotlin.android)
    id(Kotlin.extensions)
}

androidLibraryConfig()

dependencies {
    kotlinStdLibDependencies()
    implementation(Libs.coroutines)

    unitTestDependencies()
    androidTestDependencies()
}
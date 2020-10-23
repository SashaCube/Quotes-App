object Modules {
    const val domain = ":domain"
    const val data = ":data"
    const val app = ":app"
}

object AppConfig {
    const val id = "com.example.myapplication"
    const val versionName = "0.0.1"
    const val versionCode = 1
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object AndroidSdk {
    const val min = 21
    const val target = 30
    const val compile = target
}

object Kotlin {
    const val android = "kotlin-android"
    const val extensions = "kotlin-android-extensions"
    const val kapt = "kotlin-kapt"
}

object Android {
    const val application = "com.android.application"
    const val library = "com.android.library"
}

object Versions {
    const val composeVersion = "1.0.0-alpha05"
    const val ktorVersion = "1.4.1"
    const val coreVersion = "1.3.2"
    const val appcompatVersion = "1.2.0"
    const val googleMaterialVersion = "1.2.1"
    const val lifecycleRuntimeVersion = "2.3.0-beta01"
    const val lifecycleLiveDataVersion = "2.2.0"
    const val fragmentVersion = "1.2.5"
    const val junitVersion = "4.13.1"
    const val androidJunitVersion = "1.1.2"
    const val androidEspressoVersion = "3.3.0"
    const val kotlinVersion = "1.4.10"
    const val androidGradleVersion = "4.2.0-alpha14"
    const val coroutinesVersion = "1.3.9"
    const val roomVersion = "2.2.5"
}

object BuildPlugins {
    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradleVersion}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Libs {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val googleMaterial =
        "com.google.android.material:material:${Versions.googleMaterialVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"
    const val lifecycleLivedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLiveDataVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
        const val uiText = "androidx.compose.ui:ui-text-android:${Versions.composeVersion}"
        const val foundationText =
            "androidx.compose.foundation:foundation-text:${Versions.composeVersion}"
        const val uiTooling =
            "androidx.ui:ui-tooling:${Versions.composeVersion}"  // not yet refactored, check it later
    }

    object KtorClient {
        const val core = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
        const val android = "io.ktor:ktor-client-android:${Versions.ktorVersion}"
        const val jsonJvm = "io.ktor:ktor-client-json-jvm:${Versions.ktorVersion}"
        const val gson = "io.ktor:ktor-client-gson:${Versions.ktorVersion}"
        const val logger = "io.ktor:ktor-client-logging-jvm:${Versions.ktorVersion}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val ktx = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    object Test {
        const val testJunit = "junit:junit:${Versions.junitVersion}"
        const val androidTestJunit = "androidx.test.ext:junit:${Versions.androidJunitVersion}"
        const val androidTestEspresso =
            "androidx.test.espresso:espresso-core:${Versions.androidEspressoVersion}"
    }
}
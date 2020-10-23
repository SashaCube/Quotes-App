import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.withGroovyBuilder

fun DependencyHandlerScope.kotlinStdLibDependencies() {
    implementation(Libs.kotlinStdLib)
}

fun DependencyHandlerScope.unitTestDependencies() {
    testImplementation(Libs.Test.testJunit)
}

fun DependencyHandlerScope.androidTestDependencies() {
    androidTestImplementation(Libs.Test.androidTestJunit)
    androidTestImplementation(Libs.Test.androidTestEspresso)
}

fun DependencyHandlerScope.commonUiDependencies() {
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.googleMaterial)
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.lifecycleLivedata)
    implementation(Libs.fragment)
}

fun DependencyHandlerScope.roomDependencies() {
    implementation(Libs.Room.runtime)
    kapt(Libs.Room.compiler)
}

fun DependencyHandlerScope.composeDependencies() {
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.foundationLayout)
    implementation(Libs.Compose.uiText)
    implementation(Libs.Compose.foundationText)
    implementation(Libs.Compose.uiTooling)
}

fun DependencyHandlerScope.ktorClientDependencies() {
    implementation(Libs.KtorClient.core)
    implementation(Libs.KtorClient.android)
    implementation(Libs.KtorClient.jsonJvm)
    implementation(Libs.KtorClient.gson)
    implementation(Libs.KtorClient.logger)
}


fun Project.androidApplicationConfig(
    block: BaseExtension.() -> Unit = {},
    appId: String = AppConfig.id,
    appVersionCode: Int = AppConfig.versionCode,
    appVersionName: String = AppConfig.versionName
) {
    androidLibraryConfig(
        androidExtensions = block
    ) {
        applicationId = appId
        versionCode = appVersionCode
        versionName = appVersionName
    }
}

fun Project.androidLibraryConfig(
    androidExtensions: BaseExtension.() -> Unit = {},
    defaultConfigExtensions: DefaultConfig.() -> Unit = {}
) {
    android.run {
        compileSdkVersion(AndroidSdk.compile)
        defaultConfig {
            defaultConfigExtensions()
            minSdkVersion(AndroidSdk.min)
            targetSdkVersion(AndroidSdk.target)
            testInstrumentationRunner = AppConfig.testRunner
        }
        buildTypes {
            getByName("debug") {
                isMinifyEnabled = false
            }
            getByName("release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                consumerProguardFiles("consumer-rules.pro")
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        withGroovyBuilder {
            "kotlinOptions" {
                setProperty("jvmTarget", "1.8")
            }
        }

        androidExtensions()

        packagingOptions.exclude("META-INF/main.kotlin_module")
    }
}

fun BaseExtension.composeAndroidConfigs() {
    withGroovyBuilder {
        "kotlinOptions" {
            setProperty("jvmTarget", "1.8")
            setProperty("useIR", "true")
        }

        "buildFeatures" {
            setProperty("compose", "true")
        }

        "composeOptions" {
            setProperty("kotlinCompilerExtensionVersion", Versions.composeVersion)
            setProperty("kotlinCompilerVersion", Versions.kotlinVersion)
        }
    }
}

val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension
        ?: error("Project '$name' is not an Android module")

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}
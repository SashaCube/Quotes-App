import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * gradle [kotlin-dsl] shows warning -> "Unsupported Kotlin plugin version."
 * hope it will be resolved soon
 *
 * https://github.com/gradle/kotlin-dsl-samples/issues/1355
 * https://github.com/gradle/gradle/issues/13020
 */
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
    }
}

repositories {
    jcenter()
    google()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.4.10"
}

dependencies {
    implementation("com.android.tools.build:gradle:4.2.0-alpha14")
    implementation("com.android.tools.build:gradle-api:4.2.0-alpha14")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
}
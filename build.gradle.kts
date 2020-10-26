// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    }
    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.koin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    }
}

tasks.register("clean").configure {
    delete("build")
}
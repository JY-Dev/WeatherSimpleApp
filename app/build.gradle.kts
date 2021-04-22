plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("android")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.example.weathersimpleapp"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        buildConfigField("String","WeatherApiKey","\"6fbcadd4a46d4db853cd77a061552d44\"")
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dataBinding {
        android.buildFeatures.dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //std lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(AppDependencies.appLibraries)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.lelestacia.lelenimev2.feature.anime_image.data.repository"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":core:utils"))
    implementation(project(":feature:anime_image:data:remote:waifu_im"))
    implementation(project(":feature:anime_image:domain:model"))

    //  Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    //  Coroutine
    implementation(libs.coroutine)

    //  Junit
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.android)
}
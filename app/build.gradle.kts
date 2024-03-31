plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.josedavila.fetchrewards"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.josedavila.fetchrewards"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Versions
    val appCompatVersion = "1.6.1"
    val coilVersion = "2.5.0"
    val composeMaterialVersion = "1.2.1"
    val constraintLayoutVersion = "2.1.4"
    val coreKtxVersion = "1.12.0"
    val hiltNavComposeVersion = "1.2.0"
    val hiltVersion = "2.50"
    val materialVersion = "1.11.0"
    val moshiVersion = "1.15.0"
    val retrofitVersion = "2.9.0"
    val roomVersion = "2.6.1"

    // AndroidX
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.compose.material3:material3:$composeMaterialVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavComposeVersion")
    ksp("com.google.dagger:hilt-android-compiler:$hiltVersion")

    // Image Loading
    implementation("io.coil-kt:coil:$coilVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")

    // DB
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
}

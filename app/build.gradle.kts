plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.fineduca"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fineduca"
        minSdk = 27
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Dependências do Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Dependências do Compose
    implementation (libs.androidx.navigation.compose.v260)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.foundation)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.activity.compose.v172)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Dependência para corrotinas
    implementation(libs.kotlinx.coroutines.android)

    // Outras dependências (usando Version Catalog)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.compose.android)
    implementation(libs.androidx.room.compiler)
    implementation(libs.androidx.room.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Room Dependencies
    implementation (libs.androidx.room.runtime)


}
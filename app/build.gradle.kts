plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.jaydip.fancyfontskeyboard"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jaydip.fancyfontskeyboard"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")
    implementation("com.github.bumptech.glide:glide:4.15.0")
    implementation("com.airbnb.android:lottie:6.2.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
}
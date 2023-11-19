import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
}

val properties = gradleLocalProperties(rootDir)


android {
    namespace = "com.ghj.jeonjutour"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ghj.jeonjutour"
        minSdk = 21
        targetSdk = 33
        versionCode = 200
        versionName = "2.0.0"
    }

    buildTypes {
        val properties = gradleLocalProperties(rootDir)
        all {
            buildConfigField("String", "BASE_URL", properties.getProperty("BASE_URL"))
            buildConfigField("String", "DATA_KEY", properties.getProperty("DATA_KEY"))
            buildConfigField("String", "CURTURE_EXP_LIST", properties.getProperty("CURTURE_EXP_LIST"))
            buildConfigField("String", "CURTURE_SPC", properties.getProperty("CURTURE_SPC"))
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.6.4")
    implementation("com.squareup.retrofit2:converter-gson:2.6.4")   // JSON 타입의 응답결과를 객체로 매핑해주는 Converter
    implementation("com.squareup.retrofit2:converter-scalars:2.6.4") // 응답결과를 String자체로 받아서 보여주는 Converte
    // retrofit - xml parser
    implementation("com.tickaroo.tikxml:annotation:0.8.13")
    implementation("com.tickaroo.tikxml:core:0.8.13")
    implementation("com.tickaroo.tikxml:retrofit-converter:0.8.13")
    annotationProcessor("com.tickaroo.tikxml:processor:0.8.13")

}
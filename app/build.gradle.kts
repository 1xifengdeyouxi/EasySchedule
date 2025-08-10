plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.safe.args)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.swu.easyschedule"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.swu.easyschedule"
        minSdk = 35
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    configurations.all {
        resolutionStrategy {
            force("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
            force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.20")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            force("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
        }

        // 排除所有 kotlin-android-extensions 相关
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-android-extensions")
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-android-extensions-runtime")
        exclude(group = "com.fasterxml.jackson.core")
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
}

dependencies {
    // 文件树依赖
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//    数据库 implementation("androidx.room:room-runtime:$room_version")
    implementation(libs.androidx.room.runtime)
    //ksp("androidx.room:room-compiler:$room_version")
    //ksp(libs.androidx.room.compiler)
    //implementation("androidx.room:room-ktx:$room_version")
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    //by viewModels
    implementation(libs.androidx.activity.ktx)

    //coroutine 携程
    implementation(libs.jetbrains.kotlinx.coroutines.core)
    implementation(libs.jetbrains.kotlinx.coroutines.android)

    //viewModelScope lifecycleScope
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //dataBinding kapt
    implementation(libs.lifecycle.compiler)

//    网络
    implementation(libs.json)
    implementation(libs.okhttp)
    implementation(libs.gson)
    //implementation 'com.squareup.retrofit2:retrofit:(insert latest version)'
    implementation(libs.retrofit)

    implementation(kotlin("stdlib"))

    //recycleView  implementation "io.github.cymchad:BaseRecyclerViewAdapterHelper4:4.1.4"
    implementation(libs.androidx.baseRecyclerViewAdapterHelper)
    //numberPicker  implementation 'cn.carbswang.android:NumberPickerView:1.2.0'
    implementation(libs.androidx.numberPickerView)

    //implementation 'com.jaredrummler:colorpicker:1.1.0'
    implementation(libs.androidx.colorPicker)

    //implementation("com.jsoizo:kotlin-csv-jvm:1.10.0") // for JVM platform
    //implementation("com.jsoizo:kotlin-csv-js:1.10.0") // for Kotlin JS platform
    implementation(libs.androidx.kotlinCsvJVM)
    //implementation(libs.androidx.kotlinCsvJS)

    //implementation 'com.github.jahirfiquitiva:TextDrawable:1.0.3'
    implementation(libs.androidx.textDrawable)

    //'com.timehop.stickyheadersrecyclerview:library:
    implementation(libs.androidx.stickyHeadersRecyclerView)

    //<groupId>net.sf.biweekly</groupId>
    implementation(libs.androidx.biweekly)

    //    implementation "com.microsoft.appcenter:appcenter-analytics:${appCenterSdkVersion}"
    //    implementation "com.microsoft.appcenter:appcenter-crashes:${appCenterSdkVersion}"
    implementation(libs.androidx.appCenter)
    implementation(libs.androidx.appCenterCrashes)

    //'com.bigkoo:quicksidebar:1.0.3'
    implementation(libs.androidx.quickSideBar)

    //Glide  implementation 'com.github.bumptech.glide:glide:4.16.0'
    implementation(libs.androidx.glide)
    kapt(libs.androidx.glideCompiler)

    //Toast  implementation 'com.github.GrenderG:Toasty:1.5.2'
    implementation(libs.androidx.toasty)

    //implementation 'com.github.sephiroth74:android-target-tooltip:Tag'
    implementation(libs.androidx.sephiroth74)

//   kotlin
    implementation(libs.androidx.kotlinStdlibJdk8)
    //org.jetbrains.kotlin:kotlin-stdlib
    implementation(libs.androidx.kotlinStdlib)
    //org.jetbrains.kotlin:kotlin-test-junit
    //testImplementation(libs.androidx.kotlinStdlibTestJunit)
//    org.jetbrains.kotlin:kotlin-gradle-plugin
    //implementation(libs.androidx.kotlinGradlePlugin)
    //const val kotlinAllOpen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"
    //implementation(libs.androidx.kotlinAllOpen)
}
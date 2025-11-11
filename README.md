# sampleHiltApp

## Setting Up Jetpack Compose and Hilt

This guide provides step-by-step instructions for adding Jetpack Compose and Hilt dependencies to your Android project, including the configuration of the Kapt plugin for annotation processing.

### Step 1: Configure the Hilt Plugin

First, apply the Hilt plugin in your root `build.gradle.kts` file. This ensures that the plugin is available to all modules in your project.

```kotlin
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt.plugin) apply false
}
```

### Step 2: Add the Compose Compiler Plugin

Next, add the Jetpack Compose compiler plugin to your project. This is essential for enabling Compose in your application.

```kotlin
// build.gradle.kts
plugins {
    // ...
    alias(libs.plugins.compose.compiler)
}
```

### Step 3: Enable View Binding and Compose

In your app-level `build.gradle.kts` file, enable both view binding and Jetpack Compose. This allows you to use both modern UI development tools in your project.

```kotlin
// app/build.gradle.kts
android {
    // ...
    buildFeatures {
        viewBinding = true
        compose = true
    }
}
```

### Step 4: Add Hilt and Compose Dependencies

Add the required dependencies for Hilt and Jetpack Compose to your app-level `build.gradle.kts` file. This includes the Hilt Android library, the Hilt compiler, and the core Compose libraries.

```kotlin
// app/build.gradle.kts
dependencies {
    // ...
    // Core Hilt dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Jetpack Compose dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
```

### Step 5: Configure Kapt for Annotation Processing

Finally, configure the Kapt plugin to work with Hilt’s annotation processing. Add the Kapt plugin to your app-level `build.gradle.kts` file and include dependencies for testing.

```kotlin
// app/build.gradle.kts
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.compose.compiler)
    // ...
    id("kotlin-kapt")
}

dependencies {
    // ...
    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)
}
```

// AGP 9 tích hợp sẵn Kotlin (built-in Kotlin) -> không cần plugin org.jetbrains.kotlin.android
buildscript {
    dependencies {
        // Nâng KGP lên 2.2.21 (AGP 9.0.1 mặc định dùng 2.2.10) để chạy ổn định hơn trên JDK 25
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin") {
            version { strictly("2.2.21") }
        }
    }
}

plugins {
    id("com.android.application") version "9.0.1" apply false
    id("com.google.devtools.ksp") version "2.3.6" apply false
}

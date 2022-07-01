buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
   }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
   alias(libs.plugins.kotlin.multiplatform)
   alias(libs.plugins.kotest.multiplatform)
}

repositories {
   mavenCentral()
   mavenLocal()
   maven("https://oss.sonatype.org/content/repositories/snapshots")
}

kotlin {

   targets {
      linuxX64 {
         binaries {
            executable()
         }
      }

      mingwX64()

      macosX64()
      macosArm64()

      tvos()
      tvosSimulatorArm64()

      watchosArm32()
      watchosArm64()
      watchosX86()
      watchosX64()
      watchosSimulatorArm64()

      iosX64()
      iosArm64()
      iosArm32()
      iosSimulatorArm64()
   }

   sourceSets {

      val commonMain by getting
      val commonTest by getting {
         dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotest.framework.engine)
         }
      }

      val desktopMain by creating {
         dependsOn(commonMain)
         dependencies {
            implementation(kotlin("native-utils"))
         }
      }

      val linuxX64Main by getting {
         dependsOn(desktopMain)
      }

      val desktopTest by creating {
         dependsOn(commonTest)
      }

      val linuxX64Test by getting {
         dependsOn(desktopTest)
      }

      val macosArm64Main by getting {
         dependsOn(desktopMain)
      }

      val macosArm64Test by getting {
         dependsOn(desktopTest)
      }
   }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
   kotlinOptions {
      apiVersion = "1.6"
      verbose = true
   }
}

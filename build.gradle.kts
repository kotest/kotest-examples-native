buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
   }
}

plugins {
   kotlin("multiplatform").version("1.6.21")
   id("io.kotest.multiplatform") version "5.2.3"
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

      val commonMain by getting {
         dependencies {
            implementation(kotlin("stdlib"))
         }
      }

      val commonTest by getting {
         dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            implementation("io.kotest:kotest-framework-engine:5.3.0")
         }
      }

      val desktopMain by creating {
         dependsOn(commonMain)
         dependencies {
            implementation("org.jetbrains.kotlin:kotlin-native-utils:1.5.30")
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

   }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
   kotlinOptions {
      apiVersion = "1.6"
      verbose = true
   }
}

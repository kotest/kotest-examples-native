buildscript {
   repositories {
      mavenCentral()
      mavenLocal()
   }
}

plugins {
   kotlin("multiplatform").version("1.5.21")
   id("io.kotest.multiplatform") version "5.0.0.5"
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
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
            implementation("io.kotest:kotest-framework-engine:5.0.0.403-SNAPSHOT")
         }
      }

      val desktopMain by creating {
         dependsOn(commonMain)
         dependencies {
            implementation("org.jetbrains.kotlin:kotlin-native-utils:1.5.21")
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

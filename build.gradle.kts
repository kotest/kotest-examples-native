buildscript {

   repositories {
      mavenCentral()
   }
}


plugins {
   kotlin("multiplatform") version "1.4.32"
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
      commonTest {
         dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation("io.kotest:kotest-assertions-core:4.4.3")
         }
      }
   }
}

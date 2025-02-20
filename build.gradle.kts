import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    kotlin("jvm") version "1.5.31"
}

group = "com.github.frcsty"
version = "2.3.0"

val libsPath = "com.github.frcsty.frozenjoin"
val javaVersion = JavaVersion.VERSION_16

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://jitpack.io/")
}

dependencies {
    implementation("me.mattstudios.utils:matt-framework:1.4.6")
    implementation("org.bstats:bstats-bukkit:2.2.1")
    compileOnly("net.luckperms:api:5.3")
    compileOnly("io.papermc.paper:paper-api:1.17-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.10.10")
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks {
    withType<ProcessResources> {
        expand("version" to project.version)
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.majorVersion
        }
    }


    withType<ShadowJar> {
        relocate("org.bstats", "${libsPath}.bstats")
        relocate("me.mattstudios.mf", "${libsPath}.mf-utils")
        relocate("kotlin", "${libsPath}.kotlin")

        archiveFileName.set("${project.name}-${project.version}.jar")
    }
}
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

val kotlinVersion = "1.6.10"
val serializationVersion = "1.3.2"
val ktorVersion = "1.6.7"
val logbackVersion = "1.2.10"
val reactVersion = "17.0.2-pre.303-kotlin-1.6.10"
val kmongoVersion = "4.5.0"

plugins {
    kotlin("multiplatform") version "1.6.10"
    application
    kotlin("plugin.serialization") version "1.6.10"
}

group = "ru.andrewgo.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}


kotlin {
    jvm {
//        compilations.all {
//            kotlinOptions.jvmTarget = "14"
//        }
        withJava()
//        testRuns["test"].executionTask.configure {
//            useJUnitPlatform()
//        }
    }
//    js(LEGACY) {
//        binaries.executable()
//        browser {
//            commonWebpackConfig {
//                cssSupport.enabled = true
//            }
//        }
//    }ку
    js {
        browser {
            binaries.executable()
        }
    }
    sourceSets {
//        val commonTest by getting
        val commonMain by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
//                implementation("io.ktor:ktor-server-netty:1.6.3")
//                implementation("io.ktor:ktor-html-builder:1.6.3")
//                implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")

                implementation("io.ktor:ktor-serialization:$ktorVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
                implementation("org.litote.kmongo:kmongo-coroutine-serialization:$kmongoVersion")
            }
        }
//        val jvmTest by getting
        val jsMain by getting {
            dependencies {

//                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:5.4.2-pre.303-kotlin-1.6.10")

                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:5.4.2-pre.303-kotlin-1.6.10")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-icons:5.4.2-pre.303-kotlin-1.6.10")
                implementation(npm("@emotion/react", "11.7.1"))
                implementation(npm("@emotion/styled", "11.6.0"))

                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")

                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$reactVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$reactVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-css:$reactVersion")

                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.2.1-pre.303-kotlin-1.6.10")


//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.240-kotlin-1.5.30")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.240-kotlin-1.5.30")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.240-kotlin-1.5.30")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:5.2.0-pre.240-kotlin-1.5.30")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:$reactVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:$reactVersion")
            }
        }
    }
}

//application {
//    mainClass.set("ru.andrewgo.demo.application.ServerKt")
//}
//
//tasks.named<Copy>("jvmProcessResources") {
//    val jsBrowserDistribution = tasks.named("jsBrowserDistribution")
//    from(jsBrowserDistribution)
//}
//
//tasks.named<JavaExec>("run") {
//    dependsOn(tasks.named<Jar>("jvmJar"))
//    classpath(tasks.named<Jar>("jvmJar"))
//}
//
//// include JS artifacts in any JAR we generate
//tasks.getByName<Jar>("jvmJar") {
//    val taskName = if (project.hasProperty("isProduction")
//        || project.gradle.startParameter.taskNames.contains("installDist")
//    ) {
//        "jsBrowserProductionWebpack"
//    } else {
//        "jsBrowserDevelopmentWebpack"
//    }
//    val webpackTask = tasks.getByName<org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack>(taskName)
//    dependsOn(webpackTask) // make sure JS gets compiled first
//    from(File(webpackTask.destinationDirectory, webpackTask.outputFileName)) // bring output file along into the JAR
//}


//application {
//    mainClass.set("ServerKt")
//}

application {
    mainClass.set("ru.andrewgo.demo.application.ServerKt")
}

// include JS artifacts in any JAR we generate
tasks.getByName<Jar>("jvmJar") {
    val taskName = if (project.hasProperty("isProduction")
        || project.gradle.startParameter.taskNames.contains("installDist")
    ) {
        "jsBrowserProductionWebpack"
    } else {
        "jsBrowserDevelopmentWebpack"
    }
    val webpackTask = tasks.getByName<KotlinWebpack>(taskName)
    dependsOn(webpackTask) // make sure JS gets compiled first
    from(File(webpackTask.destinationDirectory, webpackTask.outputFileName)) // bring output file along into the JAR
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

distributions {
    main {
        contents {
            from("$buildDir/libs") {
                rename("${rootProject.name}-jvm", rootProject.name)
                into("lib")
            }
        }
    }
}

// Alias "installDist" as "stage" (for cloud providers)
tasks.create("stage") {
    dependsOn(tasks.getByName("installDist"))
}

tasks.getByName<JavaExec>("run") {
    classpath(tasks.getByName<Jar>("jvmJar")) // so that the JS artifacts generated by `jvmJar` can be found and served
}

tasks {
    wrapper {
        gradleVersion = "7.4"
    }
}
plugins {
    alias(libs.plugins.kotlin)
    application
}

version = "0.1.0"
group = "io.github.essay97"

repositories {
    maven {
        name = "centralManualTesting"
        url = uri("https://central.sonatype.com/api/v1/publisher/deployments/download/")
        credentials(HttpHeaderCredentials::class)
        authentication {
            create<HttpHeaderAuthentication>("header")
        }
    }
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kastle.lib)
    implementation(libs.clikt)
    implementation(libs.kotter)
    implementation(libs.arrow)
    implementation(libs.kotlinx.datetime)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("io.github.essay97.kastle.MainKt")
    applicationName = "kastle"
}

kotlin {
    jvmToolchain(8)
}

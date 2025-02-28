@file:Suppress("ConvertLambdaToReference")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.8.0"
	id("org.jetbrains.intellij") version "1.13.3"
}

group = "com.chylex.intellij.inspectionlens"
version = "1.3.0"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

kotlin {
	jvmToolchain(17)
}

intellij {
	version.set("2023.1")
	updateSinceUntilBuild.set(false)
	
	plugins.add("tanvd.grazi")
}

tasks.patchPluginXml {
	sinceBuild.set("231")
}

tasks.buildSearchableOptions {
	enabled = false
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.freeCompilerArgs = listOf(
		"-Xjvm-default=all"
	)
}

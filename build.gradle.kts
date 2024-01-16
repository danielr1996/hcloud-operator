import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "codes.danielrichter"
version = "0.1.0"

dependencies {
	/**
	 * Spring Dependencies
	 */
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	/**
	 * Operator Framework
	 */
	implementation("io.javaoperatorsdk:operator-framework-spring-boot-starter:5.4.1")
	implementation("jakarta.validation:jakarta.validation-api:3.1.0-M1")
	annotationProcessor("io.fabric8:crd-generator-apt:6.10.0")

	/**
	 * HCloud
	 */
	implementation("me.tomsdevsn:hetznercloud-api:3.2.2")

	/**
	 * Utilities
	 */
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	testCompileOnly ("org.projectlombok:lombok:1.18.30")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

plugins {
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

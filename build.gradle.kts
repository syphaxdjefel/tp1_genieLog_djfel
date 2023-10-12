import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
  `java-library`
  jacoco
  checkstyle
  pmd
  id("info.solidsoft.pitest") version "1.15.0"
}

repositories {
  mavenCentral()
}

dependencies {
 
  testImplementation("org.pitest:pitest-junit5-plugin:1.2.0")
  testImplementation ("org.hamcrest:hamcrest:2.2")
   testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.0")

}

tasks.test {
  useJUnitPlatform()
  jvmArgs("--enable-preview")
  testLogging {
    showStandardStreams = true
    exceptionFormat = TestExceptionFormat.FULL // SHORT
    events("passed", "skipped", "failed")
  }
}

tasks.withType<JavaCompile>() {
  options.encoding = "UTF-8"
  options.compilerArgs.add("-Xlint:all")
  options.compilerArgs.add("-Xlint:-serial")
  options.compilerArgs.add("--enable-preview")
}

tasks.withType<Checkstyle>().configureEach {
  reports {
    xml.required.set(false)
    html.required.set(true)
    html.stylesheet = resources.text.fromFile("config/checkstyle/checkstyle.xsl")
  }
}

pmd {
  isIgnoreFailures = true
  isConsoleOutput = true
  toolVersion = "6.55.0"
  rulesMinimumPriority.set(5)
  threads.set(4)
  ruleSets = listOf(
    "category/java/bestpractices.xml",
    "category/java/codestyle.xml",
    "category/java/design.xml",
    "category/java/documentation.xml",
    "category/java/errorprone.xml",
    "category/java/multithreading.xml",
    "category/java/performance.xml",
    "category/java/security.xml",
  )
}

pitest {
  targetClasses.set(listOf("com.gildedrose.*"))
  threads.set(4)
  outputFormats.set(listOf("HTML", "XML"))
  timestampedReports.set(false)
}

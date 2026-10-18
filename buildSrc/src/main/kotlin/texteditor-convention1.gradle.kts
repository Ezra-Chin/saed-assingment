plugins{
    java
    pmd
}
repositories{
    mavenCentral()
}
pmd{
    toolVersion = "7.26.0"
    ruleSets = listOf("saed-pmd-rules.xml")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

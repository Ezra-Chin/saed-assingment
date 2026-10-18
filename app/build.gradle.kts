plugins {
    application
    id("texteditor-convention1")
    id("org.openjfx.javafxplugin") version "0.1.0"
    antlr
}

dependencies{
    implementation("com.google.guava:guava:33.6.0-jre")
    antlr("org.antlr:antlr4:4.13.2")
    implementation(project(":api"))
    implementation("org.graalvm.polyglot:polyglot:25.1.3") 
    implementation("org.graalvm.polyglot:js:25.1.3")       // For JavaScript only
}
application{
    mainClass="edu.curtin.texteditor.App"
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.graphics")
}

tasks.generateGrammarSource {
    packageName = "edu.curtin.texteditor"
}

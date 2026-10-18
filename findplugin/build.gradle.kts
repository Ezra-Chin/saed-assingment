plugins {
    id("texteditor-convention1")
}

dependencies{
    implementation("com.google.guava:guava:33.6.0-jre")
    implementation(project(":api"))
}

tasks.withType<Jar> {
    manifest {
        attributes(
            "TextEditor-Plugin-Main-Class" to "edu.curtin.texteditor.findplugin.FindPlugin"
        )
    }
}
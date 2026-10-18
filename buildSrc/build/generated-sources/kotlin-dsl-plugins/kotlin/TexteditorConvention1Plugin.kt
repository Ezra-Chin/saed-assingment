/**
 * Precompiled [texteditor-convention1.gradle.kts][Texteditor_convention1_gradle] script plugin.
 *
 * @see Texteditor_convention1_gradle
 */
public
class TexteditorConvention1Plugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Texteditor_convention1_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}

package androidx.playground

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.gradleEnterprise
import java.net.URI

class GradleEnterpriseConventionsPlugin : Plugin<Settings> {
    override fun apply(settings: Settings) {
        settings.apply(mapOf("plugin" to "com.gradle.enterprise"))

        settings.gradleEnterprise {
            buildScan.apply {
                obfuscation.hostname { "unset" }
            }
        }
    }
}
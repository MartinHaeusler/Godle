package io.github.frontrider.godle.tasks.exec

import io.github.frontrider.godle.dsl.GodleExtension
import io.github.frontrider.godle.initGodotExec
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input

/**
 * Executes the current godot binary, with given arguments.
 * */
@Suppress("LeakingThis")
open class GodotExec : Exec() {

    @Input
    var debug = true

    init {
        initGodotExec(project, this)

        val extension = extensions.getByType(GodleExtension::class.java)
        val version = extension.version.get().majorVersion

        if (debug) {
            args(version.debugFlag)
        }
    }
}
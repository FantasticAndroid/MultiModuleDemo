pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModuleDemo"
include(":app")
include(":core:common")
include(":core:network")
include(":feature:movielist")
include(":feature:moviedetail")
include(":feature:movielist:data")
include(":feature:movielist:domain")
include(":feature:movielist:ui")

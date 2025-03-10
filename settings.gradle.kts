pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "StudyRepo"
include(":app")
include(":kotlin:reflection")
include(":clone-coding:fastcampus-sns:app")
include(":clone-coding:fastcampus-sns:data")
include(":clone-coding:fastcampus-sns:domain")
include(":clone-coding:fastcampus-sns:presentation")
include(":clone-coding:fastcampus-sns:assistedinjection")
include(":clone-coding:fastcampus-sns:hiltextension:app")
include(":clone-coding:fastcampus-sns:hiltextension:annotations")
include(":clone-coding:fastcampus-sns:hiltextension:compiler")
include(":clone-coding:fastcampus-sns:dynamicfeature")

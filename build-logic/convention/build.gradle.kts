plugins {
    `kotlin-dsl`
}

group = "com.jgeun.studyrepo.build-logic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        register("jgeunHiltPlugin") {
            id = "jgeun.hilt.plugin"
            implementationClass = "JGeunHiltPlugin"
        }
    }
}
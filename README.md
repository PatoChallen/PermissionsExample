# Compose Permissions

A library for Jetpack Compose which provides Android runtime permissions.

[![](https://jitpack.io/v/patochallen/compose-permissions.svg)](https://jitpack.io/#patochallen/compose-permissions)

## Introduction

Add Introduction.

## Implementation

You can check [/sample](/sample) directory which includes example application for demonstration.

### 1. Gradle setup

In `build.gradle` of app module, include this dependency
```gradle
dependencies {
    implementation 'com.github.patochallen:compose-permissions:<version>'
}
```

Also make sure that the `repositories` section includes a `maven` section with the `"jitpack"` endpoint. 

```gradle
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

_You can find latest version and changelogs in the [releases](https://github.com/patochallen/compose-permissions/releases)_.

Developed By
-------
Patricio Challen (patochallen) - <patofch@gmail.com>

Contributions
-------
Any contributions are welcome!

# FakeK

![Bintray](https://img.shields.io/bintray/v/codyengel/FakeK/fakek?style=flat-square)
![CircleCI](https://img.shields.io/circleci/build/github/CodyEngel/fakek/master?style=flat-square)
![Codecov](https://img.shields.io/codecov/c/github/codyengel/fakek?style=flat-square)

FakeK is a port of [Java-Faker](http://dius.github.io/java-faker/) for Kotlin. This is in very early development and at
this time will act as a wrapper around Java-Faker for certain fake instances. There is no intention to bring all of the
fakes and instead we will be intentional with what instances to add and which ones to exclude.

## How To Use FakeK

FakeK provides a single function, `fakek`, as an entry point to start accessing all available fakes. The available fakes
are made available by `FakeContext` which is created for each `fakek` function invocation.

```kotlin
data class Person(val firstName: String, val middleName: String, val lastName: String)

fun main() {
    val fakePerson: Person = fakek {
        Person(firstName = fakeName.firstName, middleName = fakeName.middleName, lastName = fakeName.lastName)
    }
    println(fakePerson)
}
```

## Dependencies

FakeK stable releases are available through `jcenter()` and can be added with the following gradle snippets:

```
// Gradle - Groovy
implementation "dev.fakek:fakek:<VERSION>"

// Gradle - Kotlin
implementation("dev.fakek:fakek:<VERSION>")
```

Note that the above examples uses implementation which will add `FakeK` to your production binaries. If you only need
these for unit testing then consider using `testImplementation` instead.

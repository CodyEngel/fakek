# FakeK

[![codecov](https://codecov.io/gh/CodyEngel/fakek/branch/master/graph/badge.svg)](https://codecov.io/gh/CodyEngel/fakek) 
[![CircleCI](https://circleci.com/gh/CodyEngel/fakek.svg?style=shield)](https://circleci.com/gh/CodyEngel/fakek)

FakeK is a port of [Java-Faker](http://dius.github.io/java-faker/) for Kotlin. This is in very early development and at
this time will act as a wrapper around Java-Faker for certain fake instances. There is no intention to bring all of the
fakes and instead we will be intentional with what instances to add and which ones to exclude.

## How To Use FakeK

FakeK provides a single function, `fake`, as an entry point to start accessing all available fakes. The available fakes
are made available by `Fake` which is created for each `fake` function invocation.

```kotlin
data class Person(val firstName: String, val middleName: String, val lastName: String)

fun main() {
    val fakePerson: Person = fake {
        Person(firstName = fakeName.firstName, middleName = fakeName.middleName, lastName = fakeName.lastName)
    }
    println(fakePerson)
}
```

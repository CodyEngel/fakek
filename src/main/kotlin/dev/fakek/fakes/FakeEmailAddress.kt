package dev.fakek.fakes

/**
 * FakeEmailAddress provides a fake email address.
 *
 * @param emailAddress the instance of the fake email address. By default this will make us of a [FakeName] and will be
 * formatted as firstName.lastName@example.com; example.com allows for these emails to be safely persisted and used in
 * staging environments without the fear of spamming actual people.
 */
data class FakeEmailAddress(val emailAddress: String) {
    internal constructor(
        fakeName: FakeName
    ) : this("${fakeName.firstName}.${fakeName.lastName}@example.com".toLowerCase())
}

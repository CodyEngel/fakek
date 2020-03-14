import com.github.javafaker.Faker
import fakes.FakeName

fun <T> fake(fakeBuilder: Fake.() -> T): T {
    val fake = Fake()
    return fake.fakeBuilder()
}

class Fake(private val faker: Faker = Faker.instance()) {
    val fakeName by lazy { FakeName(faker.name()) }
}
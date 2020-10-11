package dev.fakek.fakes

/**
 * FakeDog provides a fake dog which includes name, breed, sound, memePhrase,
 * age, coatLength, gender, size.
 *
 * @param name is the name of the Dog.
 * @param breed is the breed/species of the Dog.
 * @param sound is the the sound of the Dog makes.
 * @param memePhrase is the funny phrase of the Dog.
 * @param age is the age of the Dog.
 * @param coatLength is the length of coat of the Dog.
 * @param gender is the gender of the Dog.
 * @param size is the size of the Dog.
 */
data class FakeDog(
    val name: String,
    val breed: String,
    val sound: String,
    val memePhrase: String,
    val age: String,
    val coatLength: String,
    val gender: String,
    val size: String
) {
    constructor(fakerDog: FakerDog) : this(
        name = fakerDog.name(),
        breed = fakerDog.breed(),
        sound = fakerDog.sound(),
        memePhrase = fakerDog.memePhrase(),
        age = fakerDog.age(),
        coatLength = fakerDog.coatLength(),
        gender = fakerDog.gender(),
        size = fakerDog.size()
    )
}

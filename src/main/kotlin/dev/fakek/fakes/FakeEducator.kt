package dev.fakek.fakes

/**
 * FakeEducator represents the object corresponding to Educator from the Java faker library.
 * <a href="https://github.com/DiUS/java-faker">Educator</a>
 *
 * @param campus
 * @param course
 * @param secondarySchool
 * @param university
 */
data class FakeEducator(
    val campus: String,
    val course: String,
    val secondarySchool: String,
    val university: String
) {
    constructor(fakerEducator: FakerEducator) : this(
        campus = fakerEducator.campus(),
        course = fakerEducator.course(),
        secondarySchool = fakerEducator.secondarySchool(),
        university = fakerEducator.university()
    )
}

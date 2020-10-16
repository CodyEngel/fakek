package dev.fakek.fakes

/**
 * FakeJob provides a fake job which includes the field, keySkills, position, seniority and title.
 * This should include all of the information required to test normal jobs for the United States.
 *
 * @param field is the field of the job such as "Computer Science".
 * @param keySkills is the skills of the job such as "Problem solving".
 * @param position is the type of the position this job refer to such as "Engineer".
 * @param seniority is the rank of the job such as "Lead".
 * @param title is the full title of the job such as "Lead Engineer".
 */
data class FakeJob(
    val field: String,
    val keySkills: String,
    val position: String,
    val seniority: String,
    val title: String
) {
    constructor(fakerJob: FakerJob) : this(
        field = fakerJob.field(),
        keySkills = fakerJob.keySkills(),
        position = fakerJob.position(),
        seniority = fakerJob.seniority(),
        title = fakerJob.title()
    )
}

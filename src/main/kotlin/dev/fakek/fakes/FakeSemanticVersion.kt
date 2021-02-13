package dev.fakek.fakes

import kotlin.random.Random

/**
 * FakeSemanticVersion provides a semantic version which includes major, minor, and patch.
 *
 * @param major is the major number.
 * @param minor is the minor number.
 * @param patch is the patch number.
 */
class FakeSemanticVersion(private var major: Int, private var minor: Int, private var patch: Int) {

    companion object {
        internal const val DEFAULT_START = 0
        internal const val DEFAULT_END = 9
    }

    constructor() : this(
        major = Random.nextInt(DEFAULT_START, DEFAULT_END),
        minor = Random.nextInt(DEFAULT_START, DEFAULT_END),
        patch = Random.nextInt(DEFAULT_START, DEFAULT_END)
    )

    /**
     * Changes the major number.
     */
    fun changeMajor(major: Int) = let { this.major = major }

    /**
     * Changes the minor number.
     */
    fun changeMinor(minor: Int) = let { this.minor = minor }

    /**
     * Changes the patch number.
     */
    fun changePatch(patch: Int) = let { this.patch = patch }

    override fun toString() = "${major}.${minor}.${patch}"

}

package dev.fakek.fakes

/**
 * FakeAvatar provides a fake avatar which includes an image. This image should be safe to download and display in
 * client facing applications.
 *
 * @param image is the url for the image resource which can be downloaded and displayed.
 */
data class FakeAvatar(val image: String) {
    constructor(fakerAvatar: FakerAvatar) : this(image = fakerAvatar.image())
}

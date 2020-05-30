package dev.fakek.fakes

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.*
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.*

internal class FakeCreditCardTest {

    @Test
    fun `given an cvc that is too short, when generateCvc is invoked, an IllegalArgumentException should be thrown`() {
        val invalidLength = (Int.MIN_VALUE..2).random()

        expectThrows<IllegalArgumentException> { FakeCreditCard.generateCvc(invalidLength) }
    }

    @Test
    fun `given an cvc that is too long, when generateCvc is invoked, an IllegalArgumentException should be thrown`() {
        val invalidLength = (5..Int.MAX_VALUE).random()

        expectThrows<IllegalArgumentException> { FakeCreditCard.generateCvc(invalidLength) }
    }

    @Test
    fun `given a brand index of 1, when create is invoked, then the card should be a visa`() {
        expectThat(FakeCreditCard.create(1).cardBrand).isEqualTo(CreditCardBrand.Visa)
    }

    @Test
    fun `given a brand index of 2, when create is invoked, then the card should be a mastercard`() {
        expectThat(FakeCreditCard.create(2).cardBrand).isEqualTo(CreditCardBrand.Mastercard)
    }

    @Test
    fun `given a brand index of 3, when create is invoked, then the card should be an american express`() {
        expectThat(FakeCreditCard.create(3).cardBrand).isEqualTo(CreditCardBrand.AmericanExpress)
    }

    @Test
    fun `given a brand index of 4, when create is invoked, then the card should be a discover`() {
        expectThat(FakeCreditCard.create(4).cardBrand).isEqualTo(CreditCardBrand.Discover)
    }

    @Test
    fun `given a brand index of 5, when create is invoked, then a RuntimeException should be thrown`() {
        expectThrows<RuntimeException> { FakeCreditCard.create(5) }
    }

    @Test
    fun `given a Visa card brand, when toString is invoked, then the value should be Visa`() {
        expectThat(CreditCardBrand.Visa.toString()).isEqualTo("Visa")
    }

    @Test
    fun `given a Mastercard card brand, when toString is invoked, then the value should be Mastercard`() {
        expectThat(CreditCardBrand.Mastercard.toString()).isEqualTo("Mastercard")
    }

    @Test
    fun `given an AmericanExpress card brand, when toString is invoked, then the value should be American Express`() {
        expectThat(CreditCardBrand.AmericanExpress.toString()).isEqualTo("American Express")
    }

    @Test
    fun `given a Discover card brand, when toString is invoked, then the value should be Discover`() {
        expectThat(CreditCardBrand.Discover.toString()).isEqualTo("Discover")
    }

    private val fakeVisa by lazy { FakeCreditCard(CreditCardBrand.Visa) }

    @Test
    fun `given a visa credit card, the card brand should be visa`() {
        expectThat(fakeVisa.cardBrand).isEqualTo(CreditCardBrand.Visa)
    }

    @Test
    fun `given a visa credit card, the card number should be a valid test credit card number`() {
        val validVisaCreditCardNumbers = listOf(
            "4242424242424242",
            "4111111111111111",
            "4012888888881881",
            "4222222222222"
        )

        expectThat(validVisaCreditCardNumbers).contains(fakeVisa.cardNumber)
    }

    @Test
    fun `given a visa credit card, the cvc should have 3 digits`() {
        expectThat(fakeVisa.cardCvc).hasLength(3)
    }

    @Test
    fun `given a visa credit card, the cvc should only contain digits`() {
        expectThat(fakeVisa.cardCvc).matches("\\d{3}".toRegex())
    }
    
    @Test
    fun `given a visa credit card, the expiration date should be 5 characters`() {
        expectThat(fakeVisa.cardExpirationDate).hasLength(5)
    }

    @Test
    fun `given a visa credit card, the expiration date should be formatted month year`() {
        expectThat(fakeVisa.cardExpirationDate).matches("\\d{2}\\/\\d{2}".toRegex())
    }
    
    @Test
    fun `given a visa credit card, the expiration date should be in the future`() {
        val cardExpirationDate = SimpleDateFormat(FakeCreditCard.CREDIT_CARD_EXPIRATION_DATE_PATTERN)
            .parse(fakeVisa.cardExpirationDate)

        expectThat(cardExpirationDate).isGreaterThan(Date())
    }

    private val fakeMastercard by lazy { FakeCreditCard(CreditCardBrand.Mastercard) }

    @Test
    fun `given a mastercard credit card, the card brand should be mastercard`() {
        expectThat(fakeMastercard.cardBrand).isEqualTo(CreditCardBrand.Mastercard)
    }

    @Test
    fun `given a mastercard credit card, the card number should be a valid test credit card number`() {
        val validMastercardCreditCardNumbers = listOf(
            "5555555555554444",
            "5105105105105100"
        )

        expectThat(validMastercardCreditCardNumbers).contains(fakeMastercard.cardNumber)
    }

    @Test
    fun `given a mastercard credit card, the cvc should have 3 digits`() {
        expectThat(fakeMastercard.cardCvc).hasLength(3)
    }

    @Test
    fun `given a mastercard credit card, the cvc should only contain digits`() {
        expectThat(fakeMastercard.cardCvc).matches("\\d{3}".toRegex())
    }

    @Test
    fun `given a mastercard credit card, the expiration date should be 5 characters`() {
        expectThat(fakeMastercard.cardExpirationDate).hasLength(5)
    }

    @Test
    fun `given a mastercard credit card, the expiration date should be formatted month year`() {
        expectThat(fakeMastercard.cardExpirationDate).matches("\\d{2}\\/\\d{2}".toRegex())
    }

    @Test
    fun `given a mastercard credit card, the expiration date should be in the future`() {
        val cardExpirationDate = SimpleDateFormat(FakeCreditCard.CREDIT_CARD_EXPIRATION_DATE_PATTERN)
            .parse(fakeMastercard.cardExpirationDate)

        expectThat(cardExpirationDate).isGreaterThan(Date())
    }

    private val fakeDiscover by lazy { FakeCreditCard(CreditCardBrand.Discover) }

    @Test
    fun `given a discover credit card, the card brand should be discover`() {
        expectThat(fakeDiscover.cardBrand).isEqualTo(CreditCardBrand.Discover)
    }

    @Test
    fun `given a discover credit card, the card number should be a valid test credit card number`() {
        val validDiscoverCreditCardNumbers = listOf(
            "6011111111111117",
            "6011000990139424"
        )

        expectThat(validDiscoverCreditCardNumbers).contains(fakeDiscover.cardNumber)
    }

    @Test
    fun `given a discover credit card, the cvc should have 3 digits`() {
        expectThat(fakeDiscover.cardCvc).hasLength(3)
    }

    @Test
    fun `given a discover credit card, the cvc should only contain digits`() {
        expectThat(fakeDiscover.cardCvc).matches("\\d{3}".toRegex())
    }

    @Test
    fun `given a discover credit card, the expiration date should be 5 characters`() {
        expectThat(fakeDiscover.cardExpirationDate).hasLength(5)
    }

    @Test
    fun `given a discover credit card, the expiration date should be formatted month year`() {
        expectThat(fakeDiscover.cardExpirationDate).matches("\\d{2}\\/\\d{2}".toRegex())
    }

    @Test
    fun `given a discover credit card, the expiration date should be in the future`() {
        val cardExpirationDate = SimpleDateFormat(FakeCreditCard.CREDIT_CARD_EXPIRATION_DATE_PATTERN)
            .parse(fakeDiscover.cardExpirationDate)

        expectThat(cardExpirationDate).isGreaterThan(Date())
    }

    private val fakeAmericanExpress by lazy { FakeCreditCard(CreditCardBrand.AmericanExpress) }

    @Test
    fun `given an american express credit card, the card brand should be american express`() {
        expectThat(fakeAmericanExpress.cardBrand).isEqualTo(CreditCardBrand.AmericanExpress)
    }

    @Test
    fun `given an american express credit card, the card number should be a valid test credit card number`() {
        val validDiscoverCreditCardNumbers = listOf(
            "378282246310005",
            "371449635398431"
        )

        expectThat(validDiscoverCreditCardNumbers).contains(fakeAmericanExpress.cardNumber)
    }

    @Test
    fun `given an american express credit card, the cvc should have 4 digits`() {
        expectThat(fakeAmericanExpress.cardCvc).hasLength(4)
    }

    @Test
    fun `given an american express card, the cvc should only contain digits`() {
        expectThat(fakeAmericanExpress.cardCvc).matches("\\d{4}".toRegex())
    }

    @Test
    fun `given an american express credit card, the expiration date should be 5 characters`() {
        expectThat(fakeAmericanExpress.cardExpirationDate).hasLength(5)
    }

    @Test
    fun `given an american express credit card, the expiration date should be formatted month year`() {
        expectThat(fakeAmericanExpress.cardExpirationDate).matches("\\d{2}\\/\\d{2}".toRegex())
    }

    @Test
    fun `given an american express credit card, the expiration date should be in the future`() {
        val cardExpirationDate = SimpleDateFormat(FakeCreditCard.CREDIT_CARD_EXPIRATION_DATE_PATTERN)
            .parse(fakeAmericanExpress.cardExpirationDate)

        expectThat(cardExpirationDate).isGreaterThan(Date())
    }
}
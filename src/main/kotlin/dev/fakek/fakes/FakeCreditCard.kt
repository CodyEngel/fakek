package dev.fakek.fakes

import java.text.SimpleDateFormat
import java.util.*

/**
 * FakeCreditCard provides a fake credit card number that is safe for testing purposes. Currently this implementation
 * makes use of the following sources for credit card numbers:
 *  * Stripe Basic Test Card Numbers - https://stripe.com/docs/testing
 *  * PayPay Objects - https://www.paypalobjects.com/en_US/vhelp/paypalmanager_help/credit_card_numbers.htm
 *
 * The credit cards created with this class are intended for use in staging environments since the sources for these
 * cards are taken from payment provider's API integration documentation. Creating a FakeCreditCard with only a
 * [CreditCardBrand] is the easiest way to credit a valid credit card for a given brand.
 *
 * Alternatively you can create a valid credit card for one brand and use the [copy] function with a different
 * [CreditCardBrand] to create an invalid card. For example:
 *
 * ```
 * val validVisa = FakeCreditCard(CreditCardBrand.Visa)
 * val invalidMastercard = validVisa.copy(CreditCardBrand.Mastercard)
 * ```
 *
 * @param cardBrand the instance of the FakeCreditCard's brand. Some examples of [CreditCardBrand] are: Visa,
 * Mastercard, Discover, and American Express.
 * @param cardNumber the credit card number, this is based off of the [CreditCardBrand].
 * @param cardCvc is the credit card's card verification code, this will be random with a length based on the
 * [CreditCardBrand].
 * @param cardExpirationDate is the credit card's expiration date, this is guaranteed to be sometime in the future.
 * All expiration dates will be formatted using the [CREDIT_CARD_EXPIRATION_DATE_PATTERN]
 */
data class FakeCreditCard(
    val cardBrand: CreditCardBrand,
    val cardNumber: String = cardBrand.validCardNumber,
    val cardCvc: String = generateCvc(cardBrand.cvcLength),
    val cardExpirationDate: String = generateValidDate()
) {
    companion object {
        internal fun generateCvc(length: Int): String {
            @Suppress("MagicNumber")
            return when (length) {
                CreditCardBrand.STANDARD_CVC_LENGTH -> (100..999).random().toString()
                CreditCardBrand.AMERICAN_EXPRESS_CVC_LENGTH -> (1000..9999).random().toString()
                else -> throw IllegalArgumentException("Expected a length of 3 or 4 but was $length")
            }
        }

        internal fun generateValidDate(): String {
            val calendar = Calendar.getInstance()
            @Suppress("MagicNumber")
            calendar.add(Calendar.YEAR, 3)
            return SimpleDateFormat(CREDIT_CARD_EXPIRATION_DATE_PATTERN).format(calendar.time)
        }

        @Suppress("MagicNumber")
        internal fun create(cardBrandIndex: Int = (1..4).random()): FakeCreditCard {
            val creditCardBrand = when (cardBrandIndex) {
                1 -> CreditCardBrand.Visa
                2 -> CreditCardBrand.Mastercard
                3 -> CreditCardBrand.AmericanExpress
                4 -> CreditCardBrand.Discover
                else -> {
                    @Suppress("TooGenericExceptionThrown")
                    throw RuntimeException(
                        "Failed to get CreditCardBrand, expected number between 1 and 4 but actual value" +
                                " was $cardBrandIndex"
                    )
                }
            }
            return FakeCreditCard(creditCardBrand)
        }

        /**
         * All fake credit cards will be formatted as monthmonth/yearyear, for example May 2020 would be 05/20.
         */
        const val CREDIT_CARD_EXPIRATION_DATE_PATTERN = "MM/yy"
    }
}

/**
 * CreditCardBrand provides all of the available CreditCardBrand's available for fakes.
 */
sealed class CreditCardBrand {
    protected abstract val brandName: String
    internal abstract val cvcLength: Int
    internal abstract val validCardNumber: String

    /**
     * Visa represents the regular Visa credit card brand.
     */
    object Visa : CreditCardBrand() {
        override val brandName: String = "Visa"
        override val cvcLength: Int = STANDARD_CVC_LENGTH
        override val validCardNumber: String
            get() = "4242424242424242"
    }

    /**
     * Mastercard represents the regular Mastercard credit card brand.
     */
    object Mastercard : CreditCardBrand() {
        override val brandName: String = "Mastercard"
        override val cvcLength: Int = STANDARD_CVC_LENGTH
        override val validCardNumber: String
            get() = "5555555555554444"
    }

    /**
     * AmericanExpress represents the regular American Express credit card brand.
     */
    object AmericanExpress : CreditCardBrand() {
        override val brandName: String = "American Express"
        override val cvcLength: Int = AMERICAN_EXPRESS_CVC_LENGTH
        override val validCardNumber: String
            get() = "378282246310005"
    }

    /**
     * Discover represents the regular Discover credit card brand.
     */
    object Discover : CreditCardBrand() {
        override val brandName: String = "Discover"
        override val cvcLength: Int = STANDARD_CVC_LENGTH
        override val validCardNumber: String
            get() = "6011111111111117"

    }

    override fun toString(): String = brandName

    companion object {
        internal const val STANDARD_CVC_LENGTH = 3
        internal const val AMERICAN_EXPRESS_CVC_LENGTH = 4
    }
}

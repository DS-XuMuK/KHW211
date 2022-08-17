import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTransferFee_default() {
        val result = calculateTransferFee(amount = 500_00)
        assertEquals(0, result)
    }

    @Test
    fun calculateTransferFee_maestro() {
        val amount = 1500_00
        val transfersThisMonth = 75000_00
        val cartType = "Maestro"

        val result = calculateTransferFee(
            amount = amount,
            transfersThisMonth = transfersThisMonth,
            cartType = cartType
        )

        assertEquals(2900, result)
    }

    @Test
    fun calculateTransferFee_mastercard() {
        val amount = 15500_00
        val transfersThisMonth = 500_00
        val cartType = "Mastercard"

        val result = calculateTransferFee(
            amount = amount,
            transfersThisMonth = transfersThisMonth,
            cartType = cartType
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateTransferFee_visa() {
        val amount = 100000_00
        val cartType = "Visa"

        val result = calculateTransferFee(
            amount = amount,
            cartType = cartType
        )

        assertEquals(75000, result)
    }
}
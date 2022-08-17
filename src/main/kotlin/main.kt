fun main() {
    val fee = calculateTransferFee(125000_00, cartType = "Mastercard")
    println("Transfer fee is $fee")
}

fun calculateTransferFee(amount: Int, transfersThisMonth: Int = 0, cartType: String = "Vk Pay"): Int {
    return when (cartType) {
        "Vk Pay" -> 0
        "Mastercard", "Maestro" -> if (amount + transfersThisMonth <= 75000_00) 0 else (amount * 0.006).toInt() + 2000
        else -> if ((amount * 0.0075).toInt() > 3500) (amount * 0.0075).toInt() else 3500
    }
}
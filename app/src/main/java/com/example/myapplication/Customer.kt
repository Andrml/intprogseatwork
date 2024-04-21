import java.io.Serializable

data class Customer(
    val number: Int,
    val name: String,
    val type: String,
    val image: Int,
    var transactions: List<Transaction> = emptyList()
) : Serializable

data class Transaction(
    val month: String,
    val amount: Int = 0
) : Serializable

class Customers : Serializable {
    private val listOfCustomers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        listOfCustomers.add(customer)
    }

    fun getCustomers() = listOfCustomers.toList()
}

class Transactions : Serializable {
    private val listOfTransactions = mutableMapOf<Int, MutableList<Transaction>>()

    fun addTransaction(number: Int, transaction: Transaction) {
        if (!listOfTransactions.containsKey(number)) {
            listOfTransactions[number] = mutableListOf()
        }
        listOfTransactions[number]?.add(transaction)
    }

    fun getCountOfTransactions(number: Int): List<Transaction>? {
        return listOfTransactions[number]
    }

    fun clearTransactions() {
        listOfTransactions.clear()
    }
}
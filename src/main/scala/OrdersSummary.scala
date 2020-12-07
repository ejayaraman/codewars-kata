import scala.util.matching.Regex

object OrdersSummary {
  val stockPattern = "(^\\w+\\.?\\w+)"
  val quantityPattern = "([0-9]+)"
  val pricePattern = "([0-9]+\\.[0-9]+)"
  val orderType = "([B|S])"
  val orderPattern: Regex = s"$stockPattern\\s$quantityPattern\\s$pricePattern\\s$orderType".r
  val buy: String = "B"
  val sell: String = "S"

  def findTransactions: (String, String) => Double = { (order, orderType) =>
    order.trim match {
      case orderPattern(_, quantity, price, status) if status == orderType =>
        quantity.toInt * price.toDouble
      case _ => 0
    }
  }

  def balanceStatements(lst: String): String = {
    val orders: List[String] = lst.split(',').toList
    val bought = orders.map(findTransactions(_, buy)).sum.round
    val sold = orders.map(findTransactions(_, sell)).sum.round
    val badOrders = orders.filterNot(_.trim.matches(orderPattern.regex)).map(_.trim)
    if (badOrders.isEmpty || badOrders.flatten.isEmpty)
      s"Buy: $bought Sell: $sold"
    else
      s"Buy: $bought Sell: $sold; Badly formed ${badOrders.size}: ${badOrders.mkString(" ;")} ;"
  }
}
import scala.util.matching.Regex

//TODO: Refactor
object OrdersSummary {
  val orderPattern: Regex = "(^\\w+\\.?\\w+)\\s([0-9]+)\\s([0-9]+\\.[0-9]+)\\s([B|S])".r

  def buySellFunc: (String, String) => Double = { (order, orderType) =>
    order.trim match {
      case orderPattern(stock, quantity, price, status) if status == orderType =>
        quantity.toInt * price.toDouble
      case _ => 0
    }
  }

  def balanceStatements(lst: String): String = {
    val orders: List[String] = lst.split(',').toList
    val bought = orders.map(buySellFunc(_, "B")).sum.round
    val sold = orders.map(buySellFunc(_, "S")).sum.round
    val badOrders = orders.filterNot(_.trim.matches(orderPattern.regex)).map(_.trim)
    if (badOrders.isEmpty || badOrders.flatten.isEmpty)
      s"Buy: $bought Sell: $sold"
    else
      s"Buy: $bought Sell: $sold; Badly formed ${badOrders.size}: ${badOrders.mkString(" ;")} ;"
  }
}
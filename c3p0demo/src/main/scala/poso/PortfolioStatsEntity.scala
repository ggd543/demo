package poso


import java.util.Date

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-12-9
 * Time: 22:24:27
 * To change this template use File | Settings | File Templates.
 */

class PortfolioStatsEntity {
  var portfolioStatsId: java.lang.Long = _
  var portfolioId: java.lang.Long = _
  var returnValue: java.lang.Double = _
  var date: Date = _

  override def hashCode = portfolioStatsId.intValue

  override def equals(obj: Any): Boolean = obj match {
    case null => false
    case that: PortfolioStatsEntity =>
      if (portfolioStatsId == that.portfolioStatsId && portfolioId == that.portfolioId
              && returnValue == that.returnValue && date == that.date)
        true
      else
        false
  }

}

class PortfolioDate(portfolioId: java.lang.Long, date: Date)
package controllers.asset

import play.mvc.Controller
import play.mvc.results.{RenderText}
import controllers.{FinportfolioController, ExceptionHandler, AutheticationHandler, RestController}

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-11-27
 * Time: 23:18:06
 * To change this template use File | Settings | File Templates.
 */

import play.utils.Scala._

object AssetController extends FinportfolioController {
  def getAssetsOverview(tickers: String) = {
    throw new RuntimeException("exception");
    play.info("getAssetsOverview")
    ?(null) match {
      case Some(e) => play.info("not null")
      case None => play.info("null")
    }
    Text("getAssetOverview")
  }

  def getAssetsDailyData(tickers: String) = {
    Text("getAssetDailyData")
  }

  def getAssetsStats(tickers: String) = {
    Ok
  }

  def getAssetsCorrel(tickers: String) = {
    //    Json("getAssetsCorrel")
    NotFound
  }

  def getRelatedAssets(ticker: String) = {
    Json("getRelatedAssets")
  }

  def getAssets(tickers: String) = {
    play.info("getAssets(%s)", tickers)
    Json("getAssets")
  }


}

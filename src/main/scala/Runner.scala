import scala.concurrent.Await
import scala.concurrent.duration.Duration
import db.Connector
import mbti.{MbtiRepo, MbtiService}
import scala.concurrent.ExecutionContext.Implicits.global

object Runner {

  def main(args: Array[String]): Unit = {
    val connector = new Connector()
    val mbtiRepo = new MbtiRepo(connector)
    val mbtiService = new MbtiService(mbtiRepo)
    mbtiService.init()
    runBot(mbtiService)
  }

  def runBot(mbtiService: MbtiService) = {
    val bot = new telegram.Bot(mbtiService)
    val eol = bot.run()
    println("Press [ENTER] to shutdown the bot, it may take a few seconds...")
    scala.io.StdIn.readLine()
    bot.shutdown()
    Await.result(eol, Duration.Inf)
  }
}

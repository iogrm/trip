import scala.concurrent.Await
import scala.concurrent.duration.Duration
import db.Connector
import persona.{PersonaRepo, PersonaService}
import scala.concurrent.ExecutionContext.Implicits.global
import place.PlaceService
import place.PlaceRepo

object Runner {

  def main(args: Array[String]): Unit = {
    val connector = new Connector()
    val personaService = personaModule(connector)
    val placeService = placeModule(connector)
    runBot(personaService, placeService)
  }

  def runBot(personaService: PersonaService, placeService: PlaceService) = {
    val bot = new telegram.Bot(personaService, placeService)
    val eol = bot.run()
    println("Press [ENTER] to shutdown the bot, it may take a few seconds...")
    scala.io.StdIn.readLine()
    bot.shutdown()
    Await.result(eol, Duration.Inf)
  }

  def personaModule(connector: Connector): PersonaService = {
    val personaRepo = new PersonaRepo(connector)
    val personaService = new PersonaService(personaRepo)
    personaService.init()
    personaService
  }

  def placeModule(connector: Connector): PlaceService = {
    val placeRepo = new PlaceRepo(connector)
    val placeService = new PlaceService(placeRepo)
    placeService.init()
    placeService
  }
}

package telegram

import java.net.URLEncoder

import cats.instances.future._
import cats.syntax.functor._
import com.bot4s.telegram.Implicits._
import com.bot4s.telegram.api.declarative._
import com.bot4s.telegram.api.ChatActions
import com.bot4s.telegram.future.Polling
import com.bot4s.telegram.methods._
import com.bot4s.telegram.models._

import scala.concurrent.Future
import com.bot4s.telegram.api.RequestHandler
import com.bot4s.telegram.clients.ScalajHttpClient
import com.bot4s.telegram.future.TelegramBot
import java.nio.file.Paths
import persona.PersonaService
import persona.model.Persona
import place.model.Place
import place.PlaceService

class Bot(personaService: PersonaService, placeService: PlaceService)
    extends TelegramBot
    with Polling
    with Commands[Future]
    with InlineQueries[Future]
    with ChatActions[Future] {

  val ilufarToken = "7299741842:AAEX2BxTDBAFS-rgwZx2-aDnKfRjmwlwbwo"
  val mbtiToken = "7403658824:AAHYEngZP91B7FG3aoROgTbb6aP89CNQAxk"

  override val client: RequestHandler[Future] = new ScalajHttpClient(
    mbtiToken
  )
  onCommand("start") { implicit msg =>
    withArgs { args =>
      val text =
        "if you don't know your mbti please go to this link: https://www.16personalities.com/free-personality-test,\n on the otherhand please give us your mbti "
      for {
        _ <- request(
          SendMessage(
            msg.source,
            text
          )
        )
      } yield ()
    }
  }

  onCommand("destination") { implicit msg =>
    withArgs { args =>
      val mbti = args.mkString(" ")

      for {
        personaOption <- personaService.find(mbti)
        persona = personaOption.get if personaOption.isDefined
        placeOption <- placeService.findByMbti(persona.mbti)
        place = placeOption.get if placeOption.isDefined
        r <- Future { scalaj.http.Http(place.img).asBytes }
        if r.isSuccess
        bytes = r.body
        pic = InputFile("pic", bytes)
        _ <- request(
          SendPhoto(
            msg.source,
            pic,
            getText(persona, place)
          )
        )
      } yield ()
    }
  }

  def getText(persona: Persona, place: Place): String = {
    s""" 
      \n${persona.mbti.toUpperCase()} - ${persona.role.capitalize}
      \n${place.name.capitalize}, ${place.country.capitalize} 
      \n${persona.description}
    """
  }

}

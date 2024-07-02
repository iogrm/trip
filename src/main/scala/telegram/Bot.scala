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
import mbti.MbtiService
import model.Persona

class Bot(service: MbtiService)
    extends TelegramBot
    with Polling
    with Commands[Future]
    with InlineQueries[Future]
    with ChatActions[Future] {

  val ilufarToken = "7299741842:AAEX2BxTDBAFS-rgwZx2-aDnKfRjmwlwbwo"

  override val client: RequestHandler[Future] = new ScalajHttpClient(
    ilufarToken
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
        persona <- service.find(mbti)
        p = persona.get if persona.isDefined
        r <- Future { scalaj.http.Http(p.img).asBytes }
        if r.isSuccess
        bytes = r.body
        pic = InputFile("pic", bytes)
        _ <- request(
          SendPhoto(
            msg.source,
            pic,
            getText(p)
          )
        )
      } yield ()
    }
  }

  def getText(persona: Persona): String = {
    s""" 
      \n${persona.mbti} - ${persona.role}
      \n${persona.place}
      \n${persona.description}
    """
  }

}

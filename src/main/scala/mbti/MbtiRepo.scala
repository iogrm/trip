package mbti

import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.bson.{BSONDocument, BSONDocumentHandler}
import db.Connector
import scala.util.Try
import reactivemongo.api.Cursor
import reactivemongo.api.bson.{Macros, BSONObjectID}
import model.Persona
import model.PersonaId

class MbtiRepo(connector: Connector) {

  private val col = connector.mbtis

  import mbti.bson.PersonaIdBsonSupport.personaIdHandler
  private implicit val personaHandler: BSONDocumentHandler[Persona] =
    Macros.handler[Persona]
  def getOne(
      personaId: PersonaId
  )(implicit ec: ExecutionContext): Future[Option[Persona]] = {
    val query = BSONDocument("_id" -> personaId)
    col.find(query).one[Persona]
  }

  def getAll()(implicit ec: ExecutionContext): Future[List[Persona]] = {
    col
      .find(BSONDocument())
      .cursor[Persona]()
      .collect[List](-1, Cursor.FailOnError[List[Persona]]())
  }

  def insert(
      persona: Persona
  )(implicit ec: ExecutionContext): Future[Unit] =
    col
      .insert(false)
      .one(persona)
      .map(_ => ())
}

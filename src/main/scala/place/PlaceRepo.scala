package place

import scala.concurrent.{ExecutionContext, Future}
import reactivemongo.api.bson.{BSONDocument, BSONDocumentHandler}
import db.Connector
import scala.util.Try
import reactivemongo.api.Cursor
import reactivemongo.api.bson.{Macros, BSONObjectID}
import place.model.{Place, PlaceId}

class PlaceRepo(connector: Connector) {

  private val col = connector.places

  import place.bson.PlaceIdBsonSupport.placeIdHandler
  private implicit val placeHandler: BSONDocumentHandler[Place] =
    Macros.handler[Place]
  def getOne(
      mbti: String
  )(implicit ec: ExecutionContext): Future[Option[Place]] = {
    val query = BSONDocument("mbti" -> mbti)
    col.find(query).one[Place]
  }

  def getAll()(implicit ec: ExecutionContext): Future[List[Place]] = {
    col
      .find(BSONDocument())
      .cursor[Place]()
      .collect[List](-1, Cursor.FailOnError[List[Place]]())
  }

  def insert(
      place: Place
  )(implicit ec: ExecutionContext): Future[Unit] =
    col
      .insert(false)
      .one(place)
      .map(_ => ())
}

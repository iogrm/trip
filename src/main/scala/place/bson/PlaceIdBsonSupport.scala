package place.bson

import reactivemongo.api.bson.BSONHandler
import reactivemongo.api.bson.Macros
import place.model.PlaceId

object PlaceIdBsonSupport {
  implicit val placeIdHandler: BSONHandler[PlaceId] =
    Macros.handler[PlaceId]
}

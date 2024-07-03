package persona.bson

import reactivemongo.api.bson.BSONHandler
import reactivemongo.api.bson.Macros
import persona.model.PersonaId

object PersonaIdBsonSupport {
  implicit val personaIdHandler: BSONHandler[PersonaId] =
    Macros.handler[PersonaId]
}

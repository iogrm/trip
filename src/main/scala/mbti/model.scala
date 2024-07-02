package model

import common.Id

final case class PersonaId(value: String) extends AnyVal with Id

final case class Persona(
    _id: PersonaId,
    mbti: String,
    role: String,
    img: String,
    description: String,
    place: String
)

package place.model

import common.Id

final case class PlaceId(value: String) extends AnyVal with Id

final case class Place(
    _id: PlaceId,
    name: String,
    country: String,
    img: String,
    mbti: String
)

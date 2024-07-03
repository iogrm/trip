package place

import place.model.{Place, PlaceId}

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import java.util.UUID

class PlaceService(repo: PlaceRepo) {

  def randomId = UUID.randomUUID().toString()

  def findByMbti(
      str: String
  )(implicit ec: ExecutionContext): Future[Option[Place]] = {
    val place = repo.getOne(str)
    place.andThen(x => {
      println(str)
      println(x)
    })
    place
  }

  def init()(implicit ec: ExecutionContext) = {
    val intj = new Place(
      new PlaceId(randomId),
      "ephesus",
      "turkey",
      "https://cdn.jacksflightclub.com/id/6881404fd6300a25f6193498ece65c0c2a08c998",
      "intj"
    )

    val intp = new Place(
      new PlaceId(randomId),
      "atacama",
      "chile",
      "https://cdn.jacksflightclub.com/id/caae793293d825ee9f09ccddb51c013d72fcdb5e",
      "intp"
    )

    val entj = new Place(
      new PlaceId(randomId),
      "merida",
      "mexico",
      "https://d20k4h1q6oowm6.cloudfront.net/id/72062569e25f362cd77dcdd90d3e70e5bfe57374",
      "entj"
    )

    val entp = new Place(
      new PlaceId(randomId),
      "kuala lumpur",
      "malaysia",
      "https://cdn.jacksflightclub.com/id/5bc123214717a7bf46dcb5431a9d930292b72606",
      "entp"
    )

    val infj = new Place(
      new PlaceId(randomId),
      "Rio Celeste",
      "Costa Rica",
      "https://cdn.jacksflightclub.com/id/d267a26cdc1438b24be3aee29c29e76f39302ba4",
      "infj"
    )

    val infp = new Place(
      new PlaceId(randomId),
      "New York",
      "USA",
      "https://d20k4h1q6oowm6.cloudfront.net/id/ea6712ed0d099c45fd602b17055d1e085279b9f4",
      "infp"
    )

    val enfj = new Place(
      new PlaceId(randomId),
      "Alberobello",
      "Italy",
      "https://cdn.jacksflightclub.com/id/8cf777a302bd92a387ac1454283198e856c32078",
      "enfj"
    )

    val enfp = new Place(
      new PlaceId(randomId),
      "New Orleans",
      "USA",
      "https://cdn.jacksflightclub.com/id/7b629ef24e933ad5cc65f99567a3404bc7c41786",
      "enfp"
    )

    val esfp = new Place(
      new PlaceId(randomId),
      "St. Lucia",
      "West Indies",
      "https://cdn.jacksflightclub.com/id/dee4c85c5bb62b8693f9d38323245e52d046d6f5",
      "esfp"
    )

    val estp = new Place(
      new PlaceId(randomId),
      "Pokhara",
      "Nepal",
      "https://cdn.jacksflightclub.com/id/300d93b622fdd5c60a89849f8363e872d5267dcb",
      "estp"
    )

    val istp = new Place(
      new PlaceId(randomId),
      "Tokyo",
      "Japan",
      "https://cdn.jacksflightclub.com/id/0bfc2d8f4be1f6b7a050eaa0675b4770c6091d08",
      "istp"
    )

    val isfp = new Place(
      new PlaceId(randomId),
      "Kenai Peninsula",
      "alaska",
      "https://cdn.jacksflightclub.com/id/4fa485b366803a23e6b8f0dfe54729c6884cdbed",
      "isfp"
    )

    val esfj = new Place(
      new PlaceId(randomId),
      "Los Angeles",
      "USA",
      "https://cdn.jacksflightclub.com/id/a525364a315a48f89be9dd9fa2964fb9f88d3687",
      "esfj"
    )

    val estj = new Place(
      new PlaceId(randomId),
      "Rio de Janeiro",
      "Brazil",
      "https://cdn.jacksflightclub.com/id/dadf63813e05221e8ecd3b6309be15d970bd4b8f",
      "estj"
    )

    val isfj = new Place(
      new PlaceId(randomId),
      "Alberta",
      "Canada",
      "https://cdn.jacksflightclub.com/id/48c29066d7f2ccb5e0a4f0f064dbf178c3034f9a",
      "isfj"
    )

    val istj = new Place(
      new PlaceId(randomId),
      "Alexandria",
      "Egypt",
      "https://cdn.jacksflightclub.com/id/d79bad64e5c9da12955472d7a841b3fdcca4bec9",
      "istj"
    )

    repo.insert(intj)
    repo.insert(intp)
    repo.insert(infj)
    repo.insert(infp)
    repo.insert(istj)
    repo.insert(istp)
    repo.insert(isfj)
    repo.insert(isfp)
    repo.insert(entj)
    repo.insert(entp)
    repo.insert(enfj)
    repo.insert(enfp)
    repo.insert(estj)
    repo.insert(estp)
    repo.insert(esfj)
    repo.insert(esfp)
  }
}

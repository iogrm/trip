package mbti

import model.Persona
import model.PersonaId
import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class MbtiService(repo: MbtiRepo) {
  def init()(implicit ec: ExecutionContext) = {
    val intj = new Persona(
      new PersonaId("intj"),
      "INTJ",
      "Architects",
      "https://cdn.jacksflightclub.com/id/6881404fd6300a25f6193498ece65c0c2a08c998",
      "Architects are on a constant quest for knowledge - even holidays can't get in the way of learning.\nAs an Architect, you prefer to spend time planning your holidays rather than taking spontaneous trips. And true to your Analyst's roots - you enjoy ditching tourist traps for more thought-provoking activities. You'll take calming experiences over thrilling ones, but you're probably not too keen on resorts. ",
      "Ephesus, Turkey"
    )

    val intp = new Persona(
      new PersonaId("intp"),
      "INTP",
      "Logicians",
      "https://cdn.jacksflightclub.com/id/caae793293d825ee9f09ccddb51c013d72fcdb5e",
      "Logicians are the living embodiment of the thinker statue. You lose yourself in thought, and you’re often seen as pensive and reserved. You love analyzing patterns in almost everything and thinking through abstract ideas.\nTravel-wise, we figure you enjoy melting into countries and cultures to get an idea of how other parts of the world function. You aren't keen on travel packages and need a push to try new things. But, like your Architect counterparts - you prefer calming trips that don't involve tourist traps.",
      "Atacama, Chile"
    )
    repo.insert(intj)
    repo.insert(intp)
  }
  def find(
      str: String
  )(implicit ec: ExecutionContext): Future[Option[Persona]] = {
    repo.getOne(new PersonaId(str))
  }
}

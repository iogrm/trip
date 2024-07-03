package persona

import persona.model.{Persona, PersonaId}

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class PersonaService(repo: PersonaRepo) {

  def find(
      str: String
  )(implicit ec: ExecutionContext): Future[Option[Persona]] = {
    repo.getOne(new PersonaId(str))
  }

  def init()(implicit ec: ExecutionContext) = {
    val intj = new Persona(
      new PersonaId("intj"),
      "intj",
      "architects",
      "Architects are on a constant quest for knowledge - even holidays can't get in the way of learning.\nAs an Architect, you prefer to spend time planning your holidays rather than taking spontaneous trips. And true to your Analyst's roots - you enjoy ditching tourist traps for more thought-provoking activities. You'll take calming experiences over thrilling ones, but you're probably not too keen on resorts. "
    )

    val intp = new Persona(
      new PersonaId("intp"),
      "intp",
      "logicians",
      "Logicians are the living embodiment of the thinker statue. You lose yourself in thought, and you’re often seen as pensive and reserved. You love analyzing patterns in almost everything and thinking through abstract ideas.\nTravel-wise, we figure you enjoy melting into countries and cultures to get an idea of how other parts of the world function. You aren't keen on travel packages and need a push to try new things. But, like your Architect counterparts - you prefer calming trips that don't involve tourist traps."
    )

    val entj = new Persona(
      new PersonaId("entj"),
      "entj",
      "Commander",
      """It's no secret the commander loves a good challenge. "The less comfortable you are in your surroundings - the more you're forcing yourself to grow" if this quote strikes a chord, you're probably a Commander!

You don’t shy away from “tough sells”  when choosing destinations and will most likely convince others to come along."""
    )

    val entp = new Persona(
      new PersonaId("entp"),
      "entp",
      "Debater",
      """“You travel not just to explore the world, but to deepen your understanding of it and to consider what you might have to learn from other cultures." - unknown wise netizen. True to form, Debater's travel preferences are contrary to other analysts' roles. 

You seek out thrilling activities, love spontaneous travels, and you’ll go out of your way to find new experiences. But, you probably prefer to explore on your own and visit unpopular places, like a true Analyst."""
    )

    val infj = new Persona(
      new PersonaId("infj"),
      "infj",
      "Advocates ",
      """Advocates are known for being conscientious. You've got a deep desire to find your life’s purpose, which usually resolves around changing the world (or an aspect of it) for the better.

Advocates are a 10, but you tend to forgo self-care since you’re busy caring for everyone else. That's why the perfect vacation for you involves relaxation."""
    )

    val infp = new Persona(
      new PersonaId("infp"),
      "infp",
      "Mediators",
      """Similar to Advocates, Mediators are centered around helping others - you’re an idealist and probably the creative one in your friend group.

For vacations, you’re most likely okay with visiting the same place multiple times. However, while traveling in trains, for example, you prefer short, direct routes rather than scenic ones."""
    )

    val enfj = new Persona(
      new PersonaId("enfj"),
      "enfj",
      "Protagonist ",
      """You've probably noticed this pattern among Diplomats: altruistic, idealistic, and emphatic. The difference between the Protagonist vs. other Diplomats is your greatest strength - you’re naturally charismatic and have an impressive ability to lead. 

You’re prone to seeking out new thrilling activities, love making new friends when traveling, and you’re keen on traveling to exotic (less-visited) locations."""
    )

    val enfp = new Persona(
      new PersonaId("enfp"),
      "enfp",
      "Campaigners",
      """"Campaigners are free-spirited, joy-seekers who have no reason to make or follow travel plans." - probably a Campaigner.

You love spontaneous trips, trying new things, making new friends, and exploring destinations on your own."""
    )

    val esfp = new Persona(
      new PersonaId("esfp"),
      "esfp",
      "Entertainers",
      """Entertainers are outgoing, adventurous, and love to live life to the fullest. You’re probably the life of the party, with a good eye for aesthetics and luxury.

We see this trait show up in travel preferences as well. Entertainers are spontaneous, love visiting popular destinations and tourist attractions, and tend to make friends on trips.

"""
    )

    val estp = new Persona(
      new PersonaId("estp"),
      "estp",
      "Entrepreneurs",
      """Entertainers are high-energy, hands-on, and go-getters. You don't enjoy rigid plans or structure. Instead, you're okay with taking risks and figuring things out as they go, so no need for a super-detailed itinerary.

You’re likely to enjoy new and thrilling activities on vacations and skip out on package tours and all-inclusive resorts."""
    )

    val isfp = new Persona(
      new PersonaId("isfp"),
      "isfp",
      "Adventurers",
      """As the name implies, you love a good adventure. Like other Explorers, you prefer spontaneous trips to detailed travel plans. And since close connections are important to you, finding trips that involve loved ones will be right up your alley."""
    )

    val istp = new Persona(
      new PersonaId("istp"),
      "istp",
      "Virtuoso",
      """Virtuosos are big on spontaneous trips. You’re naturally curious and enjoy taking a hands-on mechanical approach to life.

You love exploring on your own and taking the more scenic route when on vacation."""
    )

    val esfj = new Persona(
      new PersonaId("esfj"),
      "esfj",
      "Consul",
      """The Consul's defining trait is service to others and close commitment to loved ones. Your love for planning and ensuring "everything is just right" often leads you to host parties and care for everyone else.

You enjoy organized tours, packaged holidays, tourist attractions, and resorts when traveling.

"""
    )

    val estj = new Persona(
      new PersonaId("estj"),
      "estj",
      "Executives",
      """ESTJs are big-time organizers. "You love to take on new projects and adventures, push people to their limits, and are very result-driven. When you make plans, you like to implement them immediately: just lounging around and "relaxing" is your visual representation of hell!"

You most likely enjoy visiting popular destinations and enjoy taking long, scenic routes when traveling."""
    )

    val isfj = new Persona(
      new PersonaId("isfj"),
      "isfj",
      "Defenders",
      """Defenders enjoy hard work and planning like their Sentinel peers. You may enjoy resorts, package tours, and tourist attractions but prefer less adrenaline-pumping activities - bungee jumping and skydiving are probably a no-no in your book."""
    )

    val istj = new Persona(
      new PersonaId("istj"),
      "istj",
      "Logistician",
      """Logisticians love detailed itineraries. Planning is your first priority when traveling. You organize your days to get to see and do everything on your list, and you’re happy to travel alone just so your plans aren’t disrupted."""
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

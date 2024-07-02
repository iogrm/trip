package db
import scala.concurrent.ExecutionContext.Implicits.global
import reactivemongo.api.AsyncDriver
import reactivemongo.api.bson.collection.BSONCollection
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import reactivemongo.api.DB
import reactivemongo.api.bson.BSONDocument

class Connector {

  private val db: DB = {
    println("Connecting")
    val driver = AsyncDriver()
    val connection = driver.connect("mongodb://mongo:27017")
    Await.result(connection.flatMap(_.database("trip")), 20.seconds)
  }

  val places = getCol("places")
  val mbtis = getCol("mbtis")

  def getCol(name: String): BSONCollection = {
    db.collection(name)
  }

}

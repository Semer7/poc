import java.util.UUID
import scala.util.Random

object ExampleObjectFactory {

  def spawn: ExampleDataObject = {
    val id = UUID.randomUUID()
    val string = Random.nextString(Random.nextInt(10))

    ExampleDataObject(id, string)
  }

}

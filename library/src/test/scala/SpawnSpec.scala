import org.scalatest.{FlatSpec, Matchers}

class SpawnSpec extends FlatSpec with Matchers{
  "Spawn object" should "create example object" in {
    val result = ExampleObjectFactory.spawn

    result shouldEqual result
  }
}

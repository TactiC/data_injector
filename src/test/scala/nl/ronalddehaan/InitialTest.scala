package nl.ronalddehaan

import com.sksamuel.elastic4s.embedded.LocalNode
import org.scalatest.FlatSpec
import com.sksamuel.elastic4s.http.ElasticDsl._

class InitialTest extends FlatSpec {


  "gdgf" should "fdsfd" in {
    // we must import the dsl
    val localNode = LocalNode("mycluster", "/tmp/datapath")

    // Next we create an index in advance ready to receive documents.
    // await is a helper method to make this operation synchronous instead of async
    // You would normally avoid doing this in a real program as it will block
    // the calling thread but is useful when testing
//    client.execute {
//      createIndex("artists").mappings(
//        mapping("modern").fields(
//          textField("name")
//        )
//      )
//    }.await
  }


}

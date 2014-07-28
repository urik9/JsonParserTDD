import java.io.{StringReader, BufferedReader, StreamTokenizer}

class streamer {
  val json: String = "{a:3}"



  def main (args: Array[String]) {
    val stDemo: StreamTokenizer = new StreamTokenizer(new BufferedReader(new StringReader(json)))
    while(stDemo.nextToken()!= StreamTokenizer.TT_EOF) {
      println(stDemo.nextToken())
    }
  }
}
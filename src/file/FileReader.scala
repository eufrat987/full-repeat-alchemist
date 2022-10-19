package file

import scala.io.Source
import scala.util.{Try, Using}

class FileReader(filename: String) {
  lazy val content = {
    var text = Option.empty[List[String]]
    Using(Source
      .fromFile(filename)) { s =>
      text = Some(s.getLines().toList)
    }
    text
  }
}

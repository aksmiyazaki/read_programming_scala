package chapter7

object BasicForComprehensions extends App {
  object BlankLiner {
    def apply(path: String, compressWhiteSpace: Boolean = false): Seq[String] = {
      for {
        line <- scala.io.Source.fromFile(path).getLines.toSeq
        if (!line.matches("""^\s*$"""))
          line2 = if (compressWhiteSpace) line replaceAll("\\s+", " ")
                  else line
      } yield line2
    }
  }

  val argues: Seq[String] = Seq("/Users/alexandre.miyazaki/Documents/general-notes/curls_marotos.md")
  for{
    fPath <- argues
    (compress, path) = {if (fPath.startsWith("-")) (true, fPath.substring(1)) else (false, fPath)}
    line <- BlankLiner(path, compress)
  } println(line)

}

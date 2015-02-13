package edu.cap10.demos

case class Config(argInt1 : Int = 1) {
  def parse(args:List[String]) : Option[Config] = args match {
    case Nil => Some(this)
    case "-n"::n::rest => this.copy(argInt1=n.toInt).parse(rest)
    case other => None
  }
}

object ScalaCLIDemo extends App {
  
  val usage = """
Usage: pub [-n int]
   -n: an integer
"""
  
  Config().parse(args.toList) match {
    case Some(config) => println(config)
    case None => println(usage)
  }
}
$copyright$

package $organization$.$name;format="lower,word"$

// Java

// Scala third-party
import com.monovore.decline._

// Scala first-party

object Options {
  val a = Opts.option[String](
    long = "az",
    short = "a",
    metavar = "str",
    help = "Just anything actually."
  ).validate("This string can't be empty.") { _ == "" }

  val b = Opts.option[Int](
    long = "buky",
    short = "b",
    metavar = "int",
    help = "Optional integer."
  ).orNone.validate("If set, must be a positive number.") { case Some(b) => b > 0 }
}

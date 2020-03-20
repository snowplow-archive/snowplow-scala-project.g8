$copyright$

package $organization$.$name;format="lower,word"$

// Java

// Scala third-party
import cats.implicits._
import com.monovore.decline._

// Scala first-party

object Main extends CommandApp(
    name = generated.ProjectSettings.name,
    header = generated.ProjectSettings.description,
    version = generated.ProjectSettings.version,
    main = {
      // This project
      import $organization$.$name;format="lower,word"$.Options._
      import $organization$.$name;format="lower,word"$.Run._

      (a, b).mapN { (a, b) =>
        run(a, b)
        println("SUCCESS!")
      }
    }
  )

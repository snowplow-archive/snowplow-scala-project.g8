/*
 * Copyright (c) $year$ Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

package $organization$.$name;format="lower,word"$

import cats.implicits._

import com.monovore.decline._

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {

  case class AppConf(name: String, age: Option[Int])

  val name = Opts.option[String]("name", short = "n", metavar = "str", help = "Just anything actually")
  val age = Opts.option[Int]("age", short = "i", metavar = "int", help = "Optional integer").orNone

  val appConf = (name, age).mapN(AppConf.apply)

  val command = Command("$name$", "Example Snowplow project")(appConf)

  def run(args: List[String]): IO[ExitCode] =
    command.parse(args) match {
      case Right(AppConf(name, age)) =>
        IO(println(s"Hello, \$name of age \$age.")).as(ExitCode.Success)
      case Left(error) =>
        IO(System.err.println(error)).as(ExitCode(2))
    }
}
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
import sbt._

object Dependencies {

  object V {
    val decline          = "1.0.0"
    val catsCore         = "2.0.0"
    val catsEffect       = "2.0.0"
    val circe            = "0.12.2"
    val fs2              = "2.0.1"
    val igluClient       = "0.6.0"
    val analyticsSdk     = "0.4.2"
    val scalaTracker     = "0.6.1"

    val specs2           = "4.7.0"
    val scalaCheck       = "1.14.1"
  }

  val decline          = "com.monovore"          %% "decline"                      % V.decline
  val catsCore         = "org.typelevel"         %% "cats-core"                    % V.catsCore
  val catsEffect       = "org.typelevel"         %% "cats-effect"                  % V.catsEffect
  val circeCore        = "io.circe"              %% "circe-core"                   % V.circe
  val circeGeneric     = "io.circe"              %% "circe-generic"                % V.circe
  val circeParser      = "io.circe"              %% "circe-parser"                 % V.circe
  val circeOptics      = "io.circe"              %% "circe-optics"                 % V.circe
  val circeLiteral     = "io.circe"              %% "circe-literal"                % V.circe
  val fs2              = "co.fs2"                %% "fs2-core"                     % V.fs2
  val igluClient       = "com.snowplowanalytics" %% "iglu-scala-client"            % V.igluClient
  val analyticsSdk     = "com.snowplowanalytics" %% "snowplow-scala-analytics-sdk" % V.analyticsSdk
  val scalaTracker     = "com.snowplowanalytics" %% "snowplow-scala-tracker" 	     % V.scalaTracker

  val specs2           = "org.specs2"            %% "specs2-core"                  % V.specs2        % Test
  val scalaCheck       = "org.scalacheck"        %% "scalacheck"                   % V.scalaCheck    % Test

}
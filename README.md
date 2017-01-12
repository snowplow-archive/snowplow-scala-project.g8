# snowplow-scala-app.g8

snowplow-scala-app.g8 is [SBT template][sbt-template] used by [Snowplow][snowplow] Engineering Team as basis for modern open-source Scala projects.

This is a template intended for executable applications, that will be published on Bintray or Amazon S3.
For libraries supposed to be published on Maven use [snowplow-scala-lib.g8][snowplow-scala-lib].

## Quickstart

Assuming SBT and git are installed.

Basic application template:

```bash
host$ sbt new snowplow/snowplow-scala-app.g8
```

Application on top of Cats Effect:

```bash
host$ sbt new snowplow/snowplow-scala-app.g8 --branch app
```


Add AWS credentials to `.travis.yml` to publish application on AWS S3:

* `AWS_ACCESS_KEY`
* `AWS_SECRET_KEY`

## Assumptions

* Scala Application uses `rc` pre-releases
* Scala Application uses generic tool [release-manager][release-manager] to publish itself via Travis CI
* Scala Application doesn't need multiple Scala versions, therefore uses most popular - 2.11

## Copyright and License

Snowplow Scala Skeleton is copyright $year$ Snowplow Analytics Ltd.

Licensed under the **[Apache License, Version 2.0][license]** (the "License");
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[release-manager]: https://github.com/snowplow/release-manager

[talk-to-us]: https://github.com/snowplow/snowplow/wiki/Talk-to-us

[snowplow]: http://snowplowanalytics.com/
[sbt-template]: https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html

[snowplow-scala-lib]: https://github.com/snowplow/snowplow-scala-lib.g8

[license]: http://www.apache.org/licenses/LICENSE-2.0
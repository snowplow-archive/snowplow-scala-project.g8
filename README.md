# snowplow-scala-project.g8

snowplow-scala-project.g8 is an [SBT template][sbt-template] used by the [Snowplow Analytics][snowplow] Engineering Team as the basis for open-source Scala projects.

This is version 0.1.0.

## Overview

This project can be seen on several different levels. From most general to most granular, they are:

1. A repo level, where we're interested in questions about the repository's design and organisation. On this level we ask questions such as:
- *What branches are there and what are the differences between them?*
- *How are issues organised?*
- *What does a release of the project look like?*

2. A project level, where we're interested in questions about the [Giter8][giter8] code itself. On this level we ask questions such as:
- *What version of Giter8 are we using?*
- *What Giter8 features are we using?*
- *How can we improve the templates by making better use of Giter8?*

3. A structure level, where we're interested how an individual template is organised. On this level we ask questions such as:
- *What files are there in the template?*
- *What are the files in the template named?*
- *How are the files of the template organised?*

4. A content level, where we're interested in the contents of individual files in the template. On this level we ask questions such as:
- *What does each file contain?*
- *How are the contents of a file organised?*

Let's look at each of these in turn.

### Repository design and organisation

#### Branches

This repo has three main branches:
- a `master` branch,
- an `app` branch,
- a `lib` branch.

The `app` branch is home to our application template. The `lib` branch is home to our library template. And the `master` branch has code that is shared by both the application and library templates.

If we want to make a change that only affects the application template or the library template, we introduce that change in the respective branch. If we want to make a change that affects both templates, we introduce that change in the `master` branch and rebase the other branches on top of it.

The `master` branch is the default branch for the repo but in practice we wouldn't launch a template from it, as it is too general. Instead, templates are launched from either the `app` or `lib` branches.

#### Issues

The issue tracker is used to track issues on any level.

Each issue should be labeled appropriately, to show on which level it belongs.

Issues that only affect one of the specialised branches should be prefixed with `App` or `Lib`, issues that affect `master` should be prefixed with `Master`. After the prefix, the title of the issue is not capitalised.

Examples:

```
App: add sbt-site plugin
Lib: finalise list of default plugins
Master: update copyright
```

#### Releases

A release could be introducing changes to any of the templates across `Master`, `App` and `Lib`, or to the Giter8 code itself (ie, the project level).

A release is any grouping of solved issues after which the version of the Giter8 project is incremented. Each version should be tagged and the release notes for the tag should document changes grouping them by template or level. Changes should also be reflected in the `CHANGELOG` of the Giter8 project.

At present, we do not build and deploy the Giter8 project as a fatjar.

##### Versioning

We use [Semantic Versioning][semver].

### Giter8

We're currently on version `0.11.0`.

### Structure of templates

All templates share the following structure:

```
.
+-- _.travis
|   +-- checkTag.sh
|   +-- deploy.sh
+-- _project
|   +-- build.properties
|   +-- BuildSettings
|   +-- Dependencies
|   +-- plugins.sbt
+-- _src
|   +-- _main
|   |   +-- ...
|   +-- _test
|   |   +-- ...
+-- .gitignore
+-- .scalafmt.conf
+-- .travis.yml
+-- build.sbt
+-- CHANGELOG
+-- default.properties
+-- LICENSE
+-- README.md
```

The only difference in structure between application and library templates is that the former have stubs for a `Main` class and tests for it.

### Contents of template files

Some files' contents will differ between templates, but most files should be identical.

## How to use

To start a new application project:

```bash
$ sbt new snowplow/snowplow-scala-project.g8 --branch app
```

To start a new library project:

```bash
$ sbt new snowplow/snowplow-scala-project.g8 --branch lib
```

You will be asked to provide a value for each parameter. Pressing `Enter` will accept the default value shown in square brackets.

```bash
$ name [new-project]:
```

For a full list of parameters used in these templates, refer to the `default.properties` file in the `src/main/g8` directory of the project.

The commands above with create a new directory in your current working directory named `new-project`. All the template's files will be created inside this new directory.

## More resources

Find more about Snowplow's engineering-related practices, conventions and resources in the [dedicated repo][eng-resources].

## Copyright and license

snowplow-scala-project.g8 is copyright 2020-2020 Snowplow Analytics Ltd.

Licensed under the **[Apache License, Version 2.0][license]** (the "License");
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[sbt-template]: https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html
[snowplow]: http://snowplowanalytics.com/
[giter8]: http://www.foundweekends.org/giter8/
[semver]: https://semver.org/
[eng-resources]: https://github.com/snowplow-incubator/engineering-resources

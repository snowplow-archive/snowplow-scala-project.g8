#!/bin/bash

set -e

tag_version=\$1

mkdir ~/.bintray/
FILE=\$HOME/.bintray/.credentials
cat <<EOF >\$FILE
realm = Bintray API Realm
host = api.bintray.com
user = \$BINTRAY_SNOWPLOW_MAVEN_USER
password = \$BINTRAY_SNOWPLOW_MAVEN_API_KEY
EOF

cd \$TRAVIS_BUILD_DIR
pwd

sbt +publish
sbt +bintraySyncMavenCentral

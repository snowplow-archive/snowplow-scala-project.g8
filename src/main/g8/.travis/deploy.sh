#!/bin/bash

tag=\$1
project=$name;format="lowercase,snake"$

slashed="\$project/"
slashed_len=\${#slashed}

cicd=\${tag:0:\${slashed_len}}
release=\${tag:\${slashed_len}}

if [ "\${cicd}" == "\${slashed}" ]; then
    if [ "\${release}" == "" ]; then
        echo "Warning! No release specified! Ignoring."
        exit 2
    fi
else
    echo "This can't be deployed - there's no \$slashed tag! (is the travis condition set?)"
    exit 1
fi
 
cd \$TRAVIS_BUILD_DIR

export TRAVIS_BUILD_RELEASE_TAG=\${release}
release-manager --config ./.travis/release_event_manifest_populator.yml --check-version --make-artifact --upload-artifact

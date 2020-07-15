#!/bin/bash

TARGET_DIR=../java

# If trias-xsd dir does not exist yet, extract the package...
if [[ ! -d trias-xsd ]]; then
    unzip trias-xsd-v1.2 -d trias-xsd
fi

# Switch to directory and make
cd trias-xsd

# Remove previous output dir if existing...
if [[ -d "$TARGET_DIR" ]]; then
    rm -r "$TARGET_DIR"
fi

# ...and regenerate new one
mkdir "$TARGET_DIR"

# Overwrite bindings file with current one
cp ../bindings.xml ./bindings.xml

# Compile classes
xjc -d "$TARGET_DIR" -npa -extension -classpath ../../src/main/java/ -b bindings.xml Trias.xsd

# Remove local copy of bindings.xml to avoid confusion with original file.
rm bindings.xml

# Run post processing...
../post-process.sh $TARGET_DIR




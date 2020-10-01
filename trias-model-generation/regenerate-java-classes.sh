#!/bin/bash

TARGET_DIR=../java

if [[ -z "$1" ]]; then
  JDK8="/usr/lib/jvm/java-1.8.0-openjdk-amd64"
else
  JDK8="$1"
fi

if [[ ! -d "$JDK8" ]]; then
    echo "Unable to locate JDK 1.8 (looking at $JDK8). The xjc command must be run with this version to ensure correct results. Please install this JDK version on you system and/or specify he location of it as first argument to this script."
    exit 1
fi

XJC="$JDK8/bin/xjc"
echo "Using $XJC for class generation."

# If trias-xsd dir does not exist yet, extract the package...
if [[ ! -d trias-xsd ]]; then
    echo "Unzipping trias schema files..."
    unzip trias-xsd-v1.2 -d trias-xsd
fi

echo "Preparing java code generation..."

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

echo "Generating classes..."
# Compile classes
"$XJC" -d "$TARGET_DIR" -npa -extension -b bindings.xml Trias.xsd > /dev/null

# Remove local copy of bindings.xml to avoid confusion with original file.
rm bindings.xml

echo "Starting post processing script..."
# Run post processing...
../post-process.sh $TARGET_DIR




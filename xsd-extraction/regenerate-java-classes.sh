#!/bin/bash

target_dir=../generated

# If trias-xsd dir does not exist yet, extract the package...
if [[ ! -d trias-xsd ]]; then
    unzip trias-xsd-v1.2 -d trias-xsd
fi

# Switch to directory and make
cd trias-xsd

# Remove previous output dir if existing...
if [[ -d "$target_dir" ]]; then
    rm -r "$target_dir"
fi

# ...and regenerate new one
mkdir "$target_dir"

# Overwrite bindings file with current one
cp ../bindings.xml ./bindings.xml

# Compile classes
xjc -d "$target_dir" -npa -b bindings.xml Trias.xsd

# Remove local copy of bindings.xml to avoid confusion with original file.
rm bindings.xml


echo "Post-processing files..."

# call post-processing script for each file once.
find "$target_dir" -name "*.java" -exec $(pwd)/../post-process.sh {} \;

#!/bin/bash

if [[ -d ./java ]]; then
    rm -r ../src/main/java/eu
    rm -r ../src/main/java/uk
    rm -r ../src/main/java/de/vdv

    mv ./java/eu ../src/main/java/
    mv ./java/uk ../src/main/java/
    mv ./java/de/vdv ../src/main/java/de/

    rm -r ./java
else
    echo "Folder java does not exists. Aborting..."
fi

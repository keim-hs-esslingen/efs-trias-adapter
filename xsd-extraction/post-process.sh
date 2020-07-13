#!/bin/bash

# Check if sponge is installed.
if [[ -z $(which sponge) ]]; then
    echo "\"sponge\" is not installed. Please install sponge from moreutils."
    exit 0;
fi

TARGET_DIR=$1

if [[ -z $TARGET_DIR ]]; then
    echo "Target dir is not specified."
    exit 0;
fi
 
# Get directory where this script resides.
SDIR="$(dirname "$(readlink -f "$0")")"


processFile(){
    srcfile=$1
    licensefile=$SDIR/licenseheader.txt

    # Get the current year
    YEAR=$(date +%Y)

    # The following command does the following things:
    # 1. Output licenseheader.txt once for each file and append the actual file afterwards
    # 2. Replace first occurence of "yyyy" with the current year.
    # 3. Remove the generation timestamp created by the xjc command.
    # 4. Overwrite the source code file with the new content.

    cat "$licensefile" "$srcfile" | sed -e "0,/yyyy/ {s/yyyy/$YEAR/}" -e '\_// Generated on: [0-9\.]* at [0-9:]* .*$_ d' | sponge "$srcfile"
}


echo "Post-processing files..."

# call post-processing script for each file once.
find "$TARGET_DIR" -name '*.java' -print0 | 
    while IFS= read -r -d '' line; do 
        processFile "$line"
    done

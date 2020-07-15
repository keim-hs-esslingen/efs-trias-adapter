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

# call general processFile function for each file once.
find "$TARGET_DIR" -name '*.java' -print0 | 
    while IFS= read -r -d '' line; do 
        processFile "$line"
    done

# Color setup.
RED=`tput setaf 1`
GREEN=`tput setaf 2`
YELLOW=`tput setaf 3`
BLUE=`tput setaf 4`
PURPLE=`tput setaf 5`
LOGCOLOR=$YELLOW
NONE=`tput sgr0` # No Color

log() {
    printf "$1\n"
}

# Make replacements in specified files

replace(){
    log "[ ${YELLOW}Replacing${NONE} ]: \"$RED$2$NONE\" with \"$GREEN$3$NONE\" in file $PURPLE$1$NONE"
    sed -i -e "s/$2/$3/g" $1
}

VDV="$TARGET_DIR/de/vdv/trias"
PACKAGE="de.hsesslingen.keim.efs.trias.supertypes"
implements="implements $PACKAGE."

replace "$VDV/LegAlightStructure.java" "class LegAlightStructure" "class LegAlightStructure $implements ILegEnd"
replace "$VDV/LegBoardStructure.java" "class LegBoardStructure" "class LegBoardStructure $implements ILegEnd"

# Implementing interface ICoordinates on GeoPositionStructure. (Adding interface and methods)
replace "$VDV/GeoPositionStructure.java" "class GeoPositionStructure" "class GeoPositionStructure implements de.hsesslingen.keim.efs.mobility.ICoordinates"
replace "$VDV/GeoPositionStructure.java" "^}$" "\t@Override\n\tpublic Double getLat() {\n\t\treturn latitude;\n\t}\n\n\t@Override\n\tpublic Double getLon() {\n\t\treturn longitude;\n\t}\n}"


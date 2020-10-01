#!/bin/bash

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

# Check if sponge is installed.
if [[ -z $(which sponge) ]]; then
    log "[$RED Error $NONE]: \"sponge\" is not installed. Please install sponge from moreutils."
    exit 0;
fi

TARGET_DIR=$1

if [[ -z $TARGET_DIR ]]; then
    echo "[$RED Error $NONE]: Target dir is not specified. Pass it as the first arg to post-process.sh"
    exit 0;
fi


# Get directory where this script resides.
SDIR="$(dirname "$(readlink -f "$0")")"

CLASSPAT="[a-zA-Z_0-9\.]+" # Classname Pattern
SUFFIXPAT="Structure" # Suffix Pattern To Remove
EOLPAT="([ {]*)\\\$?"

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

    sed -i -E -e "s/import ($CLASSPAT)$SUFFIXPAT/import \1/" \
        -e "s/public class ($CLASSPAT)$SUFFIXPAT$EOLPAT/public class \1\2/" \
        -e "s/public abstract class ($CLASSPAT)$SUFFIXPAT$EOLPAT/public abstract class \1\2/" \
        -e "s/public interface ($CLASSPAT)$SUFFIXPAT$EOLPAT/public interface \1\2/" \
        -e "s/ extends ($CLASSPAT)$SUFFIXPAT$EOLPAT/ extends \1\2/" \
        -e "s/ implements ($CLASSPAT)$SUFFIXPAT$EOLPAT/ implements \1\2/" \
        -e "s/([ \(<])($CLASSPAT)$SUFFIXPAT([ \(\)>\.])/\1\2\3/g" \
        "$srcfile"

    if [[ "$srcfile" =~ "$SUFFIXPAT.java" ]]; then
        local NEWNAME=$(echo "$srcfile" | sed -e "s/$SUFFIXPAT\.java/.java/")
        # log "[$YELLOW Renaming $NONE]: $RED$(basename $srcfile)$NONE to $GREEN$(basename $NEWNAME)$NONE"
        mv "$srcfile" "$NEWNAME"
    fi
}


log "[$GREEN General $NONE]: Adding licenseheaders and removing generation timestamps..."

# Call general processFile function for each file once.
find "$TARGET_DIR" -name '*.java' -print0 | 
    while IFS= read -r -d '' line; do 
        processFile "$line"
    done

# Make replacements in various files
replace(){
    log "[$YELLOW Replacing $NONE]: \"$RED$2$NONE\" with \"$GREEN$3$NONE\" in file $PURPLE$1$NONE"
    sed -i -e "s/$2/$3/g" $1
}

# Some reusable variables for convenience:
VDV="$TARGET_DIR/de/vdv/trias"
SIRI="$TARGET_DIR/uk/org/siri/siri"
PACKAGE="de.hsesslingen.keim.efs.adapter.trias.supertypes"
implements="implements $PACKAGE."

replace "$VDV/LegAlight.java" "class LegAlight" "class LegAlight $implements ILegEnd"
replace "$VDV/LegBoard.java" "class LegBoard" "class LegBoard $implements ILegEnd"

# Implementing interface ICoordinates on GeoPosition. (Adding interface and methods)
replace "$VDV/GeoPosition.java" "class GeoPosition" "class GeoPosition implements de.hsesslingen.keim.efs.middleware.model.ICoordinates"
replace "$VDV/GeoPosition.java" "^}$" "\t@Override\n\tpublic Double getLat() {\n\t\treturn latitude;\n\t}\n\n\t@Override\n\tpublic Double getLon() {\n\t\treturn longitude;\n\t}\n}"

# Fixing some errors due to refactoring in processFile function
replace "$SIRI/AffectsScope.java" "extends AffectedNetwork" "extends uk.org.siri.siri.AffectedNetwork"
replace "$SIRI/PtSituationElement.java" "extends Image" "extends uk.org.siri.siri.Image"
replace "$SIRI/VehicleActivity.java" "extends MonitoredVehicleJourney" "extends uk.org.siri.siri.MonitoredVehicleJourney"


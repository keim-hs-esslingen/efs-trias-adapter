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

IDENTIFIER="[a-zA-Z0-9_]+"
CLASSPAT="[a-zA-Z_0-9\.]+" # Classname Pattern
EOLPAT="([ {]*)\\\$?"

# PERL-SCRIPTS:
# This script adds Lomboks @ToString annotation imports.
IMPORT_TOSTRING="s/package ([^;]+);(\s+)/package \1;\2import lombok.ToString;\n/"
# This script annotates classes with Lomboks @ToString annotation.
ANNOTATE_TOSTRING="s/(\s+)public class /\1\@ToString\npublic class /"


processFile(){
    SRCFILE=$1
    LICENSEFILE=$SDIR/licenseheader.txt

    # Get the current year
    YEAR=$(date +%Y)

    # The following command does the following things:
    # 1. Output licenseheader.txt once for each file and append the actual file afterwards
    # 2. Replace first occurence of "yyyy" with the current year.
    # 3. Remove the generation timestamp created by the xjc command.
    # 4. Overwrite the source code file with the new content.

    cat "$LICENSEFILE" "$SRCFILE" | sed -e "0,/yyyy/ {s/yyyy/$YEAR/}" -e '\_// Generated on: [0-9\.]* at [0-9:]* .*$_ d' | sponge "$SRCFILE"

    local CLASSNAME=$(echo $(basename "$SRCFILE") | sed -E -e "s/(Structure)?.java//")

    sed -i -E -e "s/import ($CLASSPAT)Structure/import \1/" \
        -e "s/public class ($CLASSPAT)Structure$EOLPAT/public class \1\2/" \
        -e "s/public abstract class ($CLASSPAT)Structure$EOLPAT/public abstract class \1\2/" \
        -e "s/public interface ($CLASSPAT)Structure$EOLPAT/public interface \1\2/" \
        -e "s/ extends ($CLASSPAT)Structure$EOLPAT/ extends \1\2/" \
        -e "s/ implements ($CLASSPAT)Structure$EOLPAT/ implements \1\2/" \
        -e "s/([ \(<])($CLASSPAT)Structure([ \(\)>\.])/\1\2\3/g" \
        "$SRCFILE"

    # PERL-SCRIPTS:
    # This script converts classical setter methods to chainable ones...
    local CHAINABLE_SETTERS="s/    public void set($IDENTIFIER)\(($IDENTIFIER) value\) \{\n([^=]+)= value\;\n    \}/    public $CLASSNAME set\1(\2 value) {\n\3= value\;\n        return this\;\n    }/g"

    perl -0777 -pi -e "$CHAINABLE_SETTERS;$IMPORT_TOSTRING;$ANNOTATE_TOSTRING" "$SRCFILE"
}

renameFile(){
    SRCFILE=$1

    if [[ "$SRCFILE" =~ "Structure.java" ]]; then
        local NEWNAME=$(echo "$SRCFILE" | sed -e "s/Structure\.java/.java/")
        log "[$YELLOW Renaming $NONE]: $RED$(basename $SRCFILE)$NONE to $GREEN$(basename $NEWNAME)$NONE"
        mv "$SRCFILE" "$NEWNAME"
    fi
}

log "[$GREEN General $NONE]: Processing transformations for each Java file..."

# Call general processFile function for each file once.
find "$TARGET_DIR" -name '*.java' -print0 | 
    while IFS= read -r -d '' LINE; do 
        processFile "$LINE"
    done

log "[$GREEN General $NONE]: Renaming files with refactored class names..."

# Rename all refactored files
find "$TARGET_DIR" -name '*.java' -print0 | 
    while IFS= read -r -d '' LINE; do 
        renameFile "$LINE"
    done

# Make replacements in various files
replace(){
    log "[$YELLOW Replacing $NONE]: \"$RED$2$NONE\" with \"$GREEN$3$NONE\" in file $PURPLE$1$NONE"
    sed -i -e "s/$2/$3/g" $1
}


log "[$GREEN General $NONE]: Doing some final replacements..."

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


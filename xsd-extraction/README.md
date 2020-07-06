
# How to generate Java classes from this XML Schema

### 1. Download the XML-Schema

You get it here: https://www.vdv.de/ip-kom-oev.aspx

### 2. Generate classes

You can either use the regenerate-java-classes.sh script with...

```bash
./regenerate-java-classes.sh
```

or do it manually as follows:

#### 2.1 Extract trias-xsd-v1.2.zip to folder trias-xsd 

```bash
unzip trias-xsd-v1.2 -d trias-xsd
```

#### 2.2 Go to there and create output folder.

This is where the java classes will be put into.

```bash
cd trias-xsd
mkdir generated
```

#### 2.3 Copy bindings.xml to newly created folder

```bash
cp ../bindings.xml ./bindings.xml
```

#### 2.4 Generate Java classes using xjc command.

```bash
xjc -d generated -npa -b bindings.xml Trias.xsd
```

The -npa flag is needed for JAXB unmarshallers to correctly deserialize XML.
The bindings.xml file contains one class customization for the code generation to work.

To avoid confusion with the original bindings file, remove the copied one after generation:

```bash
rm bindings.xml
```

#### 2.5 Remove generation timestamps

The generated classes contain a timestamp of their creation which makes them appear as modified files to git.
Remove them with the following command:

```bash
find ./generated -name "*.java" -exec sed -i -e '/\/\/ Generated on: [0-9\.]* at [0-9:]* .*$/d' {} \;
```

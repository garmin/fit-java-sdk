# Garmin - FIT Java SDK

## FIT SDK Documentation
The FIT SDK documentation is available at [https://developer.garmin.com/fit](https://developer.garmin.com/fit).
## FIT SDK Developer Forum
Share your knowledge, ask questions, and get the latest FIT SDK news in the [FIT SDK Developer Forum](https://forums.garmin.com/developer/).

## FIT Java SDK Requirements
The FIT Java SDK requires the [Oracle Java Runtime Environment 8](https://www.java.com/en/download/) version 1.8.0 or higher, or equivalent in order to run the SDK tools.

In order to build or develop with the FIT Java SDK, the [Oracle Java SE 8 JDK](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) higher, or equivalent is required.

## Install
The FIT Java SDK is published to [Maven Central Repository](https://central.sonatype.com/artifact/com.garmin/fit) and can be added to a project as a dependency.
```xml
<dependency>
    <groupId>com.garmin</groupId>
    <artifactId>fit</artifactId>
    <version>[21.176.0,)</version>
</dependency>
```

## Building Java Tools
The FIT Java SDK pom.xml file provides multiple profiles for building tools locally, such as the [FIT CSV Tool](https://developer.garmin.com/fit/fitcsvtool/).

In order to build the FIT Java SDK or its tools locally, [Apache Maven](https://maven.apache.org/what-is-maven.html) must be installed.

From the java directory, or if using custom directory names the directory containing the pom.xml file, execute the following command(s) to build the FIT Java SDK and the FIT CSV Tool. Use the -P option to only build the packages that are required.

```sh
$ mvn package -Pfitsdk            # Build the FIT Java SDK
$ mvn package -Pfitcsvtool        # Build the FIT CSV Tool
$ mvn package -Pfitsdk,fitcsvtool # Build both the SDK and FIT CSV Tool
```


## FIT SDK Cookbook
The [FIT SDK Cookbook](https://developer.garmin.com/fit/cookbook/) contains examples of using the FIT SDK to solve real-world problems. There are recipes for encoding and decoding Activity, Workout, and Course files; and recipes that provide tips for working with the FIT SDK.

### Decoding an Activity File
The FIT Java SDK contains example code for decoding FIT Activity files. See the [Decoding FIT Activity Files](https://developer.garmin.com/fit/cookbook/decoding-activity-files/) recipe for details on decoding FIT Activity files.

### Encoding an Activity File
The FIT Java SDK contains example code for encoding FIT Activity files. See the [Encoding FIT Activity Files](https://developer.garmin.com/fit/cookbook/encoding-activity-files/) recipe for details on encoding FIT Activity files.

### Encoding a Course File
The FIT Java SDK contains example code for encoding FIT Course files. See the [Encoding FIT Course Files](https://developer.garmin.com/fit/cookbook/encoding-course-files/) recipe for details on encoding FIT Course files.

### Encoding a Workout File
The FIT Java SDK contains example code for encoding FIT Workout files. See the [Encoding FIT Workout Files](https://developer.garmin.com/fit/cookbook/encoding-workout-files/) recipe for details on encoding FIT Workout files.

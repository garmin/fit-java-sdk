# Garmin - FIT Java SDK

## FIT SDK Documentation
The FIT SDK documentation is available at [https://developer.garmin.com/fit](https://developer.garmin.com/fit).
## FIT SDK Developer Forum
Share your knowledge, ask questions, and get the latest FIT SDK news in the [FIT SDK Developer Forum](https://forums.garmin.com/developer/).

## Install
The latest version of the SDK can be installed from [Maven Central Repository](https://central.sonatype.com/artifact/com.garmin/fit/21.120.0)
```xml
<dependency>
    <groupId>com.garmin</groupId>
    <artifactId>fit</artifactId>
    <version>[21.120.0,)</version>
</dependency>
```

## FIT SDK Cookbook
The [FIT SDK Cookbook](https://developer.garmin.com/fit/cookbook/) contains examples of using the FIT SDK to solve real-world problems. There are recipes for encoding and decoding Activity, Workout, and Course files; and recipes that provide tips for working with the FIT SDK.

### Decoding an Activity File
The FIT C# SDK contains example code for decoding FIT Activity files. See the [Decoding FIT Activity Files](https://developer.garmin.com/fit/cookbook/decoding-activity-files/) recipe for details on decoding FIT Activity files.
<details>
    <summary>Click to view code snippet</summary>
    https://github.com/garmin/fit-java-sdk/blob/aa47e36cb94f1282347e7482d66e2559e0b31127/com/garmin/fit/examples/DecodeExample.java#L1-L293
</details>

### Encoding an Activity File
The FIT C# SDK contains example code for encoding FIT Activity files. See the [Encoding FIT Activity Files](https://developer.garmin.com/fit/cookbook/encoding-activity-files/) recipe for details on encoding FIT Activity files.
<details>
    <summary>Click to view code snippet</summary>
    https://github.com/garmin/fit-java-sdk/blob/aa47e36cb94f1282347e7482d66e2559e0b31127/com/garmin/fit/examples/EncodeActivity.java#L1-L700
</details>

### Encoding a Course File
The FIT C# SDK contains example code for encoding FIT Course files. See the [Encoding FIT Course Files](https://developer.garmin.com/fit/cookbook/encoding-course-files/) recipe for details on encoding FIT Course files.
<details>
    <summary>Click to view code snippet</summary>
    https://github.com/garmin/fit-java-sdk/blob/aa47e36cb94f1282347e7482d66e2559e0b31127/com/garmin/fit/examples/EncodeCourse.java#L1-L297
</details>

### Encoding a Workout File
The FIT C# SDK contains example code for encoding FIT Workout files. See the [Encoding FIT Workout Files](https://developer.garmin.com/fit/cookbook/encoding-workout-files/) recipe for details on encoding FIT Workout files.
<details>
    <summary>Click to view code snippet</summary>
    https://github.com/garmin/fit-java-sdk/blob/aa47e36cb94f1282347e7482d66e2559e0b31127/com/garmin/fit/examples/EncodeWorkout.java#L1-L469
</details>

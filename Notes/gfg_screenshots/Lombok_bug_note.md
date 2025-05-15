## Bug was
- even after adding dependencies for lombok and adding annotations for @Getter and @Setter and many more still I was getting error when calling getter setters and builder
- how I resolved : manually download lombok.jar and run java -jar command
- it will detect IDE (STS here) and add the plugin to it
- after that open project with lombok and update project
- here if jdk path showing 1.5 version post lombok addition ,replace library in build path to java 17 or higher versions jre and also change java facets :(google it how to change java version)
- update project ,refresh and run --- this worked for
- [Lombok plugin download and install tutorial](https://www.youtube.com/watch?v=Yr8v56gaSb0)


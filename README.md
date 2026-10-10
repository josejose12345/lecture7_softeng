Esta es la salida en temrinal de los unit tests
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< org.example:library >-------------------------
[INFO] Building library 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ library ---
[INFO] skip non existing resourceDirectory /home/jose/syseng/library/lecture7/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ library ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ library ---
[INFO] skip non existing resourceDirectory /home/jose/syseng/library/lecture7/src/test/resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ library ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ library ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.BookTest
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.079 s -- in org.example.BookTest
[INFO] Running org.example.LibraryTest
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.044 s -- in org.example.LibraryTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 18, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.548 s
[INFO] Finished at: 2026-10-10T13:38:21+02:00
[INFO] ------------------------------------------------------------------------
```

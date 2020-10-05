echo off
set path=C:\Program Files\Java\jdk-12.0.1\bin
set include=C:\Program Files\Java\jdk-12.0.1\include
set lib=C:\Program Files\Java\jdk-12.0.1\lib
set link=C:\Program Files\Java\jdk-12.0.1\bin
javac -version lab_1.java
java lab_1
javap -c lab_1 >1.txt
javadoc lab_1.java -d 1
pause
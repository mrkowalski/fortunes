# fortunes
Java 8 implementation of classic Unix fortunes

# Why?

I wrote it, because I needed someting that required at least JDK8 in order to force migration of some corporate code to the latest JDK.
Parsing fortune files does not require any JDK 8 fortunes, but as soon as it is added to the project, the project won't work with JDK<8 and this is the whole point.

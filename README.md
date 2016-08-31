# Fortunes
Java 8 implementation of classic Unix fortunes

# Why?

I wrote it, because I needed something that required at least JDK8 in order to force migration of some corporate code to the latest JDK.
Parsing fortune files does not require any JDK 8 features, but as soon as it is added to the codebase, no earlier version of Java can be used to compile it, and that's the whole point. No one will be able to roll your JDK version back.

# Sleep safe and sound

The implementation is quite defensive and in case anything goes wrong, the default fortune is going to be generated. No worries, no exceptions. Also, you do not have to change any significant parts of your corporate app to enforce JDK8, so the risk is really negligible.
 
 # How to use it in your project?
 
Just copy-paste the only implementation file to your codebase, changing the package on your way. Main method can obviously be deleted, if not needed. Any fortunes file can be used. The one included in this project under ./data is the exact copy of https://github.com/bmc/fortunes/blob/master/fortunes
 

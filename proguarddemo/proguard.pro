-libraryjars <java.home>/lib/rt.jar

# Write out an obfuscation mapping file, for de-obfuscating any stack traces
# later on, or for incremental obfuscation of extensions.

-printmapping proguard.map

# Allow methods with the same signature, except for the return type,
# to get the same obfuscation name.

-overloadaggressively

# Put all obfuscated classes into the nameless root package.

-repackageclasses ''

# Allow classes and class members to be made public.

-allowaccessmodification

# The entry point: ProGuard and its main method.

# -keepclasseswithmembers  public class com.hawkeye.channel.HawkeyeChannel
-dontshrink
-dontskipnonpubliclibraryclasses

-keep public class com.ggd543.proguard.ExceptionClass{
     public String doSomething();
}


-keepattributes *Annotation*
-keepattributes Exceptions



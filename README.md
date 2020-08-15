**CO2EmissionCalculator**
A utility to calculate the amount of CO2 equivalent that will be caused when travelling between 2 cities using a given transportation mode.


How to build and run

To build

**./gradlew clean build**

Run the tests

**./gradlew clean test**

Run the application

**./gradlew co2Calculator  -Pend="end city" -Pstart="start city" -PtransportationMethod="mode of transportation"**

Sample run 

**./gradlew co2Calculator  -Pend="Berlin" -Pstart="Hamburg" -PtransportationMethod="medium-diesel-car"**

> Task :co2Calculator
Your trip caused 49.2kg of CO2-equivalent.








To resolve javax.net.ssl.SSLHandshakeException :

In case of the below exception 
javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target

Please make sure to import valid root certificate to java cacert

**CO2EmissionCalculator**
A utility to calculate the amount of CO2 equivalent that will be caused when travelling between 2 cities using a given transportation mode.


How to build and run

To build

**./gradlew clean build**

Run the tests

**./gradlew test**

Run the application

**./gradlew co2Calculator  -Pend="end city" -Pstart="start city" -PtransportationMethod="mode of transportation"**

**Sample run :**
./gradlew co2Calculator  -Pend="Berlin" -Pstart="Hamburg" -PtransportationMethod="medium-diesel-car"

> Task :co2Calculator
Your trip caused 49.2kg of CO2-equivalent.


# ReadMe

## Doggos-4-U

The Dog API is a service that sends information and images related to various dog breeds.
https://www.thedogapi.com/ 

(You will need to sign up for an API key, but currently the api allows arbitary keys such as : "ss" or even an empty header value in the GET call)

Objective was to create a list/detail Android application that accesses this API using clean and contemporary techniques.

### Current behaviour of the app:

- Open on a list of all the breeds with name and image
- Clicking an item in the list will display further details of the breed

### About the tech stack

-Android<br>
&nbsp; &nbsp;--Kotlin -- Gradle -- Kotlin DSL<br>
&nbsp; &nbsp; &nbsp; &nbsp; --Dagger --Retrofit --Coroutines & Flows<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -- Jetpack Compose<br>
&nbsp; &nbsp; &nbsp; -- Junit -- Mockk lib - Espresso

### Notable features

- MVVM architecture
- Multi module code base with single Activity
- Dagger Android
- Staggered Grid on Home screen ( responsive to both Portrait and Landscape )
- Experimented on Container transformation using jetpack compose ( Go to : https://github.com/MDeMel-Dev/Doggos-4-u/tree/Container-Transition-Compose )

## Apks

- https://github.com/MDeMel-Dev/Doggos-4-u/blob/master/app-main.apk
- https://github.com/MDeMel-Dev/Doggos-4-u/blob/master/app-sharedElement-compose-variant.apk

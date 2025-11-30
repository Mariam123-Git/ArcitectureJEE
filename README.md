# 🌐 ArchiJEEWSRestTP

Projet  basé sur une architecture Java/JEE avec une API
REST.\
Ce dépôt contient : - La logique métier (`GreetingBusiness`) - Les
services REST - Les tests unitaires JUnit 5

------------------------------------------------------------------------

## 📁 Structure du projet

    ArchiJEEWSRestTP/
     ├── src/
     │   ├── main/
     │   │   ├── java/
     │   │   └── resources/
     │   └── test/
     │       ├── java/
     │       └── resources/
     ├── build.gradle
     ├── settings.gradle
     └── README.md

------------------------------------------------------------------------

## ⚙️ Technologies utilisées

-   Java 20
-   Gradle 8
-   JUnit 5
-   Jakarta EE / JAX-RS
-   REST API

------------------------------------------------------------------------

## 🚀 Lancer le projet

``` bash
./gradlew clean build
./gradlew bootRun
```

------------------------------------------------------------------------

## 🧪 Exécution des tests

``` bash
./gradlew test
```

------------------------------------------------------------------------

## ✔️ Correctifs appliqués (tests JUnit)

### Classe `GreetingBusiness.java`

``` java
public class GreetingBusiness {

    public Greeting greeting(String name){
        return new Greeting("Hello", name);
    }

    public Greeting badGreeting(){
        return new Greeting("le champ name est obligatoire.Merci de le renseigner", "mariam");
    }
}
```

### Classe `GreetingBusinessTest.java`

``` java
public class GreetingBusinessTest {

    private final GreetingBusiness greetingBusiness = new GreetingBusiness();

    @Test
    public void testGreeting() {
        String name = "John";
        Greeting greeting = greetingBusiness.greeting(name);
        assertEquals("Hello", greeting.getMessage());
        assertEquals(name, greeting.getAuthor());
    }

    @Test
    public void testBadGreeting() {
        Greeting badGreeting = greetingBusiness.badGreeting();
        assertEquals("le champ name est obligatoire.Merci de le renseigner", badGreeting.getMessage());
        assertEquals("mariam", badGreeting.getAuthor());
    }
}
```



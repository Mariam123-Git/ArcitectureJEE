package fr.ubo.hello.business;

import fr.ubo.hello.bean.Greeting;

public class GreetingBusinessInterface {

    public Greeting greeting(String greeting){
        return new Greeting("hello",greeting);
    }
    public Greeting badGreeting(){
        return new Greeting("le champ name est obligatoire.Merci de le renseigner");
    }
}

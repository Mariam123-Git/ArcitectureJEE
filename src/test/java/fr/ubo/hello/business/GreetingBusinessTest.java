package fr.ubo.hello.business;


import fr.ubo.hello.bean.Greeting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GreetingBusinessTest {

    private final GreetingBusiness greetingBusiness = new GreetingBusiness();

    @Test
    public void testGreeting() {
        String name = "John";
        Greeting greeting = greetingBusiness.greeting(name);
        assertEquals("hello", greeting.getMessage());
        assertEquals(name, greeting.getAuthor());    }
    @Test
    public void testBadGreeting() {
        Greeting badGreeting = greetingBusiness.badGreeting();
        assertEquals("le champ name est obligatoire.Merci de le renseigner", badGreeting.getMessage());
        assertEquals("mariam", badGreeting.getAuthor());  // ici on attend "mariam"
    }


}
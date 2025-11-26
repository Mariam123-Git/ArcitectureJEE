package fr.ubo.hello.business;

import fr.ubo.hello.bean.Greeting;

public class GreetingBusiness extends GreetingBusinessInterface {
    @Override
    public Greeting greeting(String greeting) {
        return super.greeting(greeting);
    }

    @Override
    public Greeting badGreeting() {
        return super.badGreeting();
    }
}

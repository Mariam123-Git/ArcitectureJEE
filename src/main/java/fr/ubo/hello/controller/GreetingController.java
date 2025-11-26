package fr.ubo.hello.controller;

import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ubo.hello.bean.Greeting;
import fr.ubo.hello.business.GreetingBusiness;


/**
 * Contrôleur REST pour gérer les requêtes de greetings.
 */
@RestController
public class GreetingController {
   //final GreetingBusiness business;---Avant injection
   @Inject
    GreetingBusiness business;

    /**
     * Constructeur injectant la couche métier.
     */
    public GreetingController() {
        this.business = new GreetingBusiness();
    }

    /**
     * Endpoint retournant un greeting incorrect.
     * @return un objet Greeting
     */
    @RequestMapping(value="/greeting")
    public Greeting greeting() {
        return business.badGreeting();
    }

    /**
     * Endpoint retournant un greeting selon le nom fourni.
     * @param name nom de la personne
     * @return un objet Greeting
     */
    @RequestMapping(value="/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return business.greeting(name);
    }


    /**
     * Méthode de salutation avec paramètre optionnel 'name'.
     *
     * @param name le nom à utiliser dans la salutation, par défaut "world"
     * @return un objet Greeting personnalisé selon le nom fourni
     */
    @RequestMapping(value="/greeting2")
    public Greeting greeting2(@RequestParam(value="name",required=false,defaultValue="world") String name) {
        return business.greeting(name);
    }
    /**
     * Méthode de salutation avec paramètre obligatoire 'name'.
     *
     * @param name le nom à utiliser dans la salutation, obligatoire
     * @return un objet Greeting personnalisé selon le nom fourni
     */
    @RequestMapping(value="/greeting3")
    public Greeting greeting3(@RequestParam(value="name",required=true) String name) {
        return business.greeting(name);
    }
}

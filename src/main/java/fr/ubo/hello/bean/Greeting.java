package fr.ubo.hello.bean;
import java.time.LocalDateTime;

/**
 * Bean représentant un message de salutation.
 * <p>
 * Cette classe est un simple POJO (Plain Old Java Object)
 * utilisé pour stocker les informations d'un message "Hello World".
 * </p>
 *
 * @author Mariam
 * @version 1.0
 */

public class Greeting {
    /** Contenu du message (ex : "Hello World"). */
    private String message;

    /** Auteur du message. */
    private String author;

    /** Date et heure de création du message. */
    private LocalDateTime date;

    /**
     * Constructeur avec paramètres pour initialiser le message.
     *
     * @param message contenu du message.
     * @param author  auteur du message.
     */

    public Greeting(String message, String author) {
        this.message = message;
        this.author = author;
        this.date = LocalDateTime.now();    }
    // Constructeur avec auteur optionnel (valeur par défaut)
    public Greeting(String message) {
        this(message, "mariam"); // appel du constructeur principal avec valeur par défaut
    }

    /** @return le message. */
    public String getMessage() {
        return message;
    }

    /** @param message définit le contenu du message. */
    public void setMessage(String message) {
        this.message = message;
    }

    /** @return l'auteur */
    public String getAuthor() {
        return author;
    }

    /** @param  author définit l'authuer du message. */
    public void setAuthor(String author) {
        this.author = author;
    }

    /** @return la date de l'envoie du message **/
    public LocalDateTime getDate() {
        return date;
    }

    /** @param Date définit la date de l'envoie du message. */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}

package src.server;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe ClientProfile qui gère les profils des clients.
 */
public class ClientProfile {
    private String name;
    private String email;
    private List<String> purchases;

    /**
     * Constructeur de la classe ClientProfile.
     * 
     * @param name Le nom du client.
     * @param email L'email du client.
     */
    public ClientProfile(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchases = new ArrayList<>();
    }

    /**
     * Ajoute un achat à la liste des achats du client.
     * 
     * @param purchase L'achat à ajouter.
     */
    public void addPurchase(String purchase) {
        purchases.add(purchase);
    }

    /**
     * Retourne le nom du client.
     * 
     * @return Le nom du client.
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne l'email du client.
     * 
     * @return L'email du client.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retourne la liste des achats du client.
     * 
     * @return La liste des achats.
     */
    public List<String> getPurchases() {
        return purchases;
    }
}
package org.ema.infres6.junit.comptebancaire;

public class CompteBancaire {
    protected String numeroDeCompte;
    protected Integer soldeInitial;
    protected Integer sommeATraiter;

    public CompteBancaire(String numeroDeCompte, Integer soldeInitial,
            Integer sommeATraiter) {
        this.numeroDeCompte = numeroDeCompte;
        this.soldeInitial = soldeInitial;
        this.sommeATraiter = sommeATraiter;
    }

    public String interrogerCompte(String motdepasse) {
        String resultat = null;

        if (motdepasse.equals("madatedenaissance")) {
            Integer solde = calculDuSolde(soldeInitial, sommeATraiter);

            if (solde > 0) {
                /* créditeur */
                resultat = "Informations du compte: ";
                resultat += numeroDeCompte;
                resultat += "\r\n";
                resultat += "Votre compte est créditeur de ";
                resultat += solde.toString();
                resultat += "€";
            } else if (solde == 0) {
                /* équilibre */
                resultat = "Informations du compte: ";
                resultat += numeroDeCompte;
                resultat += "\r\n";
                resultat += "Vous devriez approvisionner votre compte ";
                resultat += solde.toString();
                resultat += "€";
            } else {
                /* débiteur */
                resultat = "Informations du compte: ";
                resultat += numeroDeCompte;
                resultat += "\r\n";
                resultat += "Votre compte est débiteur de ";
                resultat += solde.toString();
                resultat += "€";
                signalerCompteDebiteur();
            }
        } else {
            gererErreurDeMotDePasse();
        }
        return resultat;
    }

    protected Integer calculDuSolde(Integer soldeInitial, Integer sommeATraiter) {
        Integer solde = soldeInitial + sommeATraiter;
        return solde;
    }

    protected void gererErreurDeMotDePasse() {
        throw new RuntimeException("Mot de passe erroné");
    }

    protected void signalerCompteDebiteur() {
        throw new RuntimeException(
                "Ce compte sera débiteur après cette operation");
    }
}
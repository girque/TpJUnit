package org.ema.infres6.junit.comptebancaire;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ema.infres6.junit.comptebancaire.CompteBancaire;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompteBancaireTest {

    private static Logger logManager = LogManager
            .getLogger(CompteBancaireTest.class.getName());

    private CompteBancaire compteBancaireCrediteur;
    private CompteBancaire compteBancaireEquilibre;
    private CompteBancaire compteBancaireDebiteur;
    private String numeroDeCompte;
    private String motDePasse;

    private Integer soldeInitialPositif;
    private Integer soldeEquilibre;
    private Integer soldeDebiteur;

    private Integer aSoustrairePourEquilibre;
    private Integer aSoustrairePourDebiteur;

    private String resultatCrediteurAttendu;
    private String resultatEquilibreAttendu;
    private String resultatDebiteurAttendu;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        numeroDeCompte = "123456789";
        motDePasse = "madatedenaissance";
        soldeInitialPositif = 50;

        aSoustrairePourDebiteur = -100;
        aSoustrairePourEquilibre = -50;

        compteBancaireCrediteur = new CompteBancaire(numeroDeCompte,
                soldeInitialPositif, 0);
        compteBancaireEquilibre = new CompteBancaire(numeroDeCompte,
                soldeInitialPositif, aSoustrairePourEquilibre);
        compteBancaireDebiteur = new CompteBancaire(numeroDeCompte,
                soldeInitialPositif, aSoustrairePourDebiteur);

        soldeEquilibre = compteBancaireEquilibre.calculDuSolde(
                soldeInitialPositif, aSoustrairePourEquilibre);
        soldeDebiteur = compteBancaireDebiteur.calculDuSolde(
                soldeInitialPositif, aSoustrairePourDebiteur);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInterrogerCompteMotDePasseOk() {
        compteBancaireCrediteur = new CompteBancaire(numeroDeCompte,
                soldeInitialPositif, 0);

        resultatCrediteurAttendu = "Informations du compte: ";
        resultatCrediteurAttendu += numeroDeCompte;
        resultatCrediteurAttendu += "\r\n";
        resultatCrediteurAttendu += "Votre compte est créditeur de ";
        resultatCrediteurAttendu += compteBancaireCrediteur.calculDuSolde(
                soldeInitialPositif, 0).toString();
        resultatCrediteurAttendu += "€";

        assertEquals(resultatCrediteurAttendu,
                compteBancaireCrediteur.interrogerCompte(motDePasse));
    }

    @Test
    public void testInterrogerCompteMotDePassePasOk() {
        try {

            assertEquals(
                    null,
                    compteBancaireCrediteur.interrogerCompte(motDePasse
                            + "notok"));
        } catch (RuntimeException e) {
            logManager.fatal(e.getMessage() + "\nCompte: " + numeroDeCompte
                    + "\n\n");
        }
    }

    @Test
    public void testInterrogerCompteCrediteur() {
        resultatCrediteurAttendu = "Informations du compte: ";
        resultatCrediteurAttendu += numeroDeCompte;
        resultatCrediteurAttendu += "\r\n";
        resultatCrediteurAttendu += "Votre compte est créditeur de ";
        resultatCrediteurAttendu += soldeInitialPositif;
        resultatCrediteurAttendu += "€";

        assertEquals(resultatCrediteurAttendu,
                compteBancaireCrediteur.interrogerCompte(motDePasse));
    }

    @Test
    public void testInterrogerCompteEquilibre() {
        resultatEquilibreAttendu = "Informations du compte: ";
        resultatEquilibreAttendu += numeroDeCompte;
        resultatEquilibreAttendu += "\r\n";
        resultatEquilibreAttendu += "Vous devriez approvisionner votre compte ";
        resultatEquilibreAttendu += soldeEquilibre;
        resultatEquilibreAttendu += "€";

        assertEquals(resultatEquilibreAttendu,
                compteBancaireEquilibre.interrogerCompte(motDePasse));
    }

    @Test
    public void testInterrogerCompteDebiteur() {
        try {
            resultatDebiteurAttendu = "Informations du compte: ";
            resultatDebiteurAttendu += numeroDeCompte;
            resultatDebiteurAttendu += "\r\n";
            resultatDebiteurAttendu += "Votre compte est débiteur de ";
            resultatDebiteurAttendu += soldeDebiteur;
            resultatDebiteurAttendu += "€";

            assertEquals(resultatDebiteurAttendu,
                    compteBancaireDebiteur.interrogerCompte(motDePasse));
        } catch (RuntimeException e) {
            logManager.fatal(e.getMessage() + "\nCompte: " + numeroDeCompte
                    + "\n\n");
        }
    }
}
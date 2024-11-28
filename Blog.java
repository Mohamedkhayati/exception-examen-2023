package tp9;

import java.time.LocalDate;

public class Blog {
    private String titre;
    private Publiable[] billets;
    private int nbBillets;

    public Blog(String titre, int capacité) {
        this.titre=titre;
        this.billets=new Publiable[capacité];
        this.nbBillets=0;
    }

    public void post(Publiable billet) throws InvalidURLException {
        if (billet instanceof Video) {
            Video video=(Video) billet;
            if (!video.getUrl().startsWith("https")) {
                throw new InvalidURLException("URL de vidéo non sécurisée.");
            }
        }
        if (nbBillets < billets.length) {
            billets[nbBillets++]=billet;
        }
    }

    public int getNombreBilletsTaggables() {
        int count=0;
        for (int i=0;i<nbBillets;i++) {
            if (billets[i] instanceof BilletTaggable) {
                count++;
            }
        }
        return count;
    }

    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
        Publiable[] result=new Publiable[nbBillets];
        int index=0;
        for (int i=0;i<nbBillets;i++) {
            if (billets[i] instanceof BilletTaggable && billets[i].getAuteur().equals(auteur)) {
                result[index++]=billets[i];
            }
        }
        return result;
    }

    public Publiable getPlusRécentBillet() {
        Publiable billetPlusRécent = billets[0];
        for (int i=1;i<nbBillets;i++) {
            if (billets[i].getDatePub().isAfter(billetPlusRécent.getDatePub())) {
                billetPlusRécent=billets[i];
            }
        }
        return billetPlusRécent;
    }

    public Publiable[] RechercheBilletsParContenu(String[] mots) {
        Publiable[] result=new Publiable[nbBillets];
        int index=0;
        for (int i=0;i<nbBillets;i++) {
            if (billets[i] instanceof Message) {
                Message message=(Message) billets[i];
                boolean match=true;
                for (String mot : mots) {
                    if (!message.getMsg().contains(mot)) {
                        match=false;
                        break;
                    }
                }
                if (match) {
                    result[index++]=billets[i];
                }
            }
        }
        return result;
    }
}


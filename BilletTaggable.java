package tp9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BilletTaggable extends Billet implements Taggable {
    private List<String> tags;
    private int nbTags;
    public BilletTaggable(LocalDate datePub, String auteur, int capacité) {
        super(datePub, auteur);
        this.tags=new ArrayList<>(capacité);
        this.nbTags=0;
    }
    public void ajoutTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
            nbTags++;
        }
    }

    @Override
    public void supprimeTag(String tag) {
        if (tags.contains(tag)) {
            tags.remove(tag);
            nbTags--;
        }
    }

    public int nombreTags() {
        return nbTags;
    }

    public int rechercheTag(String tag) {
        return tags.indexOf(tag);
    }


    public String toString() {
        return super.toString()+",tags="+tags;
    }
}

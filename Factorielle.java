package tp_Exception;

class Factorielle {
    public static void main(String[] args) {
        try {
            if (args.length==0) {
                throw new IllegalArgumentException("Donnez en paramètre la base de la factorielle");
            }

            int nbEntiers=Integer.parseInt(args[0]);

            if (nbEntiers<0) {
                throw new IllegalArgumentException(nbEntiers + " est négatif : la factorielle d'un nombre négatif n'est pas définie");
            }

            int factorielle = 1;
            for (int i = 2; i <= nbEntiers; i++) {
                factorielle *= i;
            }

            System.out.println("Voilà la factorielle des " + nbEntiers + " premiers entiers : " + factorielle);

        } catch (NumberFormatException e) {
            System.out.println("La base de la factorielle doit être ENTIÈRE");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

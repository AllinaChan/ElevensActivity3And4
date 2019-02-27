import java.util.List;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 1;


    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive perfect shuffles:");
        int[] values1 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive efficient selection shuffles:");
        int[] values2 = {0, 1, 2, 3};
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    int [] values = {1,2,34,3,45,6,7,8,3,9};
    public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        int half = (int)(values.length/2);

        int [] everyother = new int [half];
        int[] rest = new int[half];

        for(int i = 0; i < half; i++){
            everyother[i] = values[i];
        }

        int r = 0;
        for(int w = (half+1); w < values.length; w++){
            rest[r] = values[w];
            r+=1;
        }


        int y = 0;
        for (int x = 0; x< values.length;){
            values[x] = everyother[y];
            x+=2;
            y+=1;
        }
        int u = 0;
        for (int t = 1; t < values.length;){
            values[t] = rest[u];
            t+=2;
            u+=1;
        }



    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(List<Card> values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        for(int k = values.size()-1; k > 0; k--)
        {
            int r = (int)(Math.random()*k);

            Card temp = values.get(r);
            values.set(r,values.get(k));
            values.set(k, temp);

        }
     }
    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        for(int k = values.length-1; k > 0; k--)
        {
            int r = (int)(Math.random()*k);

            int temp = values[r];
            values[r] = values[k];
            values[k]= temp;

        }
    }
}


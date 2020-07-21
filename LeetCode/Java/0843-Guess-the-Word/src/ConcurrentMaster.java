/**
 * @author angus on 2020/7/11
 * @since 1.0.0
 */
public class ConcurrentMaster implements Master {

    private String secret;

    public ConcurrentMaster(String secret) {
        this.secret = secret;
    }

    @Override
    public int guess(String word) {
        int matchFactor = 0;
        for (int i = 0; i < 6; i++) {
            if (secret.charAt(i) == word.charAt(i)) matchFactor++;
        }
        System.out.println("guess word: " + word + ", matchFactor: " + matchFactor);
        return matchFactor;
    }
}

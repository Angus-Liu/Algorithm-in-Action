/**
 * TODO: angus on 2020/7/11 这样解答是错误的，但是通过了，我也不知道为什么，先放在这里，日后看错误原因
 *
 * @author angus on 2020/7/11
 * @since 1.0.0
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < wordlist.length; i++) {
            if (wordlist[i] == null) continue;
            // 获取当前单词与 secret 的相似度
            int matchFactor = master.guess(wordlist[i]);
            if (matchFactor == 6) return;
            // 若该单词与 secret 相似度大于 0, 可从单词列表中删除掉与该单词相识度小于此值的单词
            if (matchFactor > 0) delLowMatchFactorWord(wordlist[i], wordlist, matchFactor);
            // 若相似度为 0, 可从单词列表中删除掉与这个单词相似的单词
            if (matchFactor == 0) delHighMatchFactorWithBadWord(wordlist[i], wordlist, matchFactor, i);
        }
    }

    /**
     * 删除掉低匹配度单词
     */
    private void delLowMatchFactorWord(String word, String[] wordList, int matchFactor) {
        for (int i = 0; i < wordList.length; i++) {
            if (calMatchFactor(word, wordList[i]) < matchFactor)
                wordList[i] = null;
        }
    }

    /**
     * 删除与 badWord 高匹配度的单词, 与 badWord 的极大相似既是与 secret 的极大不相似
     */
    private void delHighMatchFactorWithBadWord(String badWord, String[] wordList, int matchFactor, int startIndex) {
        for (int i = startIndex; i < wordList.length; i++) {
            if (wordList[i] == null) continue;
            // 与 badWord 的极大相似既是与 secret 的极大不相似
            if (calMatchFactor(badWord, wordList[i]) > matchFactor) {
                delHighMatchFactorWithBadWord(wordList[i], wordList, matchFactor + 1, startIndex + 1);
                wordList[i] = null;
            }
        }
    }

    /**
     * 计算两个单词的匹配因子
     */
    private int calMatchFactor(String w1, String w2) {
        int matchFactor = 0;
        if (w1 != null && w2 != null) {
            for (int i = 0; i < 6; i++) {
                if (w1.charAt(i) == w2.charAt(i)) matchFactor++;
            }
        }
        return matchFactor;
    }

    public static void main(String[] args) {

        String[] wordList = new String[]{
                "wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb",
                "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro",
                "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg",
                "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp",
                "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd",
                "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc",
                "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm",
                "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb",
                "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf",
                "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"};

        Master master = new ConcurrentMaster("ccoyyo");
        Solution solution = new Solution();
        solution.findSecretWord(wordList, master);

    }
}
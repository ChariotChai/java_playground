package play;

public class Manachar {

    public int maxPanlidom(String s) {
        char[] cs = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            cs[i * 2 + 1] = s.charAt(i);
        }

        int ans = 0, rightMax = 0, rightMaxCenter = 0;
        int[] radius = new int[cs.length];
        for (int i = 1; i < cs.length; i++) {
            int r = i < rightMax ? Math.min(rightMax - i, radius[2 * rightMaxCenter - i]) : 0;
            //从中心往外搜索
            while (i - r - 1 >= 0 && i + r + 1 < cs.length && cs[i - r - 1] == cs[i + r + 1]) {
                r++;
            }
            if (i + r > rightMax) {
                rightMax = i + r;
                rightMaxCenter = i;
            }
            radius[i] = r;
            ans = Math.max(ans, r);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Manachar().maxPanlidom("abcdcba"));
    }

}

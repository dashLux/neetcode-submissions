class Solution {

    public String encode(List<String> strs) {
        /**
            using delimiter \*
            \ -> \\
            abc\d -> abc\\d

            abcd\*beadf -> "abcd", "beadf"

        */
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            String modified = s.replace("/", "//");
            sb.append(modified);
            sb.append("/*");

        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> out = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        while (i < str.length()) {
            if (str.charAt(i) == '/' && str.charAt(i+1) == '*') {
                out.add(current.toString());
                current = new StringBuilder();
                i += 2;
            }
            else if (str.charAt(i) == '/' && str.charAt(i+1) == '/') {
                current.append('/');
                i += 2;
            }
            else {
                current.append(str.charAt(i));
                i += 1;
            }
        }

        return out;
    }
}

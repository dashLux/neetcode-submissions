class Solution {

    /**
        Using special delimiter /* to separate two strings
        If exists / in original string, replace with //

        "a/bc" -> "a//bc"
        "abc", "def" -> "abc/*def"
    */

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            String re = s.replace("/", "//");
            sb.append(re);
            sb.append("/*");
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < str.length() - 1) {
            if(str.charAt(index) == '/' && str.charAt(index+1) == '*') {
                res.add(sb.toString());
                sb = new StringBuilder();
                index += 2;
            }
            else if (str.charAt(index) == '/' && str.charAt(index+1) == '/') {
                sb.append('/');
                index += 2;
            }
            else {
                sb.append(str.charAt(index));
                index += 1;
            }
        }
        return res;

    }
}

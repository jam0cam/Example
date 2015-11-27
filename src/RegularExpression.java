import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jitse on 11/18/15.
 */
public class RegularExpression {

    static String htmlTag = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <!--<script type=\"text/javascript\">-->\n" +
            "\n" +
            "        <!--document.addEventListener(\"DOMContentLoaded\", function () {-->\n" +
            "\n" +
            "            <!--var anchors = document.getElementsByTagName('a'), toRemove = [];-->\n" +
            "\n" +
            "            <!--// Remove all anchors-->\n" +
            "            <!--for (var i = 0; i < anchors.length; i++) {-->\n" +
            "                <!--var parent = anchors[i];-->\n" +
            "\n" +
            "                <!--while ((parent = parent.parentNode)) {-->\n" +
            "                    <!--if (parent.tagName === 'LI') {-->\n" +
            "                        <!--//parent.parentNode.removeChild(parent);-->\n" +
            "                        <!--toRemove.push(parent);-->\n" +
            "                        <!--break;-->\n" +
            "                    <!--}-->\n" +
            "                <!--}-->\n" +
            "            <!--}-->\n" +
            "\n" +
            "\n" +
            "            <!--// Moved here in case there was more than one link-->\n" +
            "            <!--for (var x = 0; x < toRemove.length; x++) {-->\n" +
            "                <!--document.getElementsByTagName('ul')[0].removeChild(toRemove[x]);-->\n" +
            "            <!--}-->\n" +
            "        <!--}, false);-->\n" +
            "\n" +
            "    <!--</script>-->\n" +
            "\n" +
            "    <style type=\"text/css\">\n" +
            "\n" +
            "        body {\n" +
            "            font-family: Roboto, Droid Sans, Verdana, sans-serif;\n" +
            "            color: #a0a0a0;\n" +
            "            width: 96%;\n" +
            "            margin: 0;\n" +
            "            padding: 20px 2% 20px 2%;\n" +
            "            font-size: 10pt;\n" +
            "        }\n" +
            "\n" +
            "        h2 {\n" +
            "            font-weight: bold;\n" +
            "            font-size: 12pt;\n" +
            "        }\n" +
            "\n" +
            "        ul {\n" +
            "            margin: 0 0 0 0;\n" +
            "            padding: 0 25px 0 25px;\n" +
            "            list-style-type: square;\n" +
            "        }\n" +
            "\n" +
            "        ul li:first-child {\n" +
            "            font-weight: normal;\n" +
            "            padding: 0;\n" +
            "            margin: 0 0 20px -17px;\n" +
            "            list-style: none;\n" +
            "            font-size: 14pt;\n" +
            "            color: #717171;\n" +
            "        }\n" +
            "\n" +
            "        li ul li:first-child {\n" +
            "            font-family: Roboto, Droid Sans, Verdana, sans-serif;\n" +
            "            margin: 6px 0;\n" +
            "            font-weight: normal;\n" +
            "            font-style: normal;\n" +
            "            list-style: square;\n" +
            "            color: #a0a0a0;\n" +
            "            width: 100%;\n" +
            "            font-size: 10pt;\n" +
            "        }\n" +
            "\n" +
            "        li {\n" +
            "            margin-bottom: 6px;\n" +
            "        }\n" +
            "\n" +
            "        a {\n" +
            "            color: #464646;\n" +
            "            text-decoration: none;\n" +
            "        }\n" +
            "    </ style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <ul><li>Knit cap with contrasting brim.</li><li>SKU: 8478473</li>\n" +
            "<li>Floral detail at the side.</li>\n" +
            "<li>Interior hatband for all-day wear.</li>\n" +
            "<li>60% wool, 40% polyester.</li>\n" +
            "<li>Spot clean only. </li>\n" +
            "<li>Imported.</li>\n" +
            "<li class=\"measurements\">Measurements:\n" +
            "<ul>\n" +
            "    <li> Circumference: 22 in</li>\n" +
            "    <li> Brim: 2 in</li>\n" +
            "    </ul>\n" +
            "</li>\n" +
            "</ul>\n" +
            "</body>\n" +
            "</html>";

    public static void main(String[] args) {
        indentLiTags();
    }

    private static void indentLiTags2() {
        Pattern p = Pattern.compile("(<\\s*li.*>)");
        Matcher m = p.matcher(htmlTag);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            sb.append("#").append(m.group(1));
        }
        System.out.println(sb.toString());
    }

    public static void removeStyleTags() {
        String pattern = "(<\\s*style.*?>)([\\s\\S]*)(<\\s*/\\s*style\\s*>)";
        String rval = htmlTag.replaceAll(pattern, "");
        System.out.println(rval);
    }

    public static void indentLiTags() {
        String pattern = "(<\\s*li.*?>)";
        String rval = htmlTag.replaceAll(pattern, "<li> \t");
        System.out.println(rval);
    }
}

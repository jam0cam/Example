/**
 * User: jitse
 * Date: 1/11/15
 * Time: 8:18 AM
 */
public class Example {

    public static void main(String[] args) {
        String s = "high waisted/filter/categoryFacet/\"Bottoms\"/brandNameFacet/\"Volcom\"/personalityFacet/\"Casual\"/productTypeFacet/\"Clothing\"/subCategoryFacet/\"Jeans\"";
        parseUrl(s);

        System.out.println("----------------------------");
        s = "filter/categoryFacet/\"Bottoms\"/brandNameFacet/\"Volcom\"/personalityFacet/\"Casual\"/productTypeFacet/\"Clothing\"/subCategoryFacet/\"Jeans\"";
        parseUrl(s);


        System.out.println("----------------------------");
        s = "high waisted";
        parseUrl(s);
    }

    public static void parseUrl(String s) {
        String filter = "filter/";
        int filterIndex = s.indexOf(filter);

        if (filterIndex > 0) { //there are things before the filter, we'll call that the search term
            String searchTerm = s.substring(0, filterIndex-1);
            System.out.println("search term||" + searchTerm + "||");
        } else if (filterIndex < 0) {
            //there is no filter, so there is only a search term
            String searchTerm = s;
            System.out.println("search term||" + searchTerm + "||");
            return;
        }

        String parameters = s.substring(filterIndex + filter.length());

        while (parameters.contains("/")) {

            int firstIndex = parameters.indexOf("/");
            String key = parameters.substring(0, firstIndex);

            parameters = parameters.substring(firstIndex + 1);

            String value;
            int secondIndex = parameters.indexOf("/");
            if (secondIndex < 0) {
                //that means there are nothing left, take the entire string
                value = parameters;
            } else {
                value = parameters.substring(0, secondIndex);
                parameters = parameters.substring(secondIndex+1);
            }
            System.out.println("||" + key + "::" + value + "||");
        }
    }
}

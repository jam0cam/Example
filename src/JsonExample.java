import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jitse
 * Date: 3/11/15
 * Time: 8:52 AM
 */
public class JsonExample {

    public static void main(String[] args) throws IOException {
        List<Image> list = new ArrayList<>();

        list.add(new Image("Nike", "http://www.zappos.com/images/z/2/7/2/7/3/6/2727366-p-MULTIVIEW.jpg"));
        list.add(new Image("Adidas", "http://www.zappos.com/images/z/2/7/4/4/0/0/2744001-p-MULTIVIEW.jpg"));
        list.add(new Image("Brooks", "http://www.zappos.com/images/z/2/4/7/5/3/3/2475333-p-MULTIVIEW.jpg"));
        list.add(new Image("Asics", "http://www.zappos.com/images/z/2/6/2/8/1/0/2628105-p-MULTIVIEW.jpg"));
        list.add(new Image("Puma", "http://www.zappos.com/images/z/2/6/2/7/3/5/2627354-p-MULTIVIEW.jpg"));
        list.add(new Image("New Balance", "http://www.zappos.com/images/z/2/7/3/8/3/8/2738382-p-MULTIVIEW.jpg"));
        list.add(new Image("Soucony", "http://www.zappos.com/images/z/2/4/7/4/6/6/2474664-p-MULTIVIEW.jpg"));


        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(list));

    }
}

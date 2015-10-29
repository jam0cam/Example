/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class Test {

    public static void main(String[] args) {
        GoodPerson gp = (GoodPerson) getPerson();
        System.out.println(gp.name + " "  + gp.isGood);



        Person p = getPerson();
        System.out.println(p.name + " ");

        Person p2 = getPerson2();

        System.out.println(p2.name);
    }

    public static Person getPerson() {
        GoodPerson p = new GoodPerson("jia");
        p.isGood = true;
        return p;
    }

    public static GoodPerson getPerson2() {
        return new GoodPerson("testing");
    }



}

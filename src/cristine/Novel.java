/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristine;

/**
 *
 * @author mariacristinedeleon
 */
public class Novel extends Book {
    private int chapters;
    
    public Novel (String title, int pages, int chapters) {
        super (title, pages);
        this.chapters = chapters; 
    }
    
    public void print () {
        super.print();
        System.out.println("and" + chapters + "chapters");
}
}
       
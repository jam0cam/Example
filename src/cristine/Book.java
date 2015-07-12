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
public class Book {
    private String title;
    private int pages;
    
    public Book(String title, int pages) {
        this.title = new String(title);
        setPages(pages); 
        }
    public void setPages(int pages) {
            this.pages = pages; 
    }
    public int getPages() {
        return pages;
    }
    public void print() {
        System.out.println(title + "has" + "pages" + "pages");
    }
}

            

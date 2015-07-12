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
public class Almanac extends Book{
    private int charts;
        
    public Almanac(String title, int pages, int charts) {
        super(title, pages);
        setCharts(charts);
        }
        public boolean setCharts(int charts) {
            if(charts > getPages()) {
                System.err.println("Too many charts");
                return false; 
        }   else {
                this.charts = charts;
                return true; 
    }
    }
    public int getCharts()
    {
    return charts;
    }
    public void print() 
    {
    super.print(); 
    System.out.println ("and" + charts + "charts");
    }
}

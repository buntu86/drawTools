package drawtools.faconnage;

/**
 *
 * @author Adrien
 */
public class Diametre {

    private int diam, d1, aD1, bD1, cD1, d2, aD2, bD2, aCrochet, bCrochet, d3, aD3, bD3, id, recouv50, recouv60, recouv70;
    private double as, kg;
    
    public Diametre(int diam, int id, 
            int d1, int aD1, int bD1, int cD1, 
            int d2, int aD2, int bD2, 
            int aCrochet, int bCrochet, 
            int d3, int aD3, int bD3){
        setDiam(diam);
        setId(id);
        setAs();
        setKg();
        setD1(d1, aD1, bD1, cD1);
        setD2(d2, aD2, bD2);
        setD3(d3, aD3, bD3);
        setCrochet(aCrochet, bCrochet);
        setRecouv();
    };

    //// GENERAL ////
    public int getDiam() {
        return diam;
    }
    private void setDiam(int diam) {
        this.diam = diam;
    }

    private void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public double getAs(){
        return as;
    }
    private void setAs(){
        this.as = Math.pow((diam/2), 2)*Math.PI;
    }
    
    public double getKg(){
        return kg;
    }
    private void setKg(){
        this.kg = as/1e6*7850;
    }

    //// D1 ////
    public int getD1() {
        return d1;
    }
    public int get_aD1() {
        return aD1;
    }
    public int get_bD1() {
        return bD1;
    }
    public int get_cD1() {
        return cD1;
    }
    private void setD1(int d1, int aD1, int bD1, int cD1) {
        this.d1 = d1;
        this.aD1 = aD1;
        this.bD1 = bD1;
        this.cD1 = cD1;
    }

    //// D2 ////
    public int getD2() {
        return d2;
    }
    public int get_aD2() {
        return aD2;
    }
    public int get_bD2() {
        return bD2;
    }
    private void setD2(int d2, int aD2, int bD2) {
        this.d2 = d2;
        this.aD2 = aD2;
        this.bD2 = bD2;
    }    

    //// D3 ////
    public int getD3() {
        return d3;
    }
    public int get_aD3() {
        return aD3;
    }
    public int get_bD3() {
        return bD3;
    }
    private void setD3(int d3, int aD3, int bD3) {
        this.d3 = d3;
        this.aD3 = aD3;
        this.bD3 = bD3;
    }

    //// Crochets ////
    private void setCrochet(int aCrochet, int bCrochet) {
        this.aCrochet = aCrochet;
        this.bCrochet = bCrochet;
    }
    public int get_aCrochet() {
        return aCrochet;
    }
    public int get_bCrochet() {
        return bCrochet;
    }    

    //// Recouvrement ////
    private void setRecouv() {
        this.recouv50 = diam*50;
        this.recouv60 = diam*60;
        this.recouv70 = diam*70;
    }
    public int getRecouv50(){
        return recouv50;
    }
    public int getRecouv60(){
        return recouv60;
    }
    public int getRecouv70(){
        return recouv70;
    }    
}

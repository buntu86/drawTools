package drawtools.faconnage;

/**
 *
 * @author Adrien
 */
public class Diametre {

    private int diam, A, B, a, b, id, d1, d2, d3;
    
    public Diametre(int diam, int id){
        setDiam(diam);
        setId(id);
        setD1();
        setD2();
        setD3();
    };

    public int getDiam() {
        return diam;
    }
    public void setDiam(int diam) {
        this.diam = diam;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public int getD1() {
        return d1;
    }
    public void setD1() {
        if(diam>=12)
            this.d1 = diam*15;
        else
            this.d1 = 0;
        
        this.d1 = (int)Math.ceil((double)this.d1/5)*5;
    }

    public int getD2() {
        return d2;
    }
    public void setD2() {
        if(diam<=20)
            this.d2 = 6*diam;
        else if(diam>20 & diam<=30)
            this.d2 = 8*diam;
        else if(diam>30 & diam<=40)
            this.d2 = 10*diam;
        else
            this.d2 = 0;
        
        this.d2 = (int)Math.ceil((double)this.d2/5)*5;
    }

    public int getD3() {
        return d3;
    }
    public void setD3() {
        if(diam<=16)
            this.d3 = diam*4;
        else
            this.d3 = 0;
        
        this.d3 = (int)Math.ceil((double)this.d3/5)*5;
    }
}

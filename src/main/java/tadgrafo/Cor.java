package tadgrafo;

import java.util.ArrayList;

public class Cor {

    private int C1 = 1;
    private int C2 = 2;
    private int C3 = 3;
    private int C4 = 4;
    private int C5 = 5;
    private int C6 = 6;
    private int C7 = 7;

    public ArrayList<Integer> todasCores() {
        ArrayList<Integer> tCores = new ArrayList<Integer>();
        tCores.add(this.C1);
        tCores.add(this.C2);
        tCores.add(this.C3);
        tCores.add(this.C4);
        tCores.add(this.C5);
        tCores.add(this.C6);
        tCores.add(this.C7);
        return tCores;
    }

    public int getC1() {
        return C1;
    }

    public int getC2() {
        return C2;
    }

    public int getC3() {
        return C3;
    }

    public int getC4() {
        return C4;
    }

    public int getC5() {
        return C5;
    }

    public int getC6() {
        return C6;
    }

    public int getC7() {
        return C7;
    }

    

    @Override
    public String toString() {
        return "Cor{" + "C1=" + C1 + ", C2=" + C2 + ", C3=" + C3 + ", C4=" + C4 + ", C5=" + C5 + ", C6=" + C6 + ", C7=" + C7 + '}';
    }

}

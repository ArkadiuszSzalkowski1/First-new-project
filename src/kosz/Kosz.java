  package kosz;
public class Kosz {

     public int ileSmieci;
    final int pojemnosc;
    final int nrKosza;
    
    Kosz(int ileSmieci, int pojemnosc, int nrKosza)
    {
        this.ileSmieci = ileSmieci;
        this.pojemnosc = pojemnosc;
        this.nrKosza = nrKosza;
    }
    int getIleSmieci()
    {
        return ileSmieci;
    }
    int getPojemnosc()
    {
        return pojemnosc;
    }
    int getNrKosza()
    {
        return nrKosza;
    }
    int getReszta(int ilosc)
    {
        return ileSmieci + ilosc - pojemnosc;
    }
    int getIlosc(int ilosc)
    {
        return ilosc;
    }
//    int getIloscMinusReszta(double ilosc)
//    {
//        return ilosc - getReszta(ilosc);
//    }
    boolean wrzuc(int ilosc)
    {
        if(ilosc + ileSmieci > pojemnosc)
        {
            this.ileSmieci = pojemnosc;
            return false;
        }
        else
        {
            this.ileSmieci += ilosc;
        }
        return true;
    }
    boolean wyjmij(int ilosc)
    {   if(ileSmieci < ilosc)
        {
            return false;
        }if(ileSmieci + ilosc > pojemnosc)
        {
            this.ileSmieci -= ilosc - getReszta(ilosc);
            return true;
        }else
        {
            this.ileSmieci -= ilosc;
        return true;
    }
  
    }
    public void przerzuc(int ilosc, Kosz gdzieWrzucic){
        if(ileSmieci < ilosc){
            System.out.println("Za mało masz miejsca w koszu nr: " + getNrKosza() + ". ") ;
        }
        
        if(ileSmieci >= ilosc && ileSmieci + ilosc > pojemnosc)
        {
            System.out.println("Przerzucono z kosza nr: " + getNrKosza() + " do kosza nr." + gdzieWrzucic.getNrKosza() + " - "  + getIlosc(ilosc) + " śmieci  " );
            System.out.println("Za mała pojemność kosza nr: " + gdzieWrzucic.getNrKosza() + ". Resztę czyli " + getReszta(ilosc) + " śmieci wrzucono do kosza nr: " + getNrKosza() + ". ");
            gdzieWrzucic.wrzuc(ilosc);
        }
        if(wyjmij(ilosc) && ileSmieci + ilosc < pojemnosc && ileSmieci >= ilosc)
        {
            gdzieWrzucic.wrzuc(ilosc);
            System.out.println("Przerzucono z kosza nr: " + getNrKosza() + " do kosza nr. " + gdzieWrzucic.getNrKosza() + " - " + ilosc + " śmieci "  );
        }    
        
    }
    @Override
    public String toString() {
        return "W Koszu nr: "+ getNrKosza() + " Jest " + getIleSmieci() + " śmieci, Pojemnosc kosza wynosi: " + getPojemnosc() + " jednostek";
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Kosz[] kosz = new Kosz[5];
        
        for(int i = 0; i < 5; i++)
            for(int a = 0; a < 5; a++)
                kosz[i] = new Kosz(10, 15, i + 1);
        
         kosz[0].przerzuc(10, kosz[1]);
         kosz[2].przerzuc(5, kosz[3]);
         kosz[4].przerzuc(3, kosz[0]);
         kosz[4].przerzuc(8, kosz[0]);
         
         
         System.out.println(kosz[0]);
         System.out.println(kosz[1]);
         System.out.println(kosz[2]);
         System.out.println(kosz[3]);
         System.out.println(kosz[4]);
    }
    
}
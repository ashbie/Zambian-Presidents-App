package kas.du.usingrecyclerview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {
    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 7;

    public MyApplication(){
        createPresidents();
    }

    public List<President> getPresidentList() {
        return this.presidentList;
    }

    public void setPresidentList(List<President> presidentList) {
        this.presidentList = presidentList;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    private void createPresidents(){

        President Kaunda = new President(0, "Kenneth Kaunda", 1964, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Kenneth_David_Kaunda.jpg/80px-Kenneth_David_Kaunda.jpg");
        President Chiluba = new President(1, "Fredrick Chiluba", 1991, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Frederick_Chiluba_%28cropped%29.jpg/80px-Frederick_Chiluba_%28cropped%29.jpg");
        President Mwanawasa = new President(2, "Levy Mwanawasa", 2001, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Levy_Mwanawasa.jpg/80px-Levy_Mwanawasa.jpg");
        President Rupiah = new President(3, "Rupiah Banda", 2008, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Rupiah_Banda_2010-11-18.jpg/80px-Rupiah_Banda_2010-11-18.jpg");
        President Sata = new President(4, "Micheal C. Sata", 2011, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Michael_Sata_2013_%28cropped%29.jpg/80px-Michael_Sata_2013_%28cropped%29.jpg");
        President Lungu = new President(5, "Edgar C. Lungu", 2015, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Edgar_Lungu%2C_26_july_2018_%28cropped%29.jpg/80px-Edgar_Lungu%2C_26_july_2018_%28cropped%29.jpg");
        President Bally = new President(6, "Hakainde Hichilema", 2021, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Hakainde_Hichilema_2022_%28cropped%29.jpg/80px-Hakainde_Hichilema_2022_%28cropped%29.jpg");
        presidentList.addAll(Arrays.asList(new President[]  {Kaunda, Chiluba, Mwanawasa, Rupiah, Sata, Lungu, Bally}));
    }
}

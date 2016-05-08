package tw.delta4studio.www.molecomputer;



import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Map<String, Float> periodicTable = new HashMap<String, Float>();

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final TextView numberView = (TextView) findViewById(R.id.textView3);
        final TextView weightView = (TextView) findViewById(R.id.textView5);
        Button calculateBtn = (Button) findViewById(R.id.button);
        final EditText src = (EditText) findViewById(R.id.editText);



        // Create Periodic Table
        // Need to trans to JSON
        periodicTable.put("H"  , new Float(1.008) ); periodicTable.put("He" , new Float(4.003) );
        periodicTable.put("Li" , new Float(6.941) ); periodicTable.put("Be" , new Float(9.012) ); periodicTable.put("B"  , new Float(10.81) ); periodicTable.put("C"  , new Float(12.01) ); periodicTable.put("N"  , new Float(14.01) ); periodicTable.put("O"  , new Float(16.00) ); periodicTable.put("F"  , new Float(19.00) ); periodicTable.put("Ne" , new Float(20.18) );
        periodicTable.put("Na" , new Float(22.99) ); periodicTable.put("Mg" , new Float(24.31) ); periodicTable.put("Al" , new Float(26.98) ); periodicTable.put("Si" , new Float(28.09) ); periodicTable.put("P"  , new Float(30.97) ); periodicTable.put("S"  , new Float(32.07) ); periodicTable.put("Cl" , new Float(35.45) ); periodicTable.put("Ar" , new Float(39.95) );
        periodicTable.put("K"  , new Float(39.10) ); periodicTable.put("Ca" , new Float(40.08) ); periodicTable.put("Sc" , new Float(44.96) ); periodicTable.put("Ti" , new Float(47.88) ); periodicTable.put("V"  , new Float(50.94) ); periodicTable.put("Cr" , new Float(52.00) ); periodicTable.put("Mn" , new Float(54.94) ); periodicTable.put("Fe" , new Float(55.85) ); periodicTable.put("Co" , new Float(58.93) ); periodicTable.put("Ni" , new Float(58.69) ); periodicTable.put("Cu" , new Float(63.55) ); periodicTable.put("Zn" , new Float(65.39) ); periodicTable.put("Ga" , new Float(69.72) ); periodicTable.put("Ge" , new Float(72.59) ); periodicTable.put("As" , new Float(74.92) ); periodicTable.put("Se" , new Float(78.96) ); periodicTable.put("Br" , new Float(79.90) ); periodicTable.put("Kr" , new Float(83.80) );
        periodicTable.put("Rb" , new Float(85.47) ); periodicTable.put("Sr" , new Float(87.62) ); periodicTable.put("Y"  , new Float(88.91) ); periodicTable.put("Zr" , new Float(91.22) ); periodicTable.put("Nb" , new Float(92.91) ); periodicTable.put("Mo" , new Float(95.94) ); periodicTable.put("Tc" , new Float(97.91) ); periodicTable.put("Ru" , new Float(101.1) ); periodicTable.put("Rh" , new Float(102.9) ); periodicTable.put("Pd" , new Float(106.4) ); periodicTable.put("Ag" , new Float(107.9) ); periodicTable.put("Cd" , new Float(112.4) ); periodicTable.put("In" , new Float(114.8) ); periodicTable.put("Sn" , new Float(118.7) ); periodicTable.put("Sb" , new Float(121.8) ); periodicTable.put("Te" , new Float(127.6) ); periodicTable.put("I"  , new Float(126.7) ); periodicTable.put("Xe" , new Float(131.3) );
        periodicTable.put("Cs" , new Float(132.9) ); periodicTable.put("Ba" , new Float(137.3) ); periodicTable.put("Hf" , new Float(178.5) ); periodicTable.put("Ta" , new Float(180.9) ); periodicTable.put("W"  , new Float(183.9) ); periodicTable.put("Re" , new Float(186.2) ); periodicTable.put("Os" , new Float(190.2) ); periodicTable.put("Ir" , new Float(192.2) ); periodicTable.put("Pt" , new Float(195.1) ); periodicTable.put("Au" , new Float(197.0) ); periodicTable.put("Hg" , new Float(200.6) ); periodicTable.put("Tl" , new Float(204.4) ); periodicTable.put("Pb" , new Float(207.2) ); periodicTable.put("Bi" , new Float(209.0) ); periodicTable.put("Po" , new Float(209.0) ); periodicTable.put("At" , new Float(210.0) ); periodicTable.put("Rn" , new Float(222.0) );
        periodicTable.put("Fr" , new Float(223.0) ); periodicTable.put("Ra" , new Float(226.0) ); periodicTable.put("Rf" , new Float(265.1) ); periodicTable.put("Db" , new Float(268.1) ); periodicTable.put("Sg" , new Float(271.1) ); periodicTable.put("Bh" , new Float(270.1) ); periodicTable.put("Hs" , new Float(277.2) ); periodicTable.put("Mt" , new Float(276.2) ); periodicTable.put("Ds" , new Float(281.2) ); periodicTable.put("Rg" , new Float(280.2) ); periodicTable.put("Cn" , new Float(285.2) ); periodicTable.put("Uut", new Float(284.2) ); periodicTable.put("Fl" , new Float(289.2) ); periodicTable.put("Uup", new Float(288.2) ); periodicTable.put("Lv" , new Float(293.2) ); periodicTable.put("Uus", new Float(294.2) ); periodicTable.put("Uuo", new Float(294.2) );
        periodicTable.put("La" , new Float(138.9) ); periodicTable.put("Ce" , new Float(140.1) ); periodicTable.put("Pr" , new Float(140.9) ); periodicTable.put("Nd" , new Float(144.2) ); periodicTable.put("Pm" , new Float(144.9) ); periodicTable.put("Sm" , new Float(150.4) ); periodicTable.put("Eu" , new Float(152.0) ); periodicTable.put("Gd" , new Float(157.3) ); periodicTable.put("Tb" , new Float(158.9) ); periodicTable.put("Dy" , new Float(162.5) ); periodicTable.put("Ho" , new Float(164.9) ); periodicTable.put("Er" , new Float(167.3) ); periodicTable.put("Tm" , new Float(168.9) ); periodicTable.put("Lu" , new Float(175.0) );
        periodicTable.put("Ac" , new Float(227.0) ); periodicTable.put("Th" , new Float(232.0) ); periodicTable.put("Pa" , new Float(231.0) ); periodicTable.put("U"  , new Float(238.0) ); periodicTable.put("Np" , new Float(237.1) ); periodicTable.put("Pu" , new Float(244.1) ); periodicTable.put("Am" , new Float(243.1) ); periodicTable.put("Cm" , new Float(247.1) ); periodicTable.put("Bk" , new Float(247.1) ); periodicTable.put("Cf" , new Float(252.1) ); periodicTable.put("Es" , new Float(252.1) ); periodicTable.put("Md" , new Float(258.1) ); periodicTable.put("No" , new Float(259.1) ); periodicTable.put("Lr" , new Float(262.1) );

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        src.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent e) {
                if(e.getKeyCode() == e.KEYCODE_ENTER){
                    weightView.setText(MMCmain(src.getText().toString()));
                    numberView.setText(MMCintmain(src.getText().toString()));
                }
                return false;
            }
        });

        calculateBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                weightView.setText(MMCmain(src.getText().toString()));
                numberView.setText(MMCintmain(src.getText().toString()));
            }
        });
        /*
        //Reading source form local file
        InputStream inputStream = this.getResources().openRawResource(R.raw.periodic);
        String jsonString = readJsonFile(inputStream);

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> periodicTable = gson.fromJson(jsonString, type);
        weightView.setText("");

        for (Object key : periodicTable.keySet()) {
            weightView.append(key + " : " + periodicTable.get(key) + "\n");
        }*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://tw.delta4studio.www.molecomputer/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://tw.delta4studio.www.molecomputer/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
    //質量
    public float Counter(String args){
        float tmpWeight = 0.00f;    //as MMC tmp
        Pattern pattern = Pattern.compile("[A-Z][a-z]{0,2}\\d*");
        Matcher matcher = pattern.matcher(args);

        List<String> listMatches = new ArrayList<String>();

        while(matcher.find()){
            listMatches.add(matcher.group(0));
            Log.d("matcher", matcher.group(0));
        }
        for(String elementWithNumber: listMatches){
            String element = elementWithNumber.replaceAll("\\d*","");
            int total;
            try {
                total = Integer.parseInt(elementWithNumber.replaceAll("[A-Z][a-z]{0,2}",""));
            } catch(Exception e){
                total = 1;
            }
            try {
                tmpWeight += periodicTable.get(element) * total;
            } catch(Exception e){
                return -99999.9f;
            }
        }
        return tmpWeight;
    };
    public float LevelCount(List<String> args){
        float tmpWeight = 0.00f;
        for(String count: args){
            String countMatch = count.replaceAll("\\)\\d*", "");
            int numberCount;
            try{
                numberCount = Integer.parseInt(count.replaceAll("\\([\\w\\d^)]*\\)", ""));
            }catch (Exception e){
                numberCount = 1;
            }
            Log.d("NumberCount", String.valueOf(numberCount));
            tmpWeight += (Counter(countMatch) * numberCount);
        }
        return tmpWeight;
    }
    public String MMCmain(String args){
        float tmpWeight = 0.00f;
        Pattern pattern = Pattern.compile("(\\([\\w\\d^)]*\\)\\d)\\d*");
        Matcher matcher = pattern.matcher(args);

        List<String> listMatches = new ArrayList<String>();
        if(matcher.groupCount()>0){
            while(matcher.find()){
                listMatches.add(matcher.group(0));
            }
            tmpWeight += LevelCount(listMatches);
        }
        tmpWeight += Counter(args.replaceAll("(\\([\\w\\d^)]*\\)\\d)",""));

        return tmpWeight > 0.0f ? String.valueOf(tmpWeight) : "含有不存在元素";
    }
    //分子數
    public int intCounter(String args){
        int tmpNumber = 0;    //as MMC tmp
        Pattern pattern = Pattern.compile("[A-Z][a-z]{0,2}\\d*");
        Matcher matcher = pattern.matcher(args);

        List<String> listMatches = new ArrayList<String>();

        while(matcher.find()){
            listMatches.add(matcher.group(0));
        }
        for(String elementWithNumber: listMatches){
            int total;
            try{
                total = Integer.parseInt(elementWithNumber.replaceAll("[A-Z][a-z]{0,2}",""));
            }catch (Exception e){
                total = 1;
            }
            tmpNumber += total;

        }
        return tmpNumber;
    };
    public int intLevelCount(List<String> args){
        int tmpNumber = 0;
        for(String count: args){
            String countMatch = count.replaceAll("\\)\\d*", "");
            int numberCount;
            try{
                numberCount = Integer.parseInt(count.replaceAll("\\([\\w\\d^)]*\\)", ""));
            }catch (Exception e){
                numberCount = 1;
            }
            Log.d("NumberCount", String.valueOf(numberCount));
            tmpNumber += (intCounter(countMatch) * numberCount);
        }
        return tmpNumber;
    }
    public String MMCintmain(String args){
        int tmpNumber = 0;
        Pattern pattern = Pattern.compile("(\\([\\w\\d^)]*\\)\\d*)\\d*");
        Matcher matcher = pattern.matcher(args);

        List<String> listMatches = new ArrayList<String>();
        if(matcher.groupCount()>0){
            while(matcher.find()){
                listMatches.add(matcher.group(0));
            }
            tmpNumber += intLevelCount(listMatches);
        }
        tmpNumber += intCounter(args.replaceAll("(\\([\\w\\d^)]*\\)\\d*)", ""));

        return tmpNumber > 0 ? String.valueOf(tmpNumber) : "含有不存在元素";
    }
}

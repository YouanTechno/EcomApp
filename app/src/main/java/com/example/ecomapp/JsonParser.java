package com.example.ecomapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.ecomapp.models.Factures;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class JsonParser extends AsyncTask<String, String,Void> {
    @Override
    protected Void doInBackground(String... strings) {
        return null;
    }

//    public List<Factures> facturesdetails = new ArrayList<>();
//    BufferedInputStream inputStream;
//    JSONArray jsonArray;
//    String result="";
//    public ProgressDialog progressDialog;
//    Activity activity;
//    Context context;
//
//    public JsonParser(Activity activity, Context context) {
//        this.activity = activity;
//        this.context = context;
//        this.progressDialog = new ProgressDialog(this.context);
//    }
//
//    protected void onPreExecute(){
//        super.onPreExecute();
//        progressDialog.dismiss();
//        progressDialog.setMessage("Loading.....");
//        progressDialog.show();
//        progressDialog.setOnCancelListener((dialogInterface) -> {
//            JsonParser.this.cancel(true);
//        });
//    }
//
//    @Override
//    protected Void doInBackground(String... strings) {
//
//        HttpURLConnection httpURLConnection = null;
//        Log.d("Etat","test la connexion");
//        try{
//
//            URL url = new URL(Url.fetchdata);
//            httpURLConnection = (HttpURLConnection)url.openConnection();
//            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
//            result = readStream();
//            result = result.substring(result.indexOf("(")+1, result.lastIndexOf(")"));
//            Log.d("Etat","connexion ok ");
//        }
//        catch (IOException e) {
//            Log.d("Etat","connexion a echoué");
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    private String readStream() throws IOException{
//        Log.d("Etat","execute readStream");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder stringBuilder = new StringBuilder();
//        String line;
//        try{
//            while ((line=bufferedReader.readLine())!=null){
//                stringBuilder.append(line);
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return  stringBuilder.toString();
//
//    }
//    protected void onPostExecute(Void aVoid){
//        try{
//            jsonArray = new JSONArray(result);
//            if(jsonArray!=null){
//                for(int i=0; i<jsonArray.length();i++){
//                    Factures factures = new Factures();
//                    factures.FactCode = jsonArray.getJSONObject(i).getString("factCode");
//                    factures.FactLibelle = jsonArray.getJSONObject(i).getString("factLibelle");
//                    factures.FactTaxactId = jsonArray.getJSONObject(i).getInt("factTaxactId");
//                    factures.FactDateEcheance = jsonArray.getJSONObject(i).getString("factDateEcheance");
//                    factures.FactMontant = jsonArray.getJSONObject(i).getDouble("factMontant");
//
//                    facturesdetails.add(factures);
//                }
//           }
//            ListView listView;
//            listView = (ListView)this.activity.findViewById(R.id.listedata);
//            CustomAdapdter adapter = new CustomAdapdter(this.context,facturesdetails);
//            listView.setAdapter(adapter);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
}

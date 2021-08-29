package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.ecomapp.models.Factures;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Impayer extends AppCompatActivity {

    private final String url = "http://192.168.2.9/api/tresfactures";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private RecyclerView listData;
    private List<Factures> facturesdetails;

    private TextView textviewresult;

    Button payerbuton;
    private EditText mAmountView;
    CustomAdapdter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgence);

        textviewresult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Factures>> call = jsonPlaceHolderApi.getFactures();
        call.enqueue(new Callback<List<Factures>>() {
            @Override
            public void onResponse(Call<List<Factures>> call, retrofit2.Response<List<Factures>> response) {
                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                    return;
                }

                List<Factures> factures = response.body();
                for(Factures facturesData : factures){
                    String content = "";
                    content += "FactId : "+ facturesData.getFactId()+ "\n";
                    content += "FactCode : "+facturesData.getFactCode()+"\n";
                    content += "FactTaxactId : "+facturesData.getFactTaxactId()+"\n";
                    content += "FactContId : "+facturesData.getFactContId()+"\n";
                    content += "FactActId : "+facturesData.getFactActId()+"\n";
                    content += "FactCpteId : "+facturesData.getFactCpteId()+"\n";
                    content += "FactMontant : "+facturesData.getFactMontant()+"\n";
                    content += "FactPeriodeDebut: "+facturesData.getFactPeriodeDebut()+"\n";
                    content += "FactPeriodeFin: "+facturesData.getFactPeriodeFin()+"\n";
                    content += "FactDateEmission : "+facturesData.getFactDateEmission()+"\n";
                    content += "FactDateEcheance : "+facturesData.getFactDateEcheance()+"\n";
                    content += "FactBEtatReglement : "+facturesData.getFactBEtatReglement()+"\n";
                    content += "FactLibelle : "+facturesData.getFactLibelle()+"\n";
                    content += "FactBAbandon : "+facturesData.getFactBAbandon()+"\n";
                    content += "FactDateaBandon : "+facturesData.getFactDateaBandon()+"\n";
                    content += "FactAbandonAgId : "+facturesData.getFactAbandonAgId()+"\n";
                    content += "FactAbandonMotif : "+facturesData.getFactAbandonMotif()+"\n";

                    textviewresult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Factures>> call, Throwable t) {
                Toast.makeText(Impayer.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        payerbuton = (Button)findViewById(R.id.payerbuton);
        mAmountView = findViewById(R.id.mAmountView);

        ///facturesdetails = new ArrayList<>();
        //listData = findViewById(R.id.listData);

        //recuperation();

//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        listData.setLayoutManager(manager);
//        listData.setHasFixedSize(true);
//        //listData.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter = new CustomAdapdter(Impayer.this, facturesdetails);
//        listData.setAdapter(adapter);
//
//        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        //fetchFacture();

        payerbuton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String amount = mAmountView.getText().toString();

                if (amount.isEmpty()) {
                    Toast.makeText(Impayer.this, "Veuillez entrer un montant SVP",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String api_key = "990619935609be49436c092.25065470"; // TODO A remplacer par votre clé API
                    int site_id = 524568; // TODO A remplacer par votre Site ID
                    String notify_url = "";
                    String trans_id = String.valueOf(new Date().getTime());
                    String currency = "XOF";
                    String designation = "Achat test";
                    String custom = "";

                    Intent payer = new Intent(Impayer.this, MyCinetPayActivity.class);

                    payer.putExtra(CinetPayActivity.KEY_API_KEY, api_key);
                    payer.putExtra(CinetPayActivity.KEY_SITE_ID, site_id);
                    payer.putExtra(CinetPayActivity.KEY_NOTIFY_URL, notify_url);
                    payer.putExtra(CinetPayActivity.KEY_TRANS_ID, trans_id);
                    payer.putExtra(CinetPayActivity.KEY_AMOUNT, Integer.valueOf(amount));
                    payer.putExtra(CinetPayActivity.KEY_CURRENCY, currency);
                    payer.putExtra(CinetPayActivity.KEY_DESIGNATION, designation);
                    payer.putExtra(CinetPayActivity.KEY_CUSTOM, custom);

                    startActivity(payer);
                }
            }
        });
    }
//
//    private void recuperation() {
//        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                JSONObject jsonObject = null;
//                for (int i=0; i < response.length(); i++){
//                    try{
//                        jsonObject = response.getJSONObject(i);
//                        Factures factures = new Factures();
//
//                        factures.setFactCode(jsonObject.getString("factCode"));
//                        factures.setFactLibelle(jsonObject.getString("factLibelle"));
//                        factures.setFactTaxactId(jsonObject.getInt("factTaxactId"));
//                        factures.setFactDateEcheance(jsonObject.getString("factDateEcheance"));
//                        factures.setFactMontant((float) jsonObject.getDouble("factMontant"));
//                        factures.setFactId(jsonObject.getInt("factId")) ;
//                        factures.setFactContId(jsonObject.getInt("factContId"));
//                        factures.setFactActId(jsonObject.getInt("factActId")) ;
//                        factures.setFactCpteId(jsonObject.getInt("factCpteId"));
//                        factures.setFactPeriodeDebut(jsonObject.getString("factPeriodeDebut"));
//                        factures.setFactDateEmission(jsonObject.getString("factDateEmission")) ;
//                        factures.setFactBEtatReglement(jsonObject.getBoolean("factBEtatReglement"));
//                        factures.setFactBAbandon(jsonObject.getBoolean("factBAbandon"));
//                        factures.setFactDateaBandon(jsonObject.getString("factDateaBandon"));
//                        factures.setFactAbandonAgId(jsonObject.getInt("factAbandonAgId"));
//                        factures.setFactAbandonMotif(jsonObject.getString("factAbandonMotif"));
//                        factures.setFactPotentiel(jsonObject.getInt("factPotentiel"));
//
//                        facturesdetails.add(factures);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                setuprecylerview(facturesdetails);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(Impayer.this, error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//        requestQueue = Volley.newRequestQueue(Impayer.this);
//        requestQueue.add(request);
//    }
//
//    private void setuprecylerview(List<Factures> facturesdetails) {
//
//        CustomAdapdter myAdapdter =  new CustomAdapdter(this, facturesdetails);
//        listData.setLayoutManager(new LinearLayoutManager(this));
//        listData.setAdapter(myAdapdter);
//    }
//
//    private void fetchFacture() {
//        //String url = "http://192.168.1.165/api/tresfactures";
//        //String url = "http://192.168.2.9/api/tresfactures";
//        ///12075566
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//
//                        JSONObject jsonObject = response.getJSONObject(i);
//
//                        Factures factures = new Factures();
//
//                        factures.FactCode = jsonObject.getString("factCode");
//                        factures.FactLibelle = jsonObject.getString("factLibelle");
//                        factures.FactTaxactId = jsonObject.getInt("factTaxactId");
//                        factures.FactDateEcheance = jsonObject.getString("factDateEcheance");
//                        factures.FactMontant = jsonObject.getDouble("factMontant");
//                        factures.FactId = jsonObject.getInt("factId") ;
//                        factures.FactContId = jsonObject.getInt("factContId");
//                        factures.FactActId = jsonObject.getInt("factActId") ;
//                        factures.FactCpteId = jsonObject.getInt("factCpteId");
//                        factures.FactPeriodeDebut = jsonObject.getString("factPeriodeDebut");
//                        factures.FactDateEmission = jsonObject.getString("factDateEmission") ;
//                        factures.FactBEtatReglement = jsonObject.getBoolean("factBEtatReglement");
//                        factures.FactBAbandon = jsonObject.getBoolean("factBAbandon");
//                        factures.FactDateaBandon = jsonObject.getString("factDateaBandon");
//                        factures.FactAbandonAgId = jsonObject.getInt("factAbandonAgId");
//                        factures.FactAbandonMotif = jsonObject.getString("factAbandonMotif");
//                        factures.FactPotentiel = jsonObject.getInt("factPotentiel");
//
//                        facturesdetails.add(factures);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    adapter = new CustomAdapdter(Impayer.this, facturesdetails);
//                    listData.setAdapter(adapter);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(Impayer.this, (CharSequence) error.getCause(), Toast.LENGTH_LONG).show();
//               // Log.e("Volley", error.getMessage());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }
}
//}
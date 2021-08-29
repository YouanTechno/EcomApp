package com.example.ecomapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomapp.models.Factures;

import java.util.List;

public class CustomAdapdter extends RecyclerView.Adapter<CustomAdapdter.FactureHolder> {
    private List<Factures> facturesList;
    private Context context;


    public CustomAdapdter(Context context, List<Factures> facturesList) {

        this.context=context;
        this.facturesList = facturesList;

    }


    @Override
    public FactureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////      final LinearLayout layout = (LinearLayout) parent.findViewById(R.id.listData);
//        View view = mInflater.inflate(R.layout.list_design, parent, false);
//        return new FactureHolder(view);
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.listefacture, parent,false);
        return new FactureHolder(view);

    }

    @Override
    public void onBindViewHolder(FactureHolder holder, int position) {
        Factures factures =facturesList.get(position);
        holder.codefacture.setText(factures.getFactCode());
        holder.libellefacture.setText(factures.getFactLibelle());
        holder.taxeid.setText(factures.getFactTaxactId());
        holder.datefacture.setText(factures.getFactDateEcheance());
        holder.montantfacture.setText((int) factures.getFactMontant());

    }

    @Override
    public int getItemCount() {
        return facturesList.size();
    }

    public static class FactureHolder extends RecyclerView.ViewHolder{
        TextView codefacture;
        TextView libellefacture ;
        TextView taxeid;
        TextView datefacture;
        TextView montantfacture;

        public FactureHolder(View itemView) {
            super(itemView);
             codefacture = itemView.findViewById(R.id.list_codefacture);
             libellefacture = itemView.findViewById(R.id.list_libellefacture);
             taxeid = itemView.findViewById(R.id.list_taxeid);
             datefacture = itemView.findViewById(R.id.list_datefacture);
             montantfacture = itemView.findViewById(R.id.list_montantfacture);
        }
    }

}

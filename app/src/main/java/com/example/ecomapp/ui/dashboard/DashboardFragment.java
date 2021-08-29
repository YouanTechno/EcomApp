package com.example.ecomapp.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecomapp.Factpayer;
import com.example.ecomapp.Impayer;
import com.example.ecomapp.User;
import com.example.ecomapp.databinding.FragmentDashboardBinding;
import com.example.ecomapp.facturations;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textDashboard;
        /*dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });*/
        binding.activite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facture = new Intent(getActivity(), facturations.class);
                startActivity(facture);

            }
        });
        binding.compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compte = new Intent(getActivity(), User.class);
                startActivity(compte);
            }
        });

        binding.factureimpaye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urgences = new Intent(getActivity(), Impayer.class);
                startActivity(urgences);
            }
        });

        binding.facturepaye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urgences = new Intent(getActivity(), Factpayer.class);
                startActivity(urgences);
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
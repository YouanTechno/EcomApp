package com.example.ecomapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ecomapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        binding.bouakepresente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.descript.setVisibility(View.VISIBLE);
                binding.descriptcntig.setVisibility(View.GONE);
            }
        });
        binding.presentecntig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    binding.descriptcntig.setVisibility(View.VISIBLE);
                    binding.descript.setVisibility(View.GONE);
            }
        });
        binding.savoirplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cntig = new Intent(Intent.ACTION_VIEW);
                cntig.setData(Uri.parse("http://cntig.net/index.php/a-propos/offre-d-emploi"));
                startActivity(cntig);
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
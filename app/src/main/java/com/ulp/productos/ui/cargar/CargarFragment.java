package com.ulp.productos.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.productos.R;
import com.ulp.productos.databinding.FragmentCargarBinding;
import com.ulp.productos.model.Producto;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMensaje.setText(s);
            }
        });

        mViewModel.getCodigo().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etCodigo.setText(s);
            }
        });

        mViewModel.getDescripcion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etDescripcion.setText(s);
            }
        });

        mViewModel.getPrecio().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etPrecio.setText(s);
            }
        });

        mViewModel.getStock().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.etStock.setText(s);
            }
        });

        binding.btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.validarProducto(
                        binding.etCodigo.getText().toString(),
                        binding.etDescripcion.getText().toString(),
                        binding.etPrecio.getText().toString(),
                        binding.etStock.getText().toString()
                );
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

}
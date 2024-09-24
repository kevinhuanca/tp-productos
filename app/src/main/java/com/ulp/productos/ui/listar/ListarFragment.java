package com.ulp.productos.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulp.productos.R;
import com.ulp.productos.databinding.FragmentListarBinding;
import com.ulp.productos.model.Producto;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;

    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding =FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel.getProductos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Producto>>() {
            @Override
            public void onChanged(ArrayList<Producto> productos) {
                ProductoAdapter adaptador = new ProductoAdapter(productos, inflater);
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.rvLista.setAdapter(adaptador);
                binding.rvLista.setLayoutManager(glm);
            }
        });
        mViewModel.cargarProductos();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }

}
package com.ulp.productos.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ulp.productos.MainActivity;
import com.ulp.productos.model.Producto;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Producto>> productos;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Producto>> getProductos() {
        if (productos == null) {
            productos = new MutableLiveData<>();
        }
        return productos;
    }

    public void cargarProductos() {
        Collections.sort(MainActivity.productos, (p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()));
        productos.setValue(MainActivity.productos);
    }

}
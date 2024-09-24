package com.ulp.productos.ui.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.productos.MainActivity;
import com.ulp.productos.model.Producto;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mensaje;
    private MutableLiveData<String> mCodigo;
    private MutableLiveData<String> mDescripcion;
    private MutableLiveData<String> mPrecio;
    private MutableLiveData<String> mStock;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensaje() {
        if (mensaje == null) {
            mensaje = new MutableLiveData<>();
        }
        return mensaje;
    }

    public LiveData<String> getCodigo() {
        if (mCodigo == null) {
            mCodigo = new MutableLiveData<>();
        }
        return mCodigo;
    }

    public LiveData<String> getDescripcion() {
        if (mDescripcion == null) {
            mDescripcion = new MutableLiveData<>();
        }
        return mDescripcion;
    }

    public LiveData<String> getPrecio() {
        if (mPrecio == null) {
            mPrecio = new MutableLiveData<>();
        }
        return mPrecio;
    }

    public LiveData<String> getStock() {
        if (mStock == null) {
            mStock = new MutableLiveData<>();
        }
        return mStock;
    }

    public void validarProducto(String codigo, String descripcion, String precio, String stock) {
        if (codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            mensaje.setValue("¡Hay campos vacios!");
            return;
        }
        int code = Integer.parseInt(codigo);
        for (Producto producto : MainActivity.productos) {
            if (code == producto.getCodigo()) {
                mensaje.setValue("Ya existe un producto con ese codigo.");
                return;
            }
        }
        MainActivity.productos.add(new Producto(
                code,
                descripcion,
                Double.parseDouble(precio),
                Integer.parseInt(stock)
        ));
        Toast.makeText(getApplication(), "¡Producto agregado!", Toast.LENGTH_LONG).show();
        mensaje.setValue("");
        mCodigo.setValue("");
        mDescripcion.setValue("");
        mPrecio.setValue("");
        mStock.setValue("");
    }

}
package com.example.tpo3_productos.ui.detalleProducto;

import static com.example.tpo3_productos.MainActivity.listaProductos;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpo3_productos.modelo.Producto;

public class DetalleProductoViewModel extends AndroidViewModel {

    private MutableLiveData<Producto> mProductoEncontrado;

    public DetalleProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Producto> getProductoEncontrado() {
        if (mProductoEncontrado == null) {
            mProductoEncontrado = new MutableLiveData<>();
        }
        return mProductoEncontrado;
    }

    public void eliminarProducto() {
        Producto producto = mProductoEncontrado.getValue();
        if (producto != null) {
            if (listaProductos.remove(producto)) {
                Toast.makeText(getApplication(), "Producto eliminado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplication(), "No se pudo eliminar", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void setProductoEncontrado(Bundle bundle) {
        if (bundle != null) {
            Producto producto = (Producto) bundle.getSerializable("producto");
            mProductoEncontrado.setValue(producto);
        }

    }


}
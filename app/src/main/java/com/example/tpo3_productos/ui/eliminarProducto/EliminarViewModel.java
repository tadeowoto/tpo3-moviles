package com.example.tpo3_productos.ui.eliminarProducto;

import static com.example.tpo3_productos.MainActivity.listaProductos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpo3_productos.modelo.Producto;

public class EliminarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mErrorBuscar;
    private MutableLiveData<Producto> mProductoBuscado;


    public EliminarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getErrorBuscar() {
        if (mErrorBuscar == null) {
            mErrorBuscar = new MutableLiveData<>();
        }
        return mErrorBuscar;
    }

    public LiveData<Producto> getProductoBuscado() {
        if (mProductoBuscado == null) {
            mProductoBuscado = new MutableLiveData<>();
        }
        return mProductoBuscado;
    }

    public void buscarProducto(String codigo){
        boolean estaCodigo = false;

        if (codigo.isEmpty()){
            mErrorBuscar.setValue("Debe ingresar un código");
            return;
        }

        for(Producto p : listaProductos){
            if(p.getCodigo().equals(codigo)){
                estaCodigo = true;
                mProductoBuscado.setValue(p);
            }
        }
        if(!estaCodigo){
            mErrorBuscar.setValue("No se encontro el producto");
        }
    }

}
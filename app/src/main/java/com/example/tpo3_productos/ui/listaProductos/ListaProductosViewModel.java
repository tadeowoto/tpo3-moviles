package com.example.tpo3_productos.ui.listaProductos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tpo3_productos.MainActivity;
import com.example.tpo3_productos.modelo.Producto;

import java.util.ArrayList;

public class ListaProductosViewModel extends AndroidViewModel {

    public MutableLiveData<ArrayList<Producto>> productos;
    public MutableLiveData<String> noHayProductos;

    public ListaProductosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Producto>> getProductos(){
        if(productos == null){
            productos = new MutableLiveData<>();
        }
        return productos;
    }

    public LiveData<String> getNoHayProductos(){
        if(noHayProductos == null){
            noHayProductos = new MutableLiveData<>();
        }
        return noHayProductos;
    }
    ArrayList<Producto> lista = new ArrayList<>(MainActivity.listaProductos);





    public void cargarProductos() {
        if(lista.isEmpty()){
            // Podria cargar un Skeleton o algo asi
            noHayProductos.setValue("No hay productos");
        } else {
            ArrayList<Producto> lista = new ArrayList<>(MainActivity.listaProductos);
            productos.setValue(lista);
        }
    }

}
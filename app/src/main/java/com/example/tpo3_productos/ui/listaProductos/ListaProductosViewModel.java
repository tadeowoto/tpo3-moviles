package com.example.tpo3_productos.ui.listaProductos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpo3_productos.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ListaProductosViewModel extends AndroidViewModel {

    public MutableLiveData<List<Producto>> productos;

    public ListaProductosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Producto>> getProductos(){
        if(productos == null){
            productos = new MutableLiveData<>();
        }
        return productos;
    }

    public void cargarProductos(){
        ArrayList<Producto> lista = new ArrayList<>();
        lista.add(new Producto("PRD001", "Iphone 17", 100));
        lista.add(new Producto("PRD002", "MacBook Pro", 500));
        lista.add(new Producto("PRD003", "Ipad", 300));
        lista.add(new Producto("PRD004", "Galaxy Tab", 200));
        productos.setValue(lista);
    }

}
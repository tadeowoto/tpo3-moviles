package com.example.tpo3_productos.ui.detalleProducto;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpo3_productos.R;
import com.example.tpo3_productos.databinding.FragmentDetalleProductoBinding;

public class DetalleProductoFragment extends Fragment {

    private DetalleProductoViewModel vm;
    private FragmentDetalleProductoBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleProductoViewModel.class);
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getProductoEncontrado().observe(getViewLifecycleOwner(), producto -> {
            binding.tvCodigoDetalle.setText("Código: " + producto.getCodigo());
            binding.tvDescripcionDetalle.setText("Descripción: " + producto.getDescripcion());
            binding.tvPrecioDetalle.setText("Precio: " + producto.getPrecio());
        });

        vm.setProductoEncontrado(getArguments());

        binding.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.eliminarProducto();
                getActivity().onBackPressed();
            }
        });

        return root;

    }



}
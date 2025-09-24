package com.example.tpo3_productos.ui.agregarProductos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tpo3_productos.databinding.FragmentAgregarProductosBinding;

public class AgregarProductoFragment extends Fragment {


    private FragmentAgregarProductosBinding binding;
    private AgregarProductosViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(AgregarProductosViewModel.class);
        binding = FragmentAgregarProductosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String codigo = binding.inputCodigo.getText().toString().trim();
                String descripcion = binding.inputDescripcion.getText().toString().trim();
                String precioTexto = binding.inputPrecio.getText().toString().trim();

                float precio = 0f;
                try {
                    if (!precioTexto.isEmpty()) {
                        precio = Float.parseFloat(precioTexto);
                    }
                } catch (NumberFormatException e) {
                    binding.tvErrorPrecio.setText("Formato de precio inválido");
                    binding.tvErrorPrecio.setVisibility(View.VISIBLE);
                    return;
                }

                vm.validateForm(codigo, descripcion, precio);
            }
        });

        vm.getErrorCodigo().observe(getViewLifecycleOwner(), error -> {
            binding.tvErrorCodigo.setText(error);
            binding.tvErrorCodigo.setVisibility(View.VISIBLE);
        });

        vm.getErrorDescripcion().observe(getViewLifecycleOwner(), error -> {
            binding.tvErrorDescripcion.setText(error);
            binding.tvErrorDescripcion.setVisibility(View.VISIBLE);
        });

        vm.getErrorPrecio().observe(getViewLifecycleOwner(), error -> {
            binding.tvErrorPrecio.setText(error);
            binding.tvErrorPrecio.setVisibility(View.VISIBLE);
        });

        vm.getExito().observe(getViewLifecycleOwner(), exito -> {
            if (exito != null && !exito.isEmpty()) {
                binding.tvExito.setText(exito);
                binding.cardExito.setVisibility(View.VISIBLE);
                limpiarCampos();
                binding.getRoot().postDelayed(() -> {
                    if (binding != null) {
                        binding.cardExito.setVisibility(View.GONE);
                    }
                }, 3000);
            }
        });

        return root;
    }

    private void limpiarCampos(){
        binding.inputCodigo.setText("");
        binding.inputDescripcion.setText("");
        binding.inputPrecio.setText("");

    }

}
package com.example.tpo3_productos.ui.eliminarProducto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tpo3_productos.R;
import com.example.tpo3_productos.databinding.FragmentEliminarBinding;
import com.example.tpo3_productos.databinding.FragmentListaProductosBinding;

public class EliminarFragment extends Fragment {

    private EliminarViewModel vm;
    private FragmentEliminarBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentEliminarBinding.inflate(inflater, container, false);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(EliminarViewModel.class);
        View root = binding.getRoot();

        binding.btBuscarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = binding.etProductoABuscar.getText().toString();
                vm.buscarProducto(codigo);
            }
        });

        vm.getErrorBuscar().observe(getViewLifecycleOwner(), error -> {
            binding.tvErrorBuscar.setText(error);
            binding.tvErrorBuscar.setVisibility(View.VISIBLE);
        });

        vm.getProductoBuscado().observe(getViewLifecycleOwner(), producto -> {
            binding.tvErrorBuscar.setVisibility(View.GONE);
            Bundle bundle = new Bundle();
            bundle.putSerializable("producto", producto);
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_eliminarFragment_to_detalleProductoFragment, bundle);
        });


        return root;
    }


}
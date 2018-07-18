package cl.msec.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import javax.security.auth.callback.Callback;


public class FoodFragment extends Fragment {



    public FoodFragment() {
        // Required empty public constructor
    }
    public static  FoodFragment newInstance(){
        return new FoodFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override //ENCONTRAR VISTAS
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioGroup radioGroupEntrance =view.findViewById(R.id.OpcionOne);
        Button button = view.findViewById(R.id.FoodBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioGroupEntrance.getCheckedRadioButtonId();

                if (id != -1){
                    RadioButton radioButton = radioGroupEntrance.findViewById(id);
                    String answer = radioButton.getText().toString();
                    //Toast.makeText(getContext(),answer,Toast.LENGTH_SHORT).show();
                    showdialog(answer);
                } else {
                    Toast.makeText(getContext(),"Debes marcar una opción",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void showdialog(String answer){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Precio del producto");
        alertDialog.setMessage(new FoodResult(answer).score());
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
    });
        alertDialog.show();
    }
}

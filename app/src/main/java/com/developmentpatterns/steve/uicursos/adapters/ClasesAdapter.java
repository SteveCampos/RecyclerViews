package com.developmentpatterns.steve.uicursos.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.developmentpatterns.steve.uicursos.MainActivity;
import com.developmentpatterns.steve.uicursos.R;
import com.developmentpatterns.steve.uicursos.entidades.Clase;

import java.util.List;


/**
 * Created by Steve on 16/05/2016.
 */
public class ClasesAdapter extends
        RecyclerView.Adapter<ClasesAdapter.ViewHolder>{

    private List<Clase> listClases;

    public ClasesAdapter(List<Clase> listClases) {
        this.listClases = listClases;
    }

    @Override
    public ClasesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflate the custom layout
        // Return a new holder instance
        return new ViewHolder(inflater.inflate(R.layout.item_horas, parent, false));
    }

    @Override
    public void onBindViewHolder(ClasesAdapter.ViewHolder holder, int position) {

        Clase clase = listClases.get(position);

        TextView textViewClassName = holder.textViewClassName;
        TextView textViewHora = holder.textViewHora;
        RelativeLayout relativeLayout = holder.relativeLayout;

        textViewClassName.setText(clase.getClaseName());
        textViewHora.setText(clase.getHora().toUpperCase());

        int positionToColor = position % 3 ;
        String hexColor = "#ffd6d7d7";

        Log.d(MainActivity.TAG, "POSITION : " + position);
        Log.d(MainActivity.TAG, "RESTO : " + positionToColor);
        switch (positionToColor){
            case 0:
                hexColor = "#0F000000";
                break;
            case 1:
                hexColor = "#ffffff";
                break;
            case 2:
                hexColor = "#0A000000";
                break;
        }
        relativeLayout.setBackgroundColor(Color.parseColor(hexColor));


    }


    @Override
    public int getItemCount() {
        return listClases.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView textViewClassName;
        public TextView textViewHora;
        public RelativeLayout relativeLayout;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            textViewClassName = (TextView) itemView.findViewById(R.id.textViewClassName);
            textViewHora = (TextView) itemView.findViewById(R.id.textViewHora);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.layoutBackground);
        }
    }
}

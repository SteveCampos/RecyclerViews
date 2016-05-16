package com.developmentpatterns.steve.uicursos.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.developmentpatterns.steve.uicursos.MainActivity;
import com.developmentpatterns.steve.uicursos.R;
import com.developmentpatterns.steve.uicursos.entidades.Cursos;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Steve on 16/05/2016.
 */
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class CursosAdapter extends
        RecyclerView.Adapter<CursosAdapter.ViewHolder>{

    // Store a member variable for the Cursos
    private List<Cursos> listCursos;
    private Context context;

    public CursosAdapter(List<Cursos> listCursos, Context context) {
        this.listCursos = listCursos;
        this.context = context;
    }

    @Override
    public CursosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_cursos, parent, false);
        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(CursosAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Cursos curso = listCursos.get(position);


        // Set item views based on the data model
        TextView textViewCursoName = holder.textViewCursoName;
        RelativeLayout relativeLayoutBackground = holder.layoutBackround;
        ImageView imageViewCurso = holder.imageView;
        RecyclerView recyclerViewHorario = holder.recyclerViewClases;



        textViewCursoName.setText(curso.getCurseName());
        relativeLayoutBackground.setBackgroundColor(Color.parseColor(curso.getHexadecimalColor()));
        int positionToImage = position % 3 ;
        Log.d(MainActivity.TAG, "POSITION : " + position);
        Log.d(MainActivity.TAG, "RESTO : " + positionToImage);

        int idDrawable = R.drawable.ic_android_black_48dp__op60;
        switch (positionToImage){
            case 0:
                idDrawable = R.drawable.ic_android_black_48dp__op60;
                break;
            case 1:
                idDrawable = R.drawable.ic_cloud_circle_black_48dp_80op;
                break;
            case 2:
                idDrawable = R.drawable.ic_whatshot_black_48dp_60op;
                break;
        }
        imageViewCurso.setImageDrawable(ContextCompat.getDrawable(context, idDrawable));


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewHorario.setLayoutManager(layoutManager);

        ClasesAdapter adapterClass = new ClasesAdapter(curso.getListClase());
        recyclerViewHorario.setAdapter(adapterClass);

    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return listCursos.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public RelativeLayout layoutBackround;
        public ImageView imageView;
        public TextView textViewCursoName;
        public RecyclerView recyclerViewClases;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            layoutBackround = (RelativeLayout) itemView.findViewById(R.id.layoutCabecera);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewCursoName = (TextView) itemView.findViewById(R.id.cursoName);
            recyclerViewClases = (RecyclerView) itemView.findViewById(R.id.rvHorario);
        }
    }
}

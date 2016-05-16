package com.developmentpatterns.steve.uicursos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.developmentpatterns.steve.uicursos.adapters.CursosAdapter;
import com.developmentpatterns.steve.uicursos.entidades.Clase;
import com.developmentpatterns.steve.uicursos.entidades.Cursos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "io_steve_ui";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setRecyclerView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCursos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CursosAdapter cursosAdapter = new CursosAdapter(generateListCursos(), this);
        recyclerView.setAdapter(cursosAdapter);
    }

    public List<Cursos> generateListCursos(){


        ArrayList<Cursos> listCursos = new ArrayList<>();

        ArrayList<Clase> listClase = new ArrayList<>();
        listClase.add(new Clase("What's new in Android", "MIÉ 01 PM"));
        listClase.add(new Clase("Image compression for Android developers", "MIÉ 02 PM"));
        listClase.add(new Clase("Android Auto for everyone","MIÉ 06 PM"));
        listClase.add(new Clase("Android themes &  styles demystified","JUE 09 AM"));
        listClase.add(new Clase("What's new in Android development tools"," JUE 10 AM"));
        listClase.add(new Clase("Android application architecture: Get ready for the next billion!","VIE 09 AM"));
        listClase.add(new Clase("A window into transitions","VIE 03 PM"));


        listCursos.add(new Cursos("Android", "#66bb6a", "url", listClase));

        ArrayList<Clase> listClaseFirebase = new ArrayList<>();
        listClaseFirebase.add(new Clase("Migrate to Firebase", "MIÉ 03 PM"));
        listClaseFirebase.add(new Clase("The key to Firebase security", "JUE 09 AM"));
        listClaseFirebase.add(new Clase("Cross-Platform coding without a net","JUE 11 AM"));
        listClaseFirebase.add(new Clase("Deep Dive into the Realtime Database","JUE 11 AM"));
        listClaseFirebase.add(new Clase("Zero to App: Develop with Firebase","VIE 10 AM"));



        listCursos.add(new Cursos("Firebase", "#ffee58", "url", listClaseFirebase));

        ArrayList<Clase> listClasePlay = new ArrayList<>();
        listClasePlay.add(new Clase("Google Play Awards", "JUE 07 PM"));

        listCursos.add(new Cursos("Play", "#ab47bc", "url", listClasePlay));
        return listCursos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

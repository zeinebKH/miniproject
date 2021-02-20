package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText TxtDepart, TxtArrivee, TxtPrix, TxtDuree;
    Button btnAjouter, btnModif ,btnRecherche;
    ListView listTable;
    MySqliteOpenHelper mySqliteOpenHelper;
    ArrayAdapter CircuitArray;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TxtDepart = (EditText) findViewById(R.id.TxtDepart);
        TxtArrivee = (EditText) findViewById(R.id.TxtArrivee);
        TxtPrix = (EditText) findViewById(R.id.TxtPrix);
        TxtDuree = (EditText) findViewById(R.id.TxtDuree);


        btnAjouter = (Button) findViewById(R.id.btnAjouter);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Circuit circuit ;
                try {
                    circuit = new Circuit(-1,TxtDepart.getText().toString() ,TxtArrivee.getText().toString() ,
                            Integer.parseInt(TxtPrix.getText().toString()) ,Integer.parseInt(TxtDuree.getText().toString()));
                    Toast.makeText(MainActivity.this, circuit.toString(),Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this," Erreur de la creation de Circuit verifier vos données ",Toast.LENGTH_SHORT).show();
                    circuit = new Circuit(-1,"Tunis","Tunis", (float) 0.0,0);

                }

                MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(MainActivity.this);
                boolean success = mySqliteOpenHelper.Ajouter(circuit);
                Toast.makeText(MainActivity.this," Success =  "+ success,Toast.LENGTH_SHORT).show();
                CircuitArray = new ArrayAdapter<Circuit>(MainActivity.this, android.R.layout.simple_list_item_1, mySqliteOpenHelper.affichageDB());
                listTable.setAdapter(CircuitArray);
            }
        });

        btnModif = (Button) findViewById(R.id.btnModif);
        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        listTable =(ListView) findViewById(R.id.listTable);
        listTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Circuit clickCircuit = (Circuit) parent.getItemAtPosition(position);
                mySqliteOpenHelper.supprimer(clickCircuit);
                CircuitArray = new ArrayAdapter<Circuit>(MainActivity.this, android.R.layout.simple_list_item_1, mySqliteOpenHelper.affichageDB());
                listTable.setAdapter(CircuitArray);
                Toast.makeText(MainActivity.this,"le Circuit est Supprimer" + clickCircuit.toString(),Toast.LENGTH_SHORT).show();

            }
        });



        btnRecherche =(Button) findViewById(R.id.btnRecheche);
        btnRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent =new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(startIntent);
            }
        });
    }

//    private void showDB(MySqliteOpenHelper mySqliteOpenHelper) {
//        CircuitArray = new ArrayAdapter<Circuit>(MainActivity.this, android.R.layout.simple_list_item_1, mySqliteOpenHelper.affichageDB());
//        listTable.setAdapter(CircuitArray);
//    }


}

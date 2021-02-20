package com.example.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    public static final String CIRCUIT_TABLE1 = "CIRCUIT_TABLE";
    public static final String ID_CIRCUIT = "IdCircuit";
    public static final String VILLE_DEPART = "VilleDepart";
    public static final String VILLE_ARRIVEE = "VilleArrivee";
    public static final String PRIX = "Prix";
    public static final String DUREE = "Duree";



    public MySqliteOpenHelper(@Nullable Context context) {
        super(context,"circuit", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement = "CREATE TABLE  " + CIRCUIT_TABLE1 + " (" + ID_CIRCUIT + " Integer PRIMARY KEY AUTOINCREMENT," +
            VILLE_DEPART + " TEXT, " + VILLE_ARRIVEE + " TEXT , " + PRIX + " DOUBLE, " + DUREE + " Integer ) ";
    db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE "+ CIRCUIT_TABLE1);
        onCreate(db);

    }


    public boolean Ajouter(Circuit circuit){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(VILLE_DEPART, circuit.getVilleDepart());
        contentValues.put(VILLE_ARRIVEE, circuit.getVilleArrivee());
        contentValues.put(PRIX, circuit.getPrix());
        contentValues.put(DUREE, circuit.getDuree());

        long insert = db.insert(CIRCUIT_TABLE1, null, contentValues);
        if (insert == -1){
            return false;
        } else {return true;}
    }

    public boolean Modifier(Circuit circuit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID_CIRCUIT, circuit.getIdCircuit());
        contentValues.put(VILLE_DEPART, circuit.getVilleDepart());
        contentValues.put(VILLE_ARRIVEE, circuit.getVilleArrivee());
        contentValues.put(PRIX, circuit.getPrix());
        contentValues.put(DUREE, circuit.getDuree());

        db.update(CIRCUIT_TABLE1,contentValues," id = ? ",new String[]{ID_CIRCUIT});
        return true;

    }

    public boolean supprimer(Circuit circuit){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM "+ CIRCUIT_TABLE1 + " WHERE " + ID_CIRCUIT + " = " + circuit.getIdCircuit();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;}
    }

    public List<Circuit> affichageDB(){
        List<Circuit> returnList = new ArrayList<>();
        String queryString = " SELECT * FROM " + CIRCUIT_TABLE1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do {
                int circuitID = cursor.getInt(0);
                String departVille = cursor.getString(1);
                String arriveVille = cursor.getString(2);
                float prix = cursor.getFloat(3);
                int dure = cursor.getInt(4);

                Circuit newCircuit = new Circuit(circuitID,departVille,arriveVille,prix,dure);
                returnList.add(newCircuit);

            } while (cursor.moveToNext());
        }else {

        }
        cursor.close();
        db.close();
        return  returnList;
    }


}

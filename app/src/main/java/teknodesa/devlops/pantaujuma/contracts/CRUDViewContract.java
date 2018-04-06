package onanteam.devlops.onan.ui.base;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import android.content.Context;

import com.google.firebase.database.DatabaseReference;

/**
 *
 * @author Roy Deddy Tobing
 */
public class CRUDContract {

    public interface View {

        void showNotification(String title, String header, String message); //dipanggil terjadi add, delete dan update
    }

    public interface Controller<U> {

        void addItem(Context context, U item, DatabaseReference mRef); //dipanggil oleh event input control, mis. onClick

        void updateItem(Context context, U item, String dbURI, DatabaseReference mRef); //dipanggil oleh event input control, mis. onClick

        void deleteItem(Context context, U item, String dbURI, DatabaseReference mRef); //dipanggil oleh event input control, mis. onClick

        void responseCRUD(boolean status); //dipanggil setelah data sudah diterima dari  Repository
    }

    public interface Repository<U> {
        void addItem(Context context, U item, DatabaseReference mRef);
        void updateItem(Context context, U item, String dbURI, DatabaseReference mRef);
        void deleteItem(Context context, U item, String dbURI, DatabaseReference mRef);
    }
}

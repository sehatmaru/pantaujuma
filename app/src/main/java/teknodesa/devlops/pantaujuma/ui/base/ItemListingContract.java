
package onanteam.devlops.onan.ui.base;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import android.content.Context;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

/**
 *
 * @author Roy Deddy Tobing
 */
public class ItemListingContract {
    public interface View<U> {
        void refresh();
        
        void setListItem(List<U> items);
        void setSingleItem(U item, String jenis);
    }

    public interface Controller<U> {
        //return list of items
        void getAllItem(final Context context, DatabaseReference mRef);
        void listenAllItem(final Context context, DatabaseReference mRef);
        void getItemByCondition(U searchedItem);
        void responseGetAllItem(Context context, List<U> hasil);
        
        //return only one item
        void getItemById(final Context context, DatabaseReference mRef, String searchedId);
        void responseGetSingleItem(Context context, U hasil);
        
    }

    public interface Repository<U> {
        //return list of items
        void getAllItem(final Context context, DatabaseReference mRef); //dipanggil oleh event input control, mis. onClick
        void listenAllItem(final Context context, DatabaseReference mRef);
        void getItemByCondition(U searchedItem);

        //return only one item
        void getItemById(final Context context, DatabaseReference mRef, String searchedId);
    }
}

package teknodesa.devlops.pantaujuma.contracts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.realm.RealmList;

/**
 *
 * @author Roy Deddy Tobing
 */
public class CRUDSelectContract {

    public interface View {

        void showNotification(String title, String header, String message); //dipanggil terjadi add, delete dan update
    }

    public interface Controller<U> {
        void addItem(U item);
        void updateItem(int idItem, U item);
        void deleteItem(int idItem);

        RealmList<U> getAllItem();
        U getSingleItemById(int idItem);

        void responseCRUD(boolean status); //dipanggil setelah data sudah diterima dari  Repository
    }

    public interface Repository<U> {
        void addItem(U item);
        void updateItem(int idItem, U item);
        void deleteItem(int idItem);

        RealmList<U> getAllItem();
        U getSingleItemById(int idItem);
    }
}

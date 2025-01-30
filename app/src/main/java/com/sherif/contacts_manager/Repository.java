package com.sherif.contacts_manager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {

        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();
    }

    public void addContact(Contacts contact) {
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact) {
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return contactDAO.getAllContacts();
    }

}

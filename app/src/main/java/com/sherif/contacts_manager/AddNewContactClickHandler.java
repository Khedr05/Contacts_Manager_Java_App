package com.sherif.contacts_manager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitedBtnClick(View view){

        if(contact.getName() == null || contact.getEmail() == null) {
            Toast.makeText(context, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context,MainActivity.class);
//            i.putExtra("Name",contact.getName());
//            i.putExtra("Email",contact.getEmail());

            Contacts newContact = new Contacts(contact.getEmail(),contact.getName());
            myViewModel.addContact(newContact);

            context.startActivity(i);
        }

    }
}

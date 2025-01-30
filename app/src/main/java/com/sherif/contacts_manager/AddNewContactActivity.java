package com.sherif.contacts_manager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.sherif.contacts_manager.databinding.ActivityAddNewContactBinding;


public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler clickHandler;
    private Contacts contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact);

        contact = new Contacts();
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);
        clickHandler = new AddNewContactClickHandler(contact,this,myViewModel);

        binding.setContact(contact);
        binding.setClickHandler(clickHandler);



    }
}
package parcero.uv.contactlist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter databaseAdapter;
    RecyclerView rvContactList;
    ContactsAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseAdapter = new DatabaseAdapter(this);
        contactList = databaseAdapter.getAllContacts();
        rvContactList = findViewById(R.id.rvContacts);
        rvContactList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvContactList.setLayoutManager(layoutManager);
        contactsAdapter = new ContactsAdapter(this, contactList, rvContactList);
        rvContactList.setAdapter(contactsAdapter);
    }
}
package parcero.uv.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    Context context;
    List<Contact> contactsList;
    RecyclerView rvContactList;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowId;
        TextView rowName;
        TextView rowEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowId = itemView.findViewById(R.id.item_id);
            rowName = itemView.findViewById(R.id.item_name);
            rowEmail = itemView.findViewById(R.id.item_email);
        }
    }

    public ContactsAdapter(Context context, List<Contact> contactsList, RecyclerView rvContactList) {
        this.context = context;
        this.contactsList = contactsList;
        this.rvContactList = rvContactList;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, viewGroup, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int i) {
        Contact contact = contactsList.get(i);
        viewHolder.rowId.setText("" + contact.getId());
        viewHolder.rowName.setText(contact.getName());
        viewHolder.rowEmail.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvContactList.getChildLayoutPosition(v);
            String item = contactsList.get(itemPosition).getName();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();
        }
    }
}
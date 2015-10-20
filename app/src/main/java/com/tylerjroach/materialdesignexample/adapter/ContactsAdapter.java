package com.tylerjroach.materialdesignexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import com.tylerjroach.materialdesignexample.model.Contact;
import com.tylerjroach.materialdesignexample.R;
import com.tylerjroach.materialdesignexample.util.CircleTransform;
import java.util.ArrayList;

/**
 * Created by tylerjroach on 10/17/15.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
  private ArrayList<Contact> contacts;
  private Context context;


  public static class ContactViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.name) TextView name;
    @Bind(R.id.username) TextView username;
    @Bind(R.id.profile_photo) ImageView profilePhoto;

    public ContactViewHolder(View v) {
      super(v);
      ButterKnife.bind(this, v);
    }
  }

  public ContactsAdapter(ArrayList<Contact> contacts, Context context) {
    this.contacts = contacts;
    this.context = context;
  }

  @Override public ContactsAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact, parent, false);

    ContactViewHolder vh = new ContactViewHolder(v);
    return vh;
  }

  @Override public void onBindViewHolder(ContactViewHolder holder, int position) {

    Contact contact = contacts.get(position);

    holder.name.setText(contact.getName());
    holder.username.setText(contact.getUsername());

    Picasso.with(context).load(contact.getProfilePhotoUrl())
        .placeholder(R.drawable.ic_person_grey600_24dp)
        .transform(new CircleTransform())
        .into(holder.profilePhoto);

  }

  @Override public int getItemCount() {
    return contacts.size();
  }
}
package com.tylerjroach.materialdesignexample.ui;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.tylerjroach.materialdesignexample.R;
import com.tylerjroach.materialdesignexample.adapter.ContactsAdapter;
import com.tylerjroach.materialdesignexample.model.Contact;
import java.util.ArrayList;

public class ContactsFragment extends BaseFragment {

  @Bind(R.id.recycler_view) RecyclerView recyclerView;

  private ContactsAdapter contactsAdapter;
  private LinearLayoutManager layoutManager;
  private ArrayList<Contact> contacts;


  public static ContactsFragment newInstance() {
    ContactsFragment fragment = new ContactsFragment();
    return fragment;
  }

  public ContactsFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    contacts = new ArrayList<>();

    contacts.add(new Contact("Tyler Roach", "@tylerjroach", "https://avatars3.githubusercontent.com/u/634763?v=3&s=460"));
    contacts.add(new Contact("Jeremy Martin", "@jmar777", "https://avatars2.githubusercontent.com/u/183199?v=3&s=400"));
    contacts.add(new Contact("Josh Skidmore", "@joshskidmore", "https://avatars1.githubusercontent.com/u/255734?v=3&s=400"));
    contacts.add(new Contact("Bryan Gilbert", "@gilbertw1", "https://avatars0.githubusercontent.com/u/142303?v=3&s=460"));
    contacts.add(new Contact("Jonathan Spohn", "@spohn", "https://avatars1.githubusercontent.com/u/1420991?v=3&s=460"));
    contacts.add(new Contact("Bobby Strickland", "@bcstrickland", "https://avatars1.githubusercontent.com/u/1774585?v=3&s=460"));
    contacts.add(new Contact("Jono Young", "@chsweb", "https://avatars3.githubusercontent.com/u/873222?v=3&s=460"));
    contacts.add(new Contact("Rohit Krishnan", "@rkrishnan2012", "https://avatars0.githubusercontent.com/u/1313767?v=3&s=460"));
    contacts.add(new Contact("Dan Smith", "@dansmithsc", "https://avatars3.githubusercontent.com/u/994827?v=3&s=460"));

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
    ButterKnife.bind(this, rootView);

    contactsAdapter = new ContactsAdapter(contacts, ACA);
    layoutManager = new LinearLayoutManager(ACA);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    recyclerView.setAdapter(contactsAdapter);
    recyclerView.setLayoutManager(layoutManager);


    return rootView;
  }
}

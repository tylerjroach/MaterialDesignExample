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
import com.tylerjroach.materialdesignexample.adapter.MessagesAdapter;
import com.tylerjroach.materialdesignexample.model.Contact;
import com.tylerjroach.materialdesignexample.model.Message;
import java.util.ArrayList;

public class MessagesFragment extends BaseFragment {

  @Bind(R.id.recycler_view) RecyclerView recyclerView;

  private MessagesAdapter messagesAdapter;
  private LinearLayoutManager layoutManager;
  private ArrayList<Message> messages;

  public static MessagesFragment newInstance() {
    MessagesFragment fragment = new MessagesFragment();
    return fragment;
  }

  public MessagesFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    messages = new ArrayList<>();
    messages.add(new Message(new Contact("Jono Young", "@chsweb", "https://avatars3.githubusercontent.com/u/873222?v=3&s=460"), "Lets meet at 2 to practice on the presentation."));
    messages.add(new Message(new Contact("Rohit Krishnan", "@rkrishnan2012", "https://avatars0.githubusercontent.com/u/1313767?v=3&s=460"), "Are you ready to push the GoPro changes to the master branch? I've tested it for an hour or so and I haven't seen any issues come up."));
    messages.add(new Message(new Contact("Dan Smith", "@dansmithsc", "https://avatars3.githubusercontent.com/u/994827?v=3&s=460"), "I found a bug..."));
    messages.add(new Message(new Contact("Bobby Strickland", "@bcstrickland", "https://avatars1.githubusercontent.com/u/1774585?v=3&s=460"), "android > ios"));
    messages.add(new Message(new Contact("Jeremy Martin", "@jmar777", "https://avatars2.githubusercontent.com/u/183199?v=3&s=400"), "Net update looks great"));
    messages.add(new Message(new Contact("Josh Skidmore", "@joshskidmore", "https://avatars1.githubusercontent.com/u/255734?v=3&s=400"), "New web update posted."));
    messages.add(new Message(new Contact("Bryan Gilbert", "@gilbertw1", "https://avatars0.githubusercontent.com/u/142303?v=3&s=460"), "Sounds good."));
    messages.add(new Message(new Contact("Jonathan Spohn", "@spohn", "https://avatars1.githubusercontent.com/u/1420991?v=3&s=460"), "Sure"));
    messages.add(new Message(new Contact("Tyler Roach", "@tylerjroach", "https://avatars3.githubusercontent.com/u/634763?v=3&s=460"), "How are you?"));

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_messages, container, false);
    ButterKnife.bind(this, rootView);

    messagesAdapter = new MessagesAdapter(messages, ACA);
    layoutManager = new LinearLayoutManager(ACA);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    recyclerView.setAdapter(messagesAdapter);
    recyclerView.setLayoutManager(layoutManager);

    return rootView;
  }
}

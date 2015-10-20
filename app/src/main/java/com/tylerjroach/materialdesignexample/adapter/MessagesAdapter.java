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
import com.tylerjroach.materialdesignexample.R;
import com.tylerjroach.materialdesignexample.model.Contact;
import com.tylerjroach.materialdesignexample.model.Message;
import com.tylerjroach.materialdesignexample.util.CircleTransform;
import java.util.ArrayList;

/**
 * Created by tylerjroach on 10/17/15.
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
  private ArrayList<Message> messages;
  private Context context;


  public static class MessageViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.name) TextView name;
    @Bind(R.id.message) TextView message;
    @Bind(R.id.profile_photo) ImageView profilePhoto;

    public MessageViewHolder(View v) {
      super(v);
      ButterKnife.bind(this, v);
    }
  }

  public MessagesAdapter(ArrayList<Message> messages, Context context) {
    this.messages = messages;
    this.context = context;
  }

  @Override public MessagesAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_message, parent, false);

    MessageViewHolder vh = new MessageViewHolder(v);
    return vh;
  }

  @Override public void onBindViewHolder(MessageViewHolder holder, int position) {

    Message message = messages.get(position);
    Contact contact = message.getContact();

    holder.name.setText(contact.getName());
    holder.message.setText(message.getMessage());

    Picasso.with(context).load(contact.getProfilePhotoUrl())
        .placeholder(R.drawable.ic_person_grey600_24dp)
        .transform(new CircleTransform())
        .into(holder.profilePhoto);

  }

  @Override public int getItemCount() {
    return messages.size();
  }
}
package com.android.lgas.lgas_states_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.lgas.lgainfolist.entitities.LocalGovernmentAreaInfo;
import java.util.List;

/**
 * Created by Michael Okuboyejo on 7/15/16.
 * Phase Shift Labs
 * mykelokuboyejo@gmail.com
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

  private Context context;
  OnItemClickListener mItemClickListener;
  private List<LocalGovernmentAreaInfo> mItems;

  public RecyclerViewAdapter(Context context, List<LocalGovernmentAreaInfo> mItems){
    this.context = context;
    this.mItems = mItems;
  }


  @Override
  public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(context).inflate(R.layout.local_goverment_item_layout, parent, false);
    return new RecyclerViewHolder(v);
  }

  public int getSize(){
    return mItems.size();
  }

  public void addAll(List<LocalGovernmentAreaInfo> items) {
    int pos = getItemCount();
    mItems.addAll(items);
    notifyItemRangeInserted(pos, mItems.size());
  }

  public LocalGovernmentAreaInfo getLocalGovernmentItem(int position){
    return mItems.get(position);
  }

  public String getLgaName(int position){
    return mItems.get(position).getName();
  }

  public String getStateCode(int position) {
    return mItems.get(position).getStateCode();
  }

  @Override
  public void onBindViewHolder(RecyclerViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount()    {
    return mItems.size();
  }

  class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private RelativeLayout itemHolder;
    private TextView mLgaTextView;
    private TextView mStateCodeTextView;
    private TextView mStateNameTextView;
    private TextView mLatTextView;
    private TextView mLongTextView;

    public RecyclerViewHolder(View itemView) {
      super(itemView);
      itemHolder = (RelativeLayout)itemView.findViewById(R.id.item_holder);
      mLgaTextView = (TextView) itemView.findViewById(R.id.local_government_header_textview);
      mStateCodeTextView = (TextView) itemView.findViewById(R.id.local_government_state_code_text);
      mStateNameTextView = (TextView) itemView.findViewById(R.id.local_government_state_text);
      mLatTextView = (TextView) itemView.findViewById(R.id.local_government_latitude_text_view);
      mLongTextView = (TextView) itemView.findViewById(R.id.local_government_longitude_text_view);
      itemHolder.setOnClickListener(this);

    }

    public void bind(int position) {
      mLgaTextView.setText(mItems.get(position).getName());
      mStateCodeTextView.setText(mItems.get(position).getStateCode());
      mLatTextView.setText(String.format(context.getResources().getString(R.string.latitude_text),mItems.get(
          position).getLatitude()));
      mLongTextView.setText(String.format(context.getResources().getString(R.string.longitude_text),
          mItems.get(position).getLongitude()));
      mStateNameTextView.setText(mItems.get(position).getState());
    }

    @Override public void onClick(View v) {
      if(mItemClickListener != null){
        mItemClickListener.onItemClick(itemView, getPosition());
      }
    }
  }


  public interface OnItemClickListener {
    void onItemClick(View view, int position);
  }

  public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.mItemClickListener = mItemClickListener;
  }
}

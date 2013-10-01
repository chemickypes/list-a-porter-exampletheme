package com.android.angelo.widget;

import java.util.ArrayList;

import com.android.angelo.listaporter.R;
import com.android.angelo.usedobject.ListItem;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	private class ViewHolder{
		public TextView nome;
		public TextView desc;
		public TextView data;
		public TextView bigD;
	}
	
	boolean orientation ; //true landscape, false portrait
	ArrayList<ListItem> data;
	Context mContext;
	LayoutInflater mLayoutInflater;
	ViewHolder mViewHolder;
	
	public ListAdapter(Context context, ArrayList<ListItem> data) {
		this.data = data;
		this.mContext = context;
		this.mLayoutInflater = (LayoutInflater) 
				this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.orientation = false;
	}
	
	public ListAdapter(Context context, ArrayList<ListItem> data,boolean orientation) {
		this.data = data;
		this.mContext = context;
		this.mLayoutInflater = (LayoutInflater) 
				this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.orientation = orientation;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		SharedPreferences pr = PreferenceManager.getDefaultSharedPreferences(mContext);
		mViewHolder = null;
		if(view == null){
			view = mLayoutInflater.inflate(R.layout.list_item_layout, null);
			mViewHolder = new ViewHolder();
			mViewHolder.nome = (TextView) view.findViewById(R.id.textView_Nome);
			mViewHolder.desc = (TextView) view.findViewById(R.id.textView_Desc);
			mViewHolder.data = (TextView) view.findViewById(R.id.textView_Data);
			mViewHolder.bigD = (TextView) view.findViewById(R.id.textView_BigD);
			view.setTag(mViewHolder);
		}else{
			mViewHolder = (ViewHolder) view.getTag();
		}
		final ListItem item = (ListItem) data.get(position);
		mViewHolder.nome.setText(item.getmName(orientation));
		String color ;
		if(pr.getString("colors","1").equals("2")){
			color="#000066";
		}else if(pr.getString("colors","1").equals("3")){
			color="#FF0000";
		}else{
			color="#000000";
		}
		mViewHolder.nome.setTextColor(Color.parseColor(color));
		mViewHolder.desc.setText(item.getmDesc(orientation));
		if(pr.getString("formatdata", "2").equals("1")){
			item.setDateFormat(1);
		}else{
			item.setDateFormat(2);
		}
		mViewHolder.data.setText(item.getmDataString());
		if(pr.getBoolean("showBig", true)==true) mViewHolder.bigD.setText(item.getmValueString());
		return view;
	}
	
	public void add(Object ob){
		data.add((ListItem)ob);
	}
	
	public void remove(Object ob){
		data.remove(ob);
	}

}

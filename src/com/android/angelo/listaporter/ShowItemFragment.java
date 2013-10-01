package com.android.angelo.listaporter;

import com.android.angelo.usedobject.ListItem;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowItemFragment extends Fragment {
	
	class ViewHolder{
		public TextView nome;
		public TextView desc;
		public TextView data;
		public TextView bigD;
	}
	
	private ViewHolder holder = null;
	boolean visible = false;

	public ShowItemFragment() {
		// TODO Auto-generated constructor stub
	}
	
	// onCreate
	@Override
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	}

	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	     Bundle savedInstanceState) {
	     // Inflate the layout for this fragment
	     return inflater.inflate(R.layout.show_item_fragment_layout, container, false);
	 }
	 
	 public void  hideThis(){
		 getView().setVisibility(View.GONE);
		 this.visible = false;
	 }
	 
	 public void viewThis(){
		 getView().setVisibility(View.VISIBLE);
		 this.visible = true;
	 }
	 
	 public void setInfo(ListItem item){
		 if(holder == null){
			 holder = new ViewHolder();
			 holder.nome = (TextView) getView().findViewById(R.id.frag_nome);
			 holder.desc = (TextView) getView().findViewById(R.id.frag_desc);
			 holder.data = (TextView) getView().findViewById(R.id.frag_data);
			 holder.bigD = (TextView) getView().findViewById(R.id.frag_bigD);
		 }
		 holder.nome.setText(item.getmName());
		 holder.desc.setText(item.getmDesc());
		 holder.data.setText(item.getmDataString());
		 holder.bigD.setText(item.getmValueString());
		 
	 }

}

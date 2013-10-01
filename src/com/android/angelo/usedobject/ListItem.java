package com.android.angelo.usedobject;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ListItem {
	private String mName;
	private String mDesc;
	private Date mDate;
	private BigDecimal mValue;
	
	private DateFormat dateformat;
	
	public ListItem(String name, String desc, Date date, BigDecimal value)  {
		setDateFormat(2);
		
		setmName(name);
		setmDesc(desc);
		setmDate(date);
		setmValue(value);
		
	}

	public ListItem(String name, String desc, String date, String value) throws ParseException {
		
		setDateFormat(2);
		setmName(name);
		setmDesc(desc);
		setmDate(date);
		setmValue(value);
		
	}

	public String getmName() {
		return mName;
	}
	//questo metodo restituisce la stringa a seconda se ci si trovi
	//in orientation portrait o landscape
	public String getmName(boolean orientation){
		if(orientation==false && this.mName.length()>18){	
			return this.mName.substring(0, 15)+"...";	
		}else{
			return getmName();
		}
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDesc() {
		return mDesc;
	}
	//questo metodo restituisce la stringa a seconda se ci si trovi
		//in orientation portrait o landscape
	public String getmDesc(boolean orientation){
		if(orientation==false && this.mDesc.length()>18){
			return this.mDesc.substring(0, 15)+"...";
		}else if(this.mDesc.length()>58){
			return this.mDesc.substring(0, 55)+"...";
		}else{
			return getmDesc();
		}
	}

	public void setmDesc(String mDesc) {
		this.mDesc = mDesc;
	}

	public Date getmData() {
		return mDate;
	}
	
	public String getmDataString(){
		return dateformat.format(mDate);
	}

	public void setmDate(Date mData) {
		this.mDate = mData;
	}
	
	public void setmDate(String data) throws ParseException{
		Date d = dateformat.parse(data);
		setmDate(d);
	}

	public BigDecimal getmValue() {
		return mValue;
	}
	
	public String getmValueString(){
		return mValue.toString();
	}

	public void setmValue(BigDecimal mValue) {
		this.mValue = mValue;
	}
	
	public void setmValue(String value){
		this.mValue = new BigDecimal(value);
	}
	
	public void setDateFormat(int format){
		if(format==1){
			this.dateformat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
		}else{
			this.dateformat = new SimpleDateFormat("dd/MM/yyyy",Locale.ITALIAN);
		}
	}

}

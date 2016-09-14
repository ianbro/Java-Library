/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: May 24, 2016
 */
package com.ianmann.utils.data.structures;

import java.util.ArrayList;

/**
 * @TODO: TODO
 *
 * @author Ian
 * Created: May 24, 2016
 *
 */
public final class ByteList extends ArrayList<Byte>{

	public ByteList(int...bytes){
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public ByteList(int b, int times){
		for (int i = 0; i < times; i++) {
			this.add(b);
		}
	}
	
	public ByteList(Byte...bytes){
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public ByteList(byte[] bytes){
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public ByteList() {
		super();
	}
	
	public void add(Integer i) {
		this.add(i.byteValue());
	}
	
	public void addAll(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public void addAll(int[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public void addAll(Byte...bytes) {
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	public void addAll(Integer...bytes) {
		for (int i = 0; i < bytes.length; i++) {
			this.add(bytes[i]);
		}
	}
	
	/**
	 * adds b to this list {@code timesAdded} times
	 * @param b
	 * @param timesAdded
	 */
	public void addRepetition(byte b, int timesAdded) {
		for (int i = 0; i < timesAdded; i++) {
			this.add(b);
		}
	}
	
	/**
	 * adds b as a byte to this list {@code timesAdded} times
	 * @param b
	 * @param timesAdded
	 */
	public void addRepetition(int b, int timesAdded) {
		for (int i = 0; i < timesAdded; i++) {
			this.add(b);
		}
	}
	
	public ByteList join(ByteList...byteLists) {
		for (int i = 0; i < byteLists.length; i++) {
			this.addAll(byteLists[i]);
		}
		return this;
	}
	
	public ByteList join(ArrayList<ByteList> byteLists) {
		for (int i = 0; i < byteLists.size(); i++) {
			this.addAll(byteLists.get(i));
		}
		return this;
	}
	
	public int indexOfGroup(Byte...bytes) {
		for (int i = 0; i < this.size(); i++) {
			Byte current = this.get(i);
			/*
			 * If the first byte in the group of bytes searched for,
			 * check to see that each subsequent byte searched for
			 * is here.
			 */
			if (((byte) current) == ((byte) bytes[0])) {
				for (int j = 0; j < bytes.length; j++) {
					Byte currentCompare = this.get(i + j);
					/*
					 * If even one byte in the group is off, then this
					 * is not the group of bytes we wanted.
					 */
					if (((byte) currentCompare) != ((byte) bytes[j])) {
						continue;
					}
				}
				/*
				 * If this finishes, then we have found the bytes
				 * we were looking for.
				 */
				return i;
			}
		}
		/*
		 * If this finishes, then the bytes are not
		 * contained in this list.
		 */
		return -1;
	}
	
	public int indexOfGroup(ByteList bytes) {
		for (int i = 0; i < this.size(); i++) {
			Byte current = this.get(i);
			/*
			 * If the first byte in the group of bytes searched for,
			 * check to see that each subsequent byte searched for
			 * is here.
			 */
			boolean groupCorrect = true;
			if (((byte) current) == ((byte) bytes.get(0))) {
				for (int j = 0; j < bytes.size(); j++) {
					Byte currentCompare = this.get(i + j);
					/*
					 * If even one byte in the group is off, then this
					 * is not the group of bytes we wanted.
					 */
					if (((byte) currentCompare) != ((byte) bytes.get(j))) {
						groupCorrect = false;
						break;
					}
				}
				/*
				 * If this finishes, then we have found the bytes
				 * we were looking for.
				 */
				if (groupCorrect) {
					return i;
				}
			}
		}
		/*
		 * If this finishes, then the bytes are not
		 * contained in this list.
		 */
		return -1;
	}
	
	public boolean contains(Byte...bytes) {
		if (this.indexOfGroup(bytes) != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a sublist of this list starting at
	 * index of _from and ending at index _to inclusively.
	 * @param _from
	 * @param _to
	 * @return
	 */
	public ByteList slice(int _from, int _to) {
		ByteList bytes = new ByteList();
		for (int i = _from; i <= _to; i++) {
			bytes.add(this.get(i));
		}
		return bytes;
	}
	
	/**
	 * Returns a sublist of this list starting at
	 * index of _from and ending at first occurance
	 * of the group _to exclusively.
	 * @param _from
	 * @param _to
	 * @return
	 */
	public ByteList slice(int _from, ByteList _to) {
		ByteList bytes = new ByteList();
		for (int i = _from; i < this.indexOfGroup(_to); i++) {
			bytes.add(this.get(i));
		}
		return bytes;
	}
	
	/**
	 * Returns a sublist of this list starting at
	 * index of _from and ending at first occurance
	 * of the group _to exclusively.
	 * @param _from
	 * @param _to
	 * @return
	 */
	public ByteList slice(int _from, byte _to) {
		ByteList bytes = new ByteList();
		int endIndex = this.indexOfGroup(_to);
		for (int i = _from; i <= endIndex; i++) {
			bytes.add(this.get(i));
		}
		return bytes;
	}
	
	public ByteList between(ByteList _from, ByteList _to) {
		ByteList result = this.slice(this.indexOfGroup(_from) + _from.size(), _to);
		return result;
	}
	
	public ByteList flippedBytes() {
		ByteList flipped = new ByteList();
		for (int i = 0; i < this.size(); i++) {
			flipped.add((byte) ~ this.get(i));
		}
		return flipped;
	}
	
	public static ByteList flipBytes(byte[] bytes) {
		ByteList ret = new ByteList();
		for (int i = 0; i < bytes.length; i++) {
			ret.add(~ bytes[i]);
		}
		return ret;
	}
	
	public byte[] toPrimitive() {
		byte[] bytesPrimitive = new byte[this.size()];
		for (int i = 0; i < this.size(); i++) {
			bytesPrimitive[i] = this.get(i);
		}
		return bytesPrimitive;
	}
	
	public String stringValues() {
		return new String(this.toPrimitive());
	}
	
	public String toString() {
		String str = "[";
		
		for (int i = 0; i < this.size(); i++) {
			str = str + Integer.toHexString(this.get(i) & 0xff);
			if (i < this.size() - 1) {
				str = str + ",";
			}
		}
		
		str = str + "]";
		return str;
	}
	
	public static ArrayList<Byte> wrapperPrimitiveToByte(byte[] bytes) {
		ArrayList<Byte> bytesArrayList = new ArrayList<Byte>();
		for (int i = 0; i < bytes.length; i++) {
			bytesArrayList.add(bytes[i]);
		}
		return bytesArrayList;
	}
	
	/**
	 * Because an AccountFile flips the bytes in data it stores,
	 * we will "unflip" them and return the data as a string.
	 * @param bytes
	 * @return
	 */
	public static String fileBytesToTrueString(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) ~ bytes[i];
		}
		String retString = new String(bytes);
		
		/*
		 * because arrays remain changed after going through
		 * a method, we need to put bytes back to the way it
		 * came in.
		 */
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) ~ bytes[i];
		}
		
		return retString;
	}
	
}

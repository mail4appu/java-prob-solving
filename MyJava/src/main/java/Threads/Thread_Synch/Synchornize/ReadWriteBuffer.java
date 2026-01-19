package Threads.Thread_Synch.Synchornize;

public class ReadWriteBuffer {
	StringBuffer sb;

	public synchronized StringBuffer getSb() {
		return sb;
	}

	public synchronized void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	

}

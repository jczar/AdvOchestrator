package com.advorch.node.event;

public interface NodeEventNotifier {

	public void onNodeStart();
	public void onNodeEnd();
	public void onNodeFailed(Throwable t);
	public void onNodeSuspended();
	
}

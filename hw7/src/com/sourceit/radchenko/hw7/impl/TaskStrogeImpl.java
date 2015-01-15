package com.sourceit.radchenko.hw7.impl;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sourceit.radchenko.hw7.ITask;
import com.sourceit.radchenko.hw7.ITasksStorage;

public class TaskStrogeImpl implements ITasksStorage {
	private Queue<ITask> queue = new LinkedBlockingQueue<ITask>();

	@Override
	public void add(ITask task) throws NullPointerException {
		queue.add(task);
	}

	@Override
	public ITask get() {
		return queue.poll();
	}

	@Override
	public int count() {
		return queue.size();
	}

}

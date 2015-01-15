package com.sourceit.radchenko.hw7.impl;

import com.sourceit.radchenko.hw7.ITask;
import com.sourceit.radchenko.hw7.ITaskExecutor;
import com.sourceit.radchenko.hw7.ITasksStorage;

public class TaskExecutorImpl implements ITaskExecutor {

	private static final int MAX_TRY = 5;
	private static final int TIME_SLEEP = 100;
	private ITasksStorage tasks;
	private boolean started = false;
	private boolean stoped = false;

	@Override
	public void setStorage(ITasksStorage storage) throws NullPointerException {
		if (storage == null) {
			throw new NullPointerException();
		}
		tasks = storage;
	}

	@Override
	public ITasksStorage getStorage() {
		return tasks;
	}

	@Override
	public void start() throws NullPointerException, IllegalStateException {
		if (getStorage() == null) {
			throw new NullPointerException();
		}
		if (started) {
			throw new IllegalStateException();
		}
		started = true;

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {

				while (!stoped) {

					tryExecute();

					try {
						System.out.println("go to sleep "
								+ Thread.currentThread().getName());
						Thread.sleep(TIME_SLEEP);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();

	}

	private void tryExecute() {
		ITask task = tasks.get();
		if (task != null) {
			task.incTryCount();
			try {
				if (!task.execute()) {
					putBackTask(task);
				}
				System.out.println("executed "
						+ Thread.currentThread().getName());
			} catch (Exception e) {
				putBackTask(task);
			}
		}
	}

	private void putBackTask(ITask task) {
		int count = task.getTryCount();
		if (count <= MAX_TRY) {
			tasks.add(task);
			System.out.println("put back " + Thread.currentThread().getName());
		}
	}

	@Override
	public void stop() throws IllegalStateException {
		if (!started) {
			throw new IllegalStateException();
		}
		stoped = true;
		started = false;

	}

}

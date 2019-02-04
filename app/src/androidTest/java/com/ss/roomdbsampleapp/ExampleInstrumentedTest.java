package com.ss.roomdbsampleapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.ss.roomdbsampleapp.db.NotesEntity;
import com.ss.roomdbsampleapp.db.NotesRepository;
import com.ss.roomdbsampleapp.db.NotesViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
	@Test
	public void useAppContext() {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		assertEquals("com.ss.roomdbsampleapp", appContext.getPackageName());
	}

	private NotesRepository repo;

	@Test
	public void insertTest() throws InterruptedException {
		Context appContext = InstrumentationRegistry.getTargetContext();
		repo = new NotesRepository(appContext);
		String name = "Experiment";
		String number = "1234567890";
		String email = "email@email.com";

		NotesEntity entity = new NotesEntity();
		entity.setName(name);
		entity.setPhone_number(number);
		entity.setEmail(email);

		repo.insert(entity);
		Thread.sleep(2500);
	}
}
